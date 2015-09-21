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
import org.projectfloodlight.openflow.protocol.OFMeterModFailedCode;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;

public class OFMeterModFailedCodeSerializerVer14 {

    public final static short UNKNOWN_VAL = (short) 0x0;
    public final static short METER_EXISTS_VAL = (short) 0x1;
    public final static short INVALID_METER_VAL = (short) 0x2;
    public final static short UNKNOWN_METER_VAL = (short) 0x3;
    public final static short BAD_COMMAND_VAL = (short) 0x4;
    public final static short BAD_FLAGS_VAL = (short) 0x5;
    public final static short BAD_RATE_VAL = (short) 0x6;
    public final static short BAD_BURST_VAL = (short) 0x7;
    public final static short BAD_BAND_VAL = (short) 0x8;
    public final static short BAD_BAND_VALUE_VAL = (short) 0x9;
    public final static short OUT_OF_METERS_VAL = (short) 0xa;
    public final static short OUT_OF_BANDS_VAL = (short) 0xb;

    public static OFMeterModFailedCode readFrom(ByteBuf bb) throws OFParseError {
        try {
            return ofWireValue(bb.readShort());
        } catch (IllegalArgumentException e) {
            throw new OFParseError(e);
        }
    }

    public static void writeTo(ByteBuf bb, OFMeterModFailedCode e) {
        bb.writeShort(toWireValue(e));
    }

    public static void putTo(OFMeterModFailedCode e, PrimitiveSink sink) {
        sink.putShort(toWireValue(e));
    }

    public static OFMeterModFailedCode ofWireValue(short val) {
        switch(val) {
            case UNKNOWN_VAL:
                return OFMeterModFailedCode.UNKNOWN;
            case METER_EXISTS_VAL:
                return OFMeterModFailedCode.METER_EXISTS;
            case INVALID_METER_VAL:
                return OFMeterModFailedCode.INVALID_METER;
            case UNKNOWN_METER_VAL:
                return OFMeterModFailedCode.UNKNOWN_METER;
            case BAD_COMMAND_VAL:
                return OFMeterModFailedCode.BAD_COMMAND;
            case BAD_FLAGS_VAL:
                return OFMeterModFailedCode.BAD_FLAGS;
            case BAD_RATE_VAL:
                return OFMeterModFailedCode.BAD_RATE;
            case BAD_BURST_VAL:
                return OFMeterModFailedCode.BAD_BURST;
            case BAD_BAND_VAL:
                return OFMeterModFailedCode.BAD_BAND;
            case BAD_BAND_VALUE_VAL:
                return OFMeterModFailedCode.BAD_BAND_VALUE;
            case OUT_OF_METERS_VAL:
                return OFMeterModFailedCode.OUT_OF_METERS;
            case OUT_OF_BANDS_VAL:
                return OFMeterModFailedCode.OUT_OF_BANDS;
            default:
                throw new IllegalArgumentException("Illegal wire value for type OFMeterModFailedCode in version 1.4: " + val);
        }
    }


    public static short toWireValue(OFMeterModFailedCode e) {
        switch(e) {
            case UNKNOWN:
                return UNKNOWN_VAL;
            case METER_EXISTS:
                return METER_EXISTS_VAL;
            case INVALID_METER:
                return INVALID_METER_VAL;
            case UNKNOWN_METER:
                return UNKNOWN_METER_VAL;
            case BAD_COMMAND:
                return BAD_COMMAND_VAL;
            case BAD_FLAGS:
                return BAD_FLAGS_VAL;
            case BAD_RATE:
                return BAD_RATE_VAL;
            case BAD_BURST:
                return BAD_BURST_VAL;
            case BAD_BAND:
                return BAD_BAND_VAL;
            case BAD_BAND_VALUE:
                return BAD_BAND_VALUE_VAL;
            case OUT_OF_METERS:
                return OUT_OF_METERS_VAL;
            case OUT_OF_BANDS:
                return OUT_OF_BANDS_VAL;
            default:
                throw new IllegalArgumentException("Illegal enum value for type OFMeterModFailedCode in version 1.4: " + e);
        }
    }

}
