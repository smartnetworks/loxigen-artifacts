// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template const_serializer.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver10;

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
import org.projectfloodlight.openflow.protocol.OFPortModFailedCode;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;

public class OFPortModFailedCodeSerializerVer10 {

    public final static short BAD_PORT_VAL = (short) 0x0;
    public final static short BAD_HW_ADDR_VAL = (short) 0x1;

    public static OFPortModFailedCode readFrom(ByteBuf bb) throws OFParseError {
        try {
            return ofWireValue(bb.readShort());
        } catch (IllegalArgumentException e) {
            throw new OFParseError(e);
        }
    }

    public static void writeTo(ByteBuf bb, OFPortModFailedCode e) {
        bb.writeShort(toWireValue(e));
    }

    public static void putTo(OFPortModFailedCode e, PrimitiveSink sink) {
        sink.putShort(toWireValue(e));
    }

    public static OFPortModFailedCode ofWireValue(short val) {
        switch(val) {
            case BAD_PORT_VAL:
                return OFPortModFailedCode.BAD_PORT;
            case BAD_HW_ADDR_VAL:
                return OFPortModFailedCode.BAD_HW_ADDR;
            default:
                throw new IllegalArgumentException("Illegal wire value for type OFPortModFailedCode in version 1.0: " + val);
        }
    }


    public static short toWireValue(OFPortModFailedCode e) {
        switch(e) {
            case BAD_PORT:
                return BAD_PORT_VAL;
            case BAD_HW_ADDR:
                return BAD_HW_ADDR_VAL;
            default:
                throw new IllegalArgumentException("Illegal enum value for type OFPortModFailedCode in version 1.0: " + e);
        }
    }

}
