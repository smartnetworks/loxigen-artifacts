// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template const_serializer.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver13;

import org.projectfloodlight.openflow.protocol.*;
import org.projectfloodlight.openflow.protocol.action.*;
import org.projectfloodlight.openflow.protocol.actionid.*;
import org.projectfloodlight.openflow.protocol.bsntlv.*;
import org.projectfloodlight.openflow.protocol.errormsg.*;
import org.projectfloodlight.openflow.protocol.meterband.*;
import org.projectfloodlight.openflow.protocol.instruction.*;
import org.projectfloodlight.openflow.protocol.instructionid.*;
import org.projectfloodlight.openflow.protocol.match.*;
import org.projectfloodlight.openflow.protocol.stat.*;
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.oxs.*;
import org.projectfloodlight.openflow.protocol.queueprop.*;
import org.projectfloodlight.openflow.types.*;
import org.projectfloodlight.openflow.util.*;
import org.projectfloodlight.openflow.exceptions.*;
import org.projectfloodlight.openflow.protocol.OFBsnPortSpeedGbpsType;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;

public class OFBsnPortSpeedGbpsTypeSerializerVer13 {

    public final static int BSN_PORT_SPEED_GBPS_1_VAL = 0x1;
    public final static int BSN_PORT_SPEED_GBPS_10_VAL = 0xa;
    public final static int BSN_PORT_SPEED_GBPS_25_VAL = 0x19;
    public final static int BSN_PORT_SPEED_GBPS_40_VAL = 0x28;
    public final static int BSN_PORT_SPEED_GBPS_50_VAL = 0x32;
    public final static int BSN_PORT_SPEED_GBPS_100_VAL = 0x64;

    public static OFBsnPortSpeedGbpsType readFrom(ByteBuf bb) throws OFParseError {
        try {
            return ofWireValue(bb.readInt());
        } catch (IllegalArgumentException e) {
            throw new OFParseError(e);
        }
    }

    public static void writeTo(ByteBuf bb, OFBsnPortSpeedGbpsType e) {
        bb.writeInt(toWireValue(e));
    }

    public static void putTo(OFBsnPortSpeedGbpsType e, PrimitiveSink sink) {
        sink.putInt(toWireValue(e));
    }

    public static OFBsnPortSpeedGbpsType ofWireValue(int val) {
        switch(val) {
            case BSN_PORT_SPEED_GBPS_1_VAL:
                return OFBsnPortSpeedGbpsType.BSN_PORT_SPEED_GBPS_1;
            case BSN_PORT_SPEED_GBPS_10_VAL:
                return OFBsnPortSpeedGbpsType.BSN_PORT_SPEED_GBPS_10;
            case BSN_PORT_SPEED_GBPS_25_VAL:
                return OFBsnPortSpeedGbpsType.BSN_PORT_SPEED_GBPS_25;
            case BSN_PORT_SPEED_GBPS_40_VAL:
                return OFBsnPortSpeedGbpsType.BSN_PORT_SPEED_GBPS_40;
            case BSN_PORT_SPEED_GBPS_50_VAL:
                return OFBsnPortSpeedGbpsType.BSN_PORT_SPEED_GBPS_50;
            case BSN_PORT_SPEED_GBPS_100_VAL:
                return OFBsnPortSpeedGbpsType.BSN_PORT_SPEED_GBPS_100;
            default:
                throw new IllegalArgumentException("Illegal wire value for type OFBsnPortSpeedGbpsType in version 1.3: " + val);
        }
    }


    public static int toWireValue(OFBsnPortSpeedGbpsType e) {
        switch(e) {
            case BSN_PORT_SPEED_GBPS_1:
                return BSN_PORT_SPEED_GBPS_1_VAL;
            case BSN_PORT_SPEED_GBPS_10:
                return BSN_PORT_SPEED_GBPS_10_VAL;
            case BSN_PORT_SPEED_GBPS_25:
                return BSN_PORT_SPEED_GBPS_25_VAL;
            case BSN_PORT_SPEED_GBPS_40:
                return BSN_PORT_SPEED_GBPS_40_VAL;
            case BSN_PORT_SPEED_GBPS_50:
                return BSN_PORT_SPEED_GBPS_50_VAL;
            case BSN_PORT_SPEED_GBPS_100:
                return BSN_PORT_SPEED_GBPS_100_VAL;
            default:
                throw new IllegalArgumentException("Illegal enum value for type OFBsnPortSpeedGbpsType in version 1.3: " + e);
        }
    }

}