// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template const_serializer.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver14;

import org.projectfloodlight.openflow.protocol.*;
import org.projectfloodlight.openflow.protocol.action.*;
import org.projectfloodlight.openflow.protocol.actionid.*;
import org.projectfloodlight.openflow.protocol.bsntlv.*;
import org.projectfloodlight.openflow.protocol.errormsg.*;
import org.projectfloodlight.openflow.protocol.meterband.*;
import org.projectfloodlight.openflow.protocol.instruction.*;
import org.projectfloodlight.openflow.protocol.instructionid.*;
import org.projectfloodlight.openflow.protocol.match.*;
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.queueprop.*;
import org.projectfloodlight.openflow.types.*;
import org.projectfloodlight.openflow.util.*;
import org.projectfloodlight.openflow.exceptions.*;
import org.projectfloodlight.openflow.protocol.OFBundleCtrlType;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;

public class OFBundleCtrlTypeSerializerVer14 {

    public final static short OPEN_REQUEST_VAL = (short) 0x0;
    public final static short OPEN_REPLY_VAL = (short) 0x1;
    public final static short CLOSE_REQUEST_VAL = (short) 0x2;
    public final static short CLOSE_REPLY_VAL = (short) 0x3;
    public final static short COMMIT_REQUEST_VAL = (short) 0x4;
    public final static short COMMIT_REPLY_VAL = (short) 0x5;
    public final static short DISCARD_REQUEST_VAL = (short) 0x6;
    public final static short DISCARD_REPLY_VAL = (short) 0x7;

    public static OFBundleCtrlType readFrom(ByteBuf bb) throws OFParseError {
        try {
            return ofWireValue(bb.readShort());
        } catch (IllegalArgumentException e) {
            throw new OFParseError(e);
        }
    }

    public static void writeTo(ByteBuf bb, OFBundleCtrlType e) {
        bb.writeShort(toWireValue(e));
    }

    public static void putTo(OFBundleCtrlType e, PrimitiveSink sink) {
        sink.putShort(toWireValue(e));
    }

    public static OFBundleCtrlType ofWireValue(short val) {
        switch(val) {
            case OPEN_REQUEST_VAL:
                return OFBundleCtrlType.OPEN_REQUEST;
            case OPEN_REPLY_VAL:
                return OFBundleCtrlType.OPEN_REPLY;
            case CLOSE_REQUEST_VAL:
                return OFBundleCtrlType.CLOSE_REQUEST;
            case CLOSE_REPLY_VAL:
                return OFBundleCtrlType.CLOSE_REPLY;
            case COMMIT_REQUEST_VAL:
                return OFBundleCtrlType.COMMIT_REQUEST;
            case COMMIT_REPLY_VAL:
                return OFBundleCtrlType.COMMIT_REPLY;
            case DISCARD_REQUEST_VAL:
                return OFBundleCtrlType.DISCARD_REQUEST;
            case DISCARD_REPLY_VAL:
                return OFBundleCtrlType.DISCARD_REPLY;
            default:
                throw new IllegalArgumentException("Illegal wire value for type OFBundleCtrlType in version 1.4: " + val);
        }
    }


    public static short toWireValue(OFBundleCtrlType e) {
        switch(e) {
            case OPEN_REQUEST:
                return OPEN_REQUEST_VAL;
            case OPEN_REPLY:
                return OPEN_REPLY_VAL;
            case CLOSE_REQUEST:
                return CLOSE_REQUEST_VAL;
            case CLOSE_REPLY:
                return CLOSE_REPLY_VAL;
            case COMMIT_REQUEST:
                return COMMIT_REQUEST_VAL;
            case COMMIT_REPLY:
                return COMMIT_REPLY_VAL;
            case DISCARD_REQUEST:
                return DISCARD_REQUEST_VAL;
            case DISCARD_REPLY:
                return DISCARD_REPLY_VAL;
            default:
                throw new IllegalArgumentException("Illegal enum value for type OFBundleCtrlType in version 1.4: " + e);
        }
    }

}
