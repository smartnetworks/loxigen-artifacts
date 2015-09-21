// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver12;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFActionPopVlanVer12 implements OFActionPopVlan {
    private static final Logger logger = LoggerFactory.getLogger(OFActionPopVlanVer12.class);
    // version: 1.2
    final static byte WIRE_VERSION = 3;
    final static int LENGTH = 8;


    // OF message fields
//
    // Immutable default instance
    final static OFActionPopVlanVer12 DEFAULT = new OFActionPopVlanVer12(

    );

    final static OFActionPopVlanVer12 INSTANCE = new OFActionPopVlanVer12();
    // private empty constructor - use shared instance!
    private OFActionPopVlanVer12() {
    }

    // Accessors for OF message fields
    @Override
    public OFActionType getType() {
        return OFActionType.POP_VLAN;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



    // no data members - do not support builder
    public OFActionPopVlan.Builder createBuilder() {
        throw new UnsupportedOperationException("OFActionPopVlanVer12 has no mutable properties -- builder unneeded");
    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFActionPopVlan> {
        @Override
        public OFActionPopVlan readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 18
            short type = bb.readShort();
            if(type != (short) 0x12)
                throw new OFParseError("Wrong type: Expected=OFActionType.POP_VLAN(18), got="+type);
            int length = U16.f(bb.readShort());
            if(length != 8)
                throw new OFParseError("Wrong length: Expected=8(8), got="+length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            // pad: 4 bytes
            bb.skipBytes(4);

            if(logger.isTraceEnabled())
                logger.trace("readFrom - returning shared instance={}", INSTANCE);
            return INSTANCE;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFActionPopVlanVer12Funnel FUNNEL = new OFActionPopVlanVer12Funnel();
    static class OFActionPopVlanVer12Funnel implements Funnel<OFActionPopVlanVer12> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFActionPopVlanVer12 message, PrimitiveSink sink) {
            // fixed value property type = 18
            sink.putShort((short) 0x12);
            // fixed value property length = 8
            sink.putShort((short) 0x8);
            // skip pad (4 bytes)
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFActionPopVlanVer12> {
        @Override
        public void write(ByteBuf bb, OFActionPopVlanVer12 message) {
            // fixed value property type = 18
            bb.writeShort((short) 0x12);
            // fixed value property length = 8
            bb.writeShort((short) 0x8);
            // pad: 4 bytes
            bb.writeZero(4);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFActionPopVlanVer12(");
        b.append(")");
        return b.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        return result;
    }

}
