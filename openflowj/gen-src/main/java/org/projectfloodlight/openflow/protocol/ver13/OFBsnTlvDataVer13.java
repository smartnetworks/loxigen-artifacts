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
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.queueprop.*;
import org.projectfloodlight.openflow.types.*;
import org.projectfloodlight.openflow.util.*;
import org.projectfloodlight.openflow.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;
import org.jboss.netty.buffer.ChannelBuffer;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;
import java.util.Arrays;

class OFBsnTlvDataVer13 implements OFBsnTlvData {
    private static final Logger logger = LoggerFactory.getLogger(OFBsnTlvDataVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int MINIMUM_LENGTH = 4;

        private final static byte[] DEFAULT_VALUE = new byte[0];

    // OF message fields
    private final byte[] value;
//
    // Immutable default instance
    final static OFBsnTlvDataVer13 DEFAULT = new OFBsnTlvDataVer13(
        DEFAULT_VALUE
    );

    // package private constructor - used by readers, builders, and factory
    OFBsnTlvDataVer13(byte[] value) {
        this.value = value;
    }

    // Accessors for OF message fields
    @Override
    public int getType() {
        return 0x37;
    }

    @Override
    public byte[] getValue() {
        return value;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFBsnTlvData.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFBsnTlvData.Builder {
        final OFBsnTlvDataVer13 parentMessage;

        // OF message fields
        private boolean valueSet;
        private byte[] value;

        BuilderWithParent(OFBsnTlvDataVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public int getType() {
        return 0x37;
    }

    @Override
    public byte[] getValue() {
        return value;
    }

    @Override
    public OFBsnTlvData.Builder setValue(byte[] value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFBsnTlvData build() {
                byte[] value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");

                //
                return new OFBsnTlvDataVer13(
                    value
                );
        }

    }

    static class Builder implements OFBsnTlvData.Builder {
        // OF message fields
        private boolean valueSet;
        private byte[] value;

    @Override
    public int getType() {
        return 0x37;
    }

    @Override
    public byte[] getValue() {
        return value;
    }

    @Override
    public OFBsnTlvData.Builder setValue(byte[] value) {
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
        public OFBsnTlvData build() {
            byte[] value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");


            return new OFBsnTlvDataVer13(
                    value
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFBsnTlvData> {
        @Override
        public OFBsnTlvData readFrom(ChannelBuffer bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 0x37
            short type = bb.readShort();
            if(type != (short) 0x37)
                throw new OFParseError("Wrong type: Expected=0x37(0x37), got="+type);
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
            byte[] value = ChannelUtils.readBytes(bb, length - (bb.readerIndex() - start));

            OFBsnTlvDataVer13 bsnTlvDataVer13 = new OFBsnTlvDataVer13(
                    value
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", bsnTlvDataVer13);
            return bsnTlvDataVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFBsnTlvDataVer13Funnel FUNNEL = new OFBsnTlvDataVer13Funnel();
    static class OFBsnTlvDataVer13Funnel implements Funnel<OFBsnTlvDataVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFBsnTlvDataVer13 message, PrimitiveSink sink) {
            // fixed value property type = 0x37
            sink.putShort((short) 0x37);
            // FIXME: skip funnel of length
            sink.putBytes(message.value);
        }
    }


    public void writeTo(ChannelBuffer bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFBsnTlvDataVer13> {
        @Override
        public void write(ChannelBuffer bb, OFBsnTlvDataVer13 message) {
            int startIndex = bb.writerIndex();
            // fixed value property type = 0x37
            bb.writeShort((short) 0x37);
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            bb.writeBytes(message.value);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFBsnTlvDataVer13(");
        b.append("value=").append(Arrays.toString(value));
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
        OFBsnTlvDataVer13 other = (OFBsnTlvDataVer13) obj;

        if (!Arrays.equals(value, other.value))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Arrays.hashCode(value);
        return result;
    }

}
