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
import org.projectfloodlight.openflow.protocol.stat.*;
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.oxs.*;
import org.projectfloodlight.openflow.protocol.queueprop.*;
import org.projectfloodlight.openflow.types.*;
import org.projectfloodlight.openflow.util.*;
import org.projectfloodlight.openflow.exceptions.*;
import org.projectfloodlight.openflow.protocol.OFBsnAutoNegotiationType;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;

public class OFBsnAutoNegotiationTypeSerializerVer14 {

    public final static byte BSN_AUTO_NEGOTIATION_DEFAULT_VAL = (byte) 0x0;
    public final static byte BSN_AUTO_NEGOTIATION_ENABLE_VAL = (byte) 0x1;
    public final static byte BSN_AUTO_NEGOTIATION_DISABLE_VAL = (byte) 0x2;

    public static OFBsnAutoNegotiationType readFrom(ByteBuf bb) throws OFParseError {
        try {
            return ofWireValue(bb.readByte());
        } catch (IllegalArgumentException e) {
            throw new OFParseError(e);
        }
    }

    public static void writeTo(ByteBuf bb, OFBsnAutoNegotiationType e) {
        bb.writeByte(toWireValue(e));
    }

    public static void putTo(OFBsnAutoNegotiationType e, PrimitiveSink sink) {
        sink.putByte(toWireValue(e));
    }

    public static OFBsnAutoNegotiationType ofWireValue(byte val) {
        switch(val) {
            case BSN_AUTO_NEGOTIATION_DEFAULT_VAL:
                return OFBsnAutoNegotiationType.BSN_AUTO_NEGOTIATION_DEFAULT;
            case BSN_AUTO_NEGOTIATION_ENABLE_VAL:
                return OFBsnAutoNegotiationType.BSN_AUTO_NEGOTIATION_ENABLE;
            case BSN_AUTO_NEGOTIATION_DISABLE_VAL:
                return OFBsnAutoNegotiationType.BSN_AUTO_NEGOTIATION_DISABLE;
            default:
                throw new IllegalArgumentException("Illegal wire value for type OFBsnAutoNegotiationType in version 1.4: " + val);
        }
    }


    public static byte toWireValue(OFBsnAutoNegotiationType e) {
        switch(e) {
            case BSN_AUTO_NEGOTIATION_DEFAULT:
                return BSN_AUTO_NEGOTIATION_DEFAULT_VAL;
            case BSN_AUTO_NEGOTIATION_ENABLE:
                return BSN_AUTO_NEGOTIATION_ENABLE_VAL;
            case BSN_AUTO_NEGOTIATION_DISABLE:
                return BSN_AUTO_NEGOTIATION_DISABLE_VAL;
            default:
                throw new IllegalArgumentException("Illegal enum value for type OFBsnAutoNegotiationType in version 1.4: " + e);
        }
    }

}