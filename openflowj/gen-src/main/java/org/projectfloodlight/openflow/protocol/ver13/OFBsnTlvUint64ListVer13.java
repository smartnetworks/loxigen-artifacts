// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
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
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFBsnTlvUint64ListVer13 implements OFBsnTlvUint64List {
    private static final Logger logger = LoggerFactory.getLogger(OFBsnTlvUint64ListVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int MINIMUM_LENGTH = 4;

        private final static List<U64> DEFAULT_VALUE = ImmutableList.<U64>of();

    // OF message fields
    private final List<U64> value;
//
    // Immutable default instance
    final static OFBsnTlvUint64ListVer13 DEFAULT = new OFBsnTlvUint64ListVer13(
        DEFAULT_VALUE
    );

    // package private constructor - used by readers, builders, and factory
    OFBsnTlvUint64ListVer13(List<U64> value) {
        if(value == null) {
            throw new NullPointerException("OFBsnTlvUint64ListVer13: property value cannot be null");
        }
        this.value = value;
    }

    // Accessors for OF message fields
    @Override
    public int getType() {
        return 0x77;
    }

    @Override
    public List<U64> getValue() {
        return value;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFBsnTlvUint64List.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFBsnTlvUint64List.Builder {
        final OFBsnTlvUint64ListVer13 parentMessage;

        // OF message fields
        private boolean valueSet;
        private List<U64> value;

        BuilderWithParent(OFBsnTlvUint64ListVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public int getType() {
        return 0x77;
    }

    @Override
    public List<U64> getValue() {
        return value;
    }

    @Override
    public OFBsnTlvUint64List.Builder setValue(List<U64> value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFBsnTlvUint64List build() {
                List<U64> value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");

                //
                return new OFBsnTlvUint64ListVer13(
                    value
                );
        }

    }

    static class Builder implements OFBsnTlvUint64List.Builder {
        // OF message fields
        private boolean valueSet;
        private List<U64> value;

    @Override
    public int getType() {
        return 0x77;
    }

    @Override
    public List<U64> getValue() {
        return value;
    }

    @Override
    public OFBsnTlvUint64List.Builder setValue(List<U64> value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

//
        @Override
        public OFBsnTlvUint64List build() {
            List<U64> value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");


            return new OFBsnTlvUint64ListVer13(
                    value
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFBsnTlvUint64List> {
        @Override
        public OFBsnTlvUint64List readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 0x77
            short type = bb.readShort();
            if(type != (short) 0x77)
                throw new OFParseError("Wrong type: Expected=0x77(0x77), got="+type);
            int length = U16.f(bb.readShort());
            if(length < MINIMUM_LENGTH)
                throw new OFParseError("Wrong length: Expected to be >= " + MINIMUM_LENGTH + ", was: " + length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            List<U64> value = ChannelUtils.readList(bb, length - (bb.readerIndex() - start), U64.READER);

            OFBsnTlvUint64ListVer13 bsnTlvUint64ListVer13 = new OFBsnTlvUint64ListVer13(
                    value
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", bsnTlvUint64ListVer13);
            return bsnTlvUint64ListVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFBsnTlvUint64ListVer13Funnel FUNNEL = new OFBsnTlvUint64ListVer13Funnel();
    static class OFBsnTlvUint64ListVer13Funnel implements Funnel<OFBsnTlvUint64ListVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFBsnTlvUint64ListVer13 message, PrimitiveSink sink) {
            // fixed value property type = 0x77
            sink.putShort((short) 0x77);
            // FIXME: skip funnel of length
            FunnelUtils.putList(message.value, sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFBsnTlvUint64ListVer13> {
        @Override
        public void write(ByteBuf bb, OFBsnTlvUint64ListVer13 message) {
            int startIndex = bb.writerIndex();
            // fixed value property type = 0x77
            bb.writeShort((short) 0x77);
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            ChannelUtils.writeList(bb, message.value);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFBsnTlvUint64ListVer13(");
        b.append("value=").append(value);
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
        OFBsnTlvUint64ListVer13 other = (OFBsnTlvUint64ListVer13) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

}
