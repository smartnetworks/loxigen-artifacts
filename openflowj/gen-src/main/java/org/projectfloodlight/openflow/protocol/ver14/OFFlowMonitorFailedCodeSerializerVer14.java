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
import org.projectfloodlight.openflow.protocol.OFFlowMonitorFailedCode;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;

public class OFFlowMonitorFailedCodeSerializerVer14 {

    public final static short UNKNOWN_VAL = (short) 0x0;
    public final static short MONITOR_EXISTS_VAL = (short) 0x1;
    public final static short INVALID_MONITOR_VAL = (short) 0x2;
    public final static short UNKNOWN_MONITOR_VAL = (short) 0x3;
    public final static short BAD_COMMAND_VAL = (short) 0x4;
    public final static short BAD_FLAGS_VAL = (short) 0x5;
    public final static short BAD_TABLE_ID_VAL = (short) 0x6;
    public final static short BAD_OUT_VAL = (short) 0x7;

    public static OFFlowMonitorFailedCode readFrom(ByteBuf bb) throws OFParseError {
        try {
            return ofWireValue(bb.readShort());
        } catch (IllegalArgumentException e) {
            throw new OFParseError(e);
        }
    }

    public static void writeTo(ByteBuf bb, OFFlowMonitorFailedCode e) {
        bb.writeShort(toWireValue(e));
    }

    public static void putTo(OFFlowMonitorFailedCode e, PrimitiveSink sink) {
        sink.putShort(toWireValue(e));
    }

    public static OFFlowMonitorFailedCode ofWireValue(short val) {
        switch(val) {
            case UNKNOWN_VAL:
                return OFFlowMonitorFailedCode.UNKNOWN;
            case MONITOR_EXISTS_VAL:
                return OFFlowMonitorFailedCode.MONITOR_EXISTS;
            case INVALID_MONITOR_VAL:
                return OFFlowMonitorFailedCode.INVALID_MONITOR;
            case UNKNOWN_MONITOR_VAL:
                return OFFlowMonitorFailedCode.UNKNOWN_MONITOR;
            case BAD_COMMAND_VAL:
                return OFFlowMonitorFailedCode.BAD_COMMAND;
            case BAD_FLAGS_VAL:
                return OFFlowMonitorFailedCode.BAD_FLAGS;
            case BAD_TABLE_ID_VAL:
                return OFFlowMonitorFailedCode.BAD_TABLE_ID;
            case BAD_OUT_VAL:
                return OFFlowMonitorFailedCode.BAD_OUT;
            default:
                throw new IllegalArgumentException("Illegal wire value for type OFFlowMonitorFailedCode in version 1.4: " + val);
        }
    }


    public static short toWireValue(OFFlowMonitorFailedCode e) {
        switch(e) {
            case UNKNOWN:
                return UNKNOWN_VAL;
            case MONITOR_EXISTS:
                return MONITOR_EXISTS_VAL;
            case INVALID_MONITOR:
                return INVALID_MONITOR_VAL;
            case UNKNOWN_MONITOR:
                return UNKNOWN_MONITOR_VAL;
            case BAD_COMMAND:
                return BAD_COMMAND_VAL;
            case BAD_FLAGS:
                return BAD_FLAGS_VAL;
            case BAD_TABLE_ID:
                return BAD_TABLE_ID_VAL;
            case BAD_OUT:
                return BAD_OUT_VAL;
            default:
                throw new IllegalArgumentException("Illegal enum value for type OFFlowMonitorFailedCode in version 1.4: " + e);
        }
    }

}
