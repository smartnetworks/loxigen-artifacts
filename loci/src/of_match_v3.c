/* Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University */
/* Copyright (c) 2011, 2012 Open Networking Foundation */
/* Copyright (c) 2012, 2013 Big Switch Networks, Inc. */
/* See the file LICENSE.loci which should have been included in the source distribution */
#ifdef __GNUC__

#ifdef __linux__
/* glibc */
#include <features.h>
#else
/* NetBSD etc */
#include <sys/cdefs.h>
#ifdef __GNUC_PREREQ__
#define __GNUC_PREREQ __GNUC_PREREQ__
#endif
#endif

#ifndef __GNUC_PREREQ
/* fallback */
#define __GNUC_PREREQ(maj, min) 0
#endif

#if __GNUC_PREREQ(4,6)
#pragma GCC diagnostic ignored "-Wunused-but-set-variable"
#endif

#endif

#include "loci_log.h"
#include "loci_int.h"

static void
of_match_v3_push_wire_types(of_object_t *obj)
{
    unsigned char *buf = OF_OBJECT_BUFFER_INDEX(obj, 0);
    switch (obj->version) {
    case OF_VERSION_1_2:
    case OF_VERSION_1_3:
        *(uint16_t *)(buf + 0) = htobe16(0x1); /* type */
        break;
    default:
        UNREACHABLE();
    }
}


/**
 * \defgroup of_match_v3 of_match_v3
 */

/**
 * Helper function to push values into the wire buffer
 */
static inline int
of_match_v3_push_wire_values(of_match_v3_t *obj)
{

    of_match_v3_push_wire_types(obj);

    /* TLV obj; set length */
    of_tlv16_wire_length_set((of_object_t *)obj, obj->length);

    return OF_ERROR_NONE;
}

/**
 * Create a new of_match_v3 object
 *
 * @param version The wire version to use for the object
 * @return Pointer to the newly create object or NULL on error
 *
 * Initializes the new object with it's default fixed length associating
 * a new underlying wire buffer.
 *
 * Use new_from_message to bind an existing message to a message object,
 * or a _get function for non-message objects.
 *
 * \ingroup of_match_v3
 */

of_match_v3_t *
of_match_v3_new(of_version_t version)
{
    of_match_v3_t *obj;
    int bytes;

    bytes = of_object_fixed_len[version][OF_MATCH_V3] + of_object_extra_len[version][OF_MATCH_V3];

    /* Allocate a maximum-length wire buffer assuming we'll be appending to it. */
    if ((obj = (of_match_v3_t *)of_object_new(OF_WIRE_BUFFER_MAX_LENGTH)) == NULL) {
        return NULL;
    }

    of_match_v3_init(obj, version, bytes, 0);

    if (of_match_v3_push_wire_values(obj) < 0) {
        FREE(obj);
        return NULL;
    }

    return obj;
}

/**
 * Initialize an object of type of_match_v3.
 *
 * @param obj Pointer to the object to initialize
 * @param version The wire version to use for the object
 * @param bytes How many bytes in the object
 * @param clean_wire Boolean: If true, clear the wire object control struct
 *
 * If bytes < 0, then the default fixed length is used for the object
 *
 * This is a "coerce" function that sets up the pointers for the
 * accessors properly.
 *
 * If anything other than 0 is passed in for the buffer size, the underlying
 * wire buffer will have 'grow' called.
 */

void
of_match_v3_init(of_match_v3_t *obj,
    of_version_t version, int bytes, int clean_wire)
{

    LOCI_ASSERT(of_object_fixed_len[version][OF_MATCH_V3] >= 0);
    if (clean_wire) {
        MEMSET(obj, 0, sizeof(*obj));
    }
    if (bytes < 0) {
        bytes = of_object_fixed_len[version][OF_MATCH_V3] + of_object_extra_len[version][OF_MATCH_V3];
    }
    obj->version = version;
    obj->length = bytes;
    obj->object_id = OF_MATCH_V3;

    /* Set up the object's function pointers */

    obj->wire_type_set = of_match_v3_push_wire_types;

    obj->wire_length_set = of_tlv16_wire_length_set;

    obj->wire_length_get = of_tlv16_wire_length_get;

    /* Grow the wire buffer */
    if (obj->wire_object.wbuf != NULL) {
        int tot_bytes;

        tot_bytes = bytes + obj->wire_object.obj_offset;
        of_wire_buffer_grow(obj->wire_object.wbuf, tot_bytes);
    }
}


/**
 * Bind an object of type of_list_oxm_t to the parent of type of_match_v3 for
 * member oxm_list
 * @param obj Pointer to an object of type of_match_v3.
 * @param oxm_list Pointer to the child object of type
 * of_list_oxm_t to be filled out.
 * \ingroup of_match_v3
 *
 * The parameter oxm_list is filled out to point to the same underlying
 * wire buffer as its parent.
 *
 */
