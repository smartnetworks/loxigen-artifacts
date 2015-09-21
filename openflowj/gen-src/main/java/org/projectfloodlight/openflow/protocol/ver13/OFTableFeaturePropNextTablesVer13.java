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
import java.util.List;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFTableFeaturePropNextTablesVer13 implements OFTableFeaturePropNextTables {
    private static final Logger logger = LoggerFactory.getLogger(OFTableFeaturePropNextTablesVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int MINIMUM_LENGTH = 4;

        private final static List<U8> DEFAULT_NEXT_TABLE_IDS = ImmutableList.<U8>of();

    // OF message fields
    private final List<U8> nextTableIds;
//
    // Immutable default instance
    final static OFTableFeaturePropNextTablesVer13 DEFAULT = new OFTableFeaturePropNextTablesVer13(
        DEFAULT_NEXT_TABLE_IDS
    );

    // package private constructor - used by readers, builders, and factory
    OFTableFeaturePropNextTablesVer13(List<U8> nextTableIds) {
        if(nextTableIds == null) {
            throw new NullPointerException("OFTableFeaturePropNextTablesVer13: property nextTableIds cannot be null");
        }
        this.nextTableIds = nextTableIds;
    }

    // Accessors for OF message fields
    @Override
    public int getType() {
        return 0x2;
    }

    @Override
    public List<U8> getNextTableIds() {
        return nextTableIds;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFTableFeaturePropNextTables.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFTableFeaturePropNextTables.Builder {
        final OFTableFeaturePropNextTablesVer13 parentMessage;

        // OF message fields
        private boolean nextTableIdsSet;
        private List<U8> nextTableIds;

        BuilderWithParent(OFTableFeaturePropNextTablesVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public int getType() {
        return 0x2;
    }

    @Override
    public List<U8> getNextTableIds() {
        return nextTableIds;
    }

    @Override
    public OFTableFeaturePropNextTables.Builder setNextTableIds(List<U8> nextTableIds) {
        this.nextTableIds = nextTableIds;
        this.nextTableIdsSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFTableFeaturePropNextTables build() {
                List<U8> nextTableIds = this.nextTableIdsSet ? this.nextTableIds : parentMessage.nextTableIds;
                if(nextTableIds == null)
                    throw new NullPointerException("Property nextTableIds must not be null");

                //
                return new OFTableFeaturePropNextTablesVer13(
                    nextTableIds
                );
        }

    }

    static class Builder implements OFTableFeaturePropNextTables.Builder {
        // OF message fields
        private boolean nextTableIdsSet;
        private List<U8> nextTableIds;

    @Override
    public int getType() {
        return 0x2;
    }

    @Override
    public List<U8> getNextTableIds() {
        return nextTableIds;
    }

    @Override
    public OFTableFeaturePropNextTables.Builder setNextTableIds(List<U8> nextTableIds) {
        this.nextTableIds = nextTableIds;
        this.nextTableIdsSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

//
        @Override
        public OFTableFeaturePropNextTables build() {
            List<U8> nextTableIds = this.nextTableIdsSet ? this.nextTableIds : DEFAULT_NEXT_TABLE_IDS;
            if(nextTableIds == null)
                throw new NullPointerException("Property nextTableIds must not be null");


            return new OFTableFeaturePropNextTablesVer13(
                    nextTableIds
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFTableFeaturePropNextTables> {
        @Override
        public OFTableFeaturePropNextTables readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 0x2
            short type = bb.readShort();
            if(type != (short) 0x2)
                throw new OFParseError("Wrong type: Expected=0x2(0x2), got="+type);
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
            List<U8> nextTableIds = ChannelUtils.readList(bb, length - (bb.readerIndex() - start), U8.READER);
            // align message to 8 bytes (length does not contain alignment)
            bb.skipBytes(((length + 7)/8 * 8 ) - length );

            OFTableFeaturePropNextTablesVer13 tableFeaturePropNextTablesVer13 = new OFTableFeaturePropNextTablesVer13(
                    nextTableIds
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", tableFeaturePropNextTablesVer13);
            return tableFeaturePropNextTablesVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFTableFeaturePropNextTablesVer13Funnel FUNNEL = new OFTableFeaturePropNextTablesVer13Funnel();
    static class OFTableFeaturePropNextTablesVer13Funnel implements Funnel<OFTableFeaturePropNextTablesVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFTableFeaturePropNextTablesVer13 message, PrimitiveSink sink) {
            // fixed value property type = 0x2
            sink.putShort((short) 0x2);
            // FIXME: skip funnel of length
            FunnelUtils.putList(message.nextTableIds, sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFTableFeaturePropNextTablesVer13> {
        @Override
        public void write(ByteBuf bb, OFTableFeaturePropNextTablesVer13 message) {
            int startIndex = bb.writerIndex();
            // fixed value property type = 0x2
            bb.writeShort((short) 0x2);
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            ChannelUtils.writeList(bb, message.nextTableIds);

            // update length field
            int length = bb.writerIndex() - startIndex;
            int alignedLength = ((length + 7)/8 * 8);
            bb.setShort(lengthIndex, length);
            // align message to 8 bytes
            bb.writeZero(alignedLength - length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFTableFeaturePropNextTablesVer13(");
        b.append("nextTableIds=").append(nextTableIds);
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
        OFTableFeaturePropNextTablesVer13 other = (OFTableFeaturePropNextTablesVer13) obj;

        if (nextTableIds == null) {
            if (other.nextTableIds != null)
                return false;
        } else if (!nextTableIds.equals(other.nextTableIds))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((nextTableIds == null) ? 0 : nextTableIds.hashCode());
        return result;
    }

}
