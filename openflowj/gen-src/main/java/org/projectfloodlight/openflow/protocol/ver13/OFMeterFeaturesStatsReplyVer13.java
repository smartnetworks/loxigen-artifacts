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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;
import com.google.common.collect.ImmutableSet;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFMeterFeaturesStatsReplyVer13 implements OFMeterFeaturesStatsReply {
    private static final Logger logger = LoggerFactory.getLogger(OFMeterFeaturesStatsReplyVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int LENGTH = 32;

        private final static long DEFAULT_XID = 0x0L;
        private final static Set<OFStatsReplyFlags> DEFAULT_FLAGS = ImmutableSet.<OFStatsReplyFlags>of();

    // OF message fields
    private final long xid;
    private final Set<OFStatsReplyFlags> flags;
    private final OFMeterFeatures features;
//

    // package private constructor - used by readers, builders, and factory
    OFMeterFeaturesStatsReplyVer13(long xid, Set<OFStatsReplyFlags> flags, OFMeterFeatures features) {
        if(flags == null) {
            throw new NullPointerException("OFMeterFeaturesStatsReplyVer13: property flags cannot be null");
        }
        if(features == null) {
            throw new NullPointerException("OFMeterFeaturesStatsReplyVer13: property features cannot be null");
        }
        this.xid = xid;
        this.flags = flags;
        this.features = features;
    }

    // Accessors for OF message fields
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

    @Override
    public OFType getType() {
        return OFType.STATS_REPLY;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFStatsType getStatsType() {
        return OFStatsType.METER_FEATURES;
    }

    @Override
    public Set<OFStatsReplyFlags> getFlags() {
        return flags;
    }

    @Override
    public OFMeterFeatures getFeatures() {
        return features;
    }



    public OFMeterFeaturesStatsReply.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFMeterFeaturesStatsReply.Builder {
        final OFMeterFeaturesStatsReplyVer13 parentMessage;

        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean flagsSet;
        private Set<OFStatsReplyFlags> flags;
        private boolean featuresSet;
        private OFMeterFeatures features;

        BuilderWithParent(OFMeterFeaturesStatsReplyVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

    @Override
    public OFType getType() {
        return OFType.STATS_REPLY;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFMeterFeaturesStatsReply.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public OFStatsType getStatsType() {
        return OFStatsType.METER_FEATURES;
    }

    @Override
    public Set<OFStatsReplyFlags> getFlags() {
        return flags;
    }

    @Override
    public OFMeterFeaturesStatsReply.Builder setFlags(Set<OFStatsReplyFlags> flags) {
        this.flags = flags;
        this.flagsSet = true;
        return this;
    }
    @Override
    public OFMeterFeatures getFeatures() {
        return features;
    }

    @Override
    public OFMeterFeaturesStatsReply.Builder setFeatures(OFMeterFeatures features) {
        this.features = features;
        this.featuresSet = true;
        return this;
    }


        @Override
        public OFMeterFeaturesStatsReply build() {
                long xid = this.xidSet ? this.xid : parentMessage.xid;
                Set<OFStatsReplyFlags> flags = this.flagsSet ? this.flags : parentMessage.flags;
                if(flags == null)
                    throw new NullPointerException("Property flags must not be null");
                OFMeterFeatures features = this.featuresSet ? this.features : parentMessage.features;
                if(features == null)
                    throw new NullPointerException("Property features must not be null");

                //
                return new OFMeterFeaturesStatsReplyVer13(
                    xid,
                    flags,
                    features
                );
        }

    }

    static class Builder implements OFMeterFeaturesStatsReply.Builder {
        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean flagsSet;
        private Set<OFStatsReplyFlags> flags;
        private boolean featuresSet;
        private OFMeterFeatures features;

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

    @Override
    public OFType getType() {
        return OFType.STATS_REPLY;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFMeterFeaturesStatsReply.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public OFStatsType getStatsType() {
        return OFStatsType.METER_FEATURES;
    }

    @Override
    public Set<OFStatsReplyFlags> getFlags() {
        return flags;
    }

    @Override
    public OFMeterFeaturesStatsReply.Builder setFlags(Set<OFStatsReplyFlags> flags) {
        this.flags = flags;
        this.flagsSet = true;
        return this;
    }
    @Override
    public OFMeterFeatures getFeatures() {
        return features;
    }

    @Override
    public OFMeterFeaturesStatsReply.Builder setFeatures(OFMeterFeatures features) {
        this.features = features;
        this.featuresSet = true;
        return this;
    }
//
        @Override
        public OFMeterFeaturesStatsReply build() {
            long xid = this.xidSet ? this.xid : DEFAULT_XID;
            Set<OFStatsReplyFlags> flags = this.flagsSet ? this.flags : DEFAULT_FLAGS;
            if(flags == null)
                throw new NullPointerException("Property flags must not be null");
            if(!this.featuresSet)
                throw new IllegalStateException("Property features doesn't have default value -- must be set");
            if(features == null)
                throw new NullPointerException("Property features must not be null");


            return new OFMeterFeaturesStatsReplyVer13(
                    xid,
                    flags,
                    features
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFMeterFeaturesStatsReply> {
        @Override
        public OFMeterFeaturesStatsReply readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property version == 4
            byte version = bb.readByte();
            if(version != (byte) 0x4)
                throw new OFParseError("Wrong version: Expected=OFVersion.OF_13(4), got="+version);
            // fixed value property type == 19
            byte type = bb.readByte();
            if(type != (byte) 0x13)
                throw new OFParseError("Wrong type: Expected=OFType.STATS_REPLY(19), got="+type);
            int length = U16.f(bb.readShort());
            if(length != 32)
                throw new OFParseError("Wrong length: Expected=32(32), got="+length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            long xid = U32.f(bb.readInt());
            // fixed value property statsType == 11
            short statsType = bb.readShort();
            if(statsType != (short) 0xb)
                throw new OFParseError("Wrong statsType: Expected=OFStatsType.METER_FEATURES(11), got="+statsType);
            Set<OFStatsReplyFlags> flags = OFStatsReplyFlagsSerializerVer13.readFrom(bb);
            // pad: 4 bytes
            bb.skipBytes(4);
            OFMeterFeatures features = OFMeterFeaturesVer13.READER.readFrom(bb);

            OFMeterFeaturesStatsReplyVer13 meterFeaturesStatsReplyVer13 = new OFMeterFeaturesStatsReplyVer13(
                    xid,
                      flags,
                      features
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", meterFeaturesStatsReplyVer13);
            return meterFeaturesStatsReplyVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFMeterFeaturesStatsReplyVer13Funnel FUNNEL = new OFMeterFeaturesStatsReplyVer13Funnel();
    static class OFMeterFeaturesStatsReplyVer13Funnel implements Funnel<OFMeterFeaturesStatsReplyVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFMeterFeaturesStatsReplyVer13 message, PrimitiveSink sink) {
            // fixed value property version = 4
            sink.putByte((byte) 0x4);
            // fixed value property type = 19
            sink.putByte((byte) 0x13);
            // fixed value property length = 32
            sink.putShort((short) 0x20);
            sink.putLong(message.xid);
            // fixed value property statsType = 11
            sink.putShort((short) 0xb);
            OFStatsReplyFlagsSerializerVer13.putTo(message.flags, sink);
            // skip pad (4 bytes)
            message.features.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFMeterFeaturesStatsReplyVer13> {
        @Override
        public void write(ByteBuf bb, OFMeterFeaturesStatsReplyVer13 message) {
            // fixed value property version = 4
            bb.writeByte((byte) 0x4);
            // fixed value property type = 19
            bb.writeByte((byte) 0x13);
            // fixed value property length = 32
            bb.writeShort((short) 0x20);
            bb.writeInt(U32.t(message.xid));
            // fixed value property statsType = 11
            bb.writeShort((short) 0xb);
            OFStatsReplyFlagsSerializerVer13.writeTo(bb, message.flags);
            // pad: 4 bytes
            bb.writeZero(4);
            message.features.writeTo(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFMeterFeaturesStatsReplyVer13(");
        b.append("xid=").append(xid);
        b.append(", ");
        b.append("flags=").append(flags);
        b.append(", ");
        b.append("features=").append(features);
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
        OFMeterFeaturesStatsReplyVer13 other = (OFMeterFeaturesStatsReplyVer13) obj;

        if( xid != other.xid)
            return false;
        if (flags == null) {
            if (other.flags != null)
                return false;
        } else if (!flags.equals(other.flags))
            return false;
        if (features == null) {
            if (other.features != null)
                return false;
        } else if (!features.equals(other.features))
            return false;
        return true;
    }

    @Override
    public boolean equalsIgnoreXid(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OFMeterFeaturesStatsReplyVer13 other = (OFMeterFeaturesStatsReplyVer13) obj;

        // ignore XID
        if (flags == null) {
            if (other.flags != null)
                return false;
        } else if (!flags.equals(other.flags))
            return false;
        if (features == null) {
            if (other.features != null)
                return false;
        } else if (!features.equals(other.features))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime *  (int) (xid ^ (xid >>> 32));
        result = prime * result + ((flags == null) ? 0 : flags.hashCode());
        result = prime * result + ((features == null) ? 0 : features.hashCode());
        return result;
    }

    @Override
    public int hashCodeIgnoreXid() {
        final int prime = 31;
        int result = 1;

        // ignore XID
        result = prime * result + ((flags == null) ? 0 : flags.hashCode());
        result = prime * result + ((features == null) ? 0 : features.hashCode());
        return result;
    }

}