void
of_match_v3_oxm_list_bind(
    of_match_v3_t *obj,
    of_list_oxm_t *oxm_list)
{
    of_wire_buffer_t *wbuf;
    int offset = 0; /* Offset of value relative to the start obj */
    int abs_offset; /* Offset of value relative to start of wbuf */
    of_version_t ver;
    int cur_len = 0; /* Current length of object data */

    LOCI_ASSERT(obj->object_id == OF_MATCH_V3);
    ver = obj->version;
    wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    /* By version, determine offset and current length (where needed) */
    switch (ver) {
    case OF_VERSION_1_2:
    case OF_VERSION_1_3:
        offset = 4;
        cur_len = wire_match_len(obj, 0) - 4;
        break;
    default:
        LOCI_ASSERT(0);
    }

    abs_offset = OF_OBJECT_ABSOLUTE_OFFSET(obj, offset);
    LOCI_ASSERT(abs_offset >= 0);
    LOCI_ASSERT(cur_len >= 0 && cur_len < 64 * 1024);

    /* Initialize child */
    of_list_oxm_init(oxm_list, obj->version, 0, 1);
    /* Attach to parent */
    oxm_list->parent = (of_object_t *)obj;
    oxm_list->wire_object.wbuf = obj->wire_object.wbuf;
    oxm_list->wire_object.obj_offset = abs_offset;
    oxm_list->wire_object.owned = 0;
    oxm_list->length = cur_len;

    OF_LENGTH_CHECK_ASSERT(obj);

    return ;
}

/**
 * Create a copy of oxm_list into a new variable of type of_list_oxm_t from
 * a of_match_v3 instance.
 *
 * @param obj Pointer to the source of type of_match_v3_t
 * @returns A pointer to a new instance of type of_list_oxm_t whose contents
 * match that of oxm_list from source
 * @returns NULL if an error occurs
 */
of_list_oxm_t *
of_match_v3_oxm_list_get(of_match_v3_t *obj) {
    of_list_oxm_t _oxm_list;
    of_list_oxm_t *_oxm_list_ptr;

    of_match_v3_oxm_list_bind(obj, &_oxm_list);
    _oxm_list_ptr = (of_list_oxm_t *)of_object_dup(&_oxm_list);
    return _oxm_list_ptr;
}

/**
 * Set oxm_list in an object of type of_match_v3.
 * @param obj Pointer to an object of type of_match_v3.
 * @param oxm_list Pointer to the child of type of_list_oxm_t.
 *
 * If the child's wire buffer is the same as the parent's, then
 * nothing is done as the changes have already been registered in the
 * parent.  Otherwise, the data in the child's wire buffer is inserted
 * into the parent's and the appropriate lengths are updated.
 */
int WARN_UNUSED_RESULT
of_match_v3_oxm_list_set(
    of_match_v3_t *obj,
    of_list_oxm_t *oxm_list)
{
    of_wire_buffer_t *wbuf;
    int offset = 0; /* Offset of value relative to the start obj */
    int abs_offset; /* Offset of value relative to start of wbuf */
    of_version_t ver;
    int cur_len = 0; /* Current length of object data */
    int new_len, delta; /* For set, need new length and delta */

    LOCI_ASSERT(obj->object_id == OF_MATCH_V3);
    ver = obj->version;
    wbuf = OF_OBJECT_TO_WBUF(obj);
    LOCI_ASSERT(wbuf != NULL);

    /* By version, determine offset and current length (where needed) */
    switch (ver) {
    case OF_VERSION_1_2:
    case OF_VERSION_1_3:
        offset = 4;
        cur_len = wire_match_len(obj, 0) - 4;
        break;
    default:
        LOCI_ASSERT(0);
    }

    abs_offset = OF_OBJECT_ABSOLUTE_OFFSET(obj, offset);
    LOCI_ASSERT(abs_offset >= 0);
    LOCI_ASSERT(cur_len >= 0 && cur_len < 64 * 1024);

    /* LOCI object type */
    new_len = oxm_list->length;
    /* If underlying buffer already shared; nothing to do */
    if (obj->wire_object.wbuf == oxm_list->wire_object.wbuf) {
        of_wire_buffer_grow(wbuf, abs_offset + new_len);
        /* Verify that the offsets are correct */
        LOCI_ASSERT(abs_offset == OF_OBJECT_ABSOLUTE_OFFSET(oxm_list, 0));
        /* LOCI_ASSERT(new_len == cur_len); */ /* fixme: may fail for OXM lists */
        return OF_ERROR_NONE;
    }

    /* Otherwise, replace existing object in data buffer */
    of_wire_buffer_replace_data(wbuf, abs_offset, cur_len,
        OF_OBJECT_BUFFER_INDEX(oxm_list, 0), new_len);

    /* @fixme Shouldn't this precede copying value's data to buffer? */
    if (oxm_list->wire_length_set != NULL) {
        oxm_list->wire_length_set((of_object_t *)oxm_list, oxm_list->length);
    }

    /* Not scalar, update lengths if needed */
    delta = new_len - cur_len;
    if (delta != 0) {
        /* Update parent(s) */
        of_object_parent_length_update((of_object_t *)obj, delta);
    }

    OF_LENGTH_CHECK_ASSERT(obj);

    return OF_ERROR_NONE;
}
