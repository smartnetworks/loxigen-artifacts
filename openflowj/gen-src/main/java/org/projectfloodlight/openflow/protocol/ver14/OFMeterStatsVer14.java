// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFMeterStatsVer14 implements OFMeterStats {
    private static final Logger logger = LoggerFactory.getLogger(OFMeterStatsVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int MINIMUM_LENGTH = 40;

        private final static long DEFAULT_METER_ID = 0x0L;
        private final static long DEFAULT_FLOW_COUNT = 0x0L;
        private final static U64 DEFAULT_PACKET_IN_COUNT = U64.ZERO;
        private final static U64 DEFAULT_BYTE_IN_COUNT = U64.ZERO;
        private final static long DEFAULT_DURATION_SEC = 0x0L;
        private final static long DEFAULT_DURATION_NSEC = 0x0L;
        private final static List<OFMeterBandStats> DEFAULT_BAND_STATS = ImmutableList.<OFMeterBandStats>of();

    // OF message fields
    private final long meterId;
    private final long flowCount;
    private final U64 packetInCount;
    private final U64 byteInCount;
    private final long durationSec;
    private final long durationNsec;
    private final List<OFMeterBandStats> bandStats;
//
    // Immutable default instance
    final static OFMeterStatsVer14 DEFAULT = new OFMeterStatsVer14(
        DEFAULT_METER_ID, DEFAULT_FLOW_COUNT, DEFAULT_PACKET_IN_COUNT, DEFAULT_BYTE_IN_COUNT, DEFAULT_DURATION_SEC, DEFAULT_DURATION_NSEC, DEFAULT_BAND_STATS
    );

    // package private constructor - used by readers, builders, and factory
    OFMeterStatsVer14(long meterId, long flowCount, U64 packetInCount, U64 byteInCount, long durationSec, long durationNsec, List<OFMeterBandStats> bandStats) {
        if(packetInCount == null) {
            throw new NullPointerException("OFMeterStatsVer14: property packetInCount cannot be null");
        }
        if(byteInCount == null) {
            throw new NullPointerException("OFMeterStatsVer14: property byteInCount cannot be null");
        }
        if(bandStats == null) {
            throw new NullPointerException("OFMeterStatsVer14: property bandStats cannot be null");
        }
        this.meterId = meterId;
        this.flowCount = flowCount;
        this.packetInCount = packetInCount;
        this.byteInCount = byteInCount;
        this.durationSec = durationSec;
        this.durationNsec = durationNsec;
        this.bandStats = bandStats;
    }

    // Accessors for OF message fields
    @Override
    public long getMeterId() {
        return meterId;
    }

    @Override
    public long getFlowCount() {
        return flowCount;
    }

    @Override
    public U64 getPacketInCount() {
        return packetInCount;
    }

    @Override
    public U64 getByteInCount() {
        return byteInCount;
    }

    @Override
    public long getDurationSec() {
        return durationSec;
    }

    @Override
    public long getDurationNsec() {
        return durationNsec;
    }

    @Override
    public List<OFMeterBandStats> getBandStats() {
        return bandStats;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFMeterStats.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFMeterStats.Builder {
        final OFMeterStatsVer14 parentMessage;

        // OF message fields
        private boolean meterIdSet;
        private long meterId;
        private boolean flowCountSet;
        private long flowCount;
        private boolean packetInCountSet;
        private U64 packetInCount;
        private boolean byteInCountSet;
        private U64 byteInCount;
        private boolean durationSecSet;
        private long durationSec;
        private boolean durationNsecSet;
        private long durationNsec;
        private boolean bandStatsSet;
        private List<OFMeterBandStats> bandStats;

        BuilderWithParent(OFMeterStatsVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getMeterId() {
        return meterId;
    }

    @Override
    public OFMeterStats.Builder setMeterId(long meterId) {
        this.meterId = meterId;
        this.meterIdSet = true;
        return this;
    }
    @Override
    public long getFlowCount() {
        return flowCount;
    }

    @Override
    public OFMeterStats.Builder setFlowCount(long flowCount) {
        this.flowCount = flowCount;
        this.flowCountSet = true;
        return this;
    }
    @Override
    public U64 getPacketInCount() {
        return packetInCount;
    }

    @Override
    public OFMeterStats.Builder setPacketInCount(U64 packetInCount) {
        this.packetInCount = packetInCount;
        this.packetInCountSet = true;
        return this;
    }
    @Override
    public U64 getByteInCount() {
        return byteInCount;
    }

    @Override
    public OFMeterStats.Builder setByteInCount(U64 byteInCount) {
        this.byteInCount = byteInCount;
        this.byteInCountSet = true;
        return this;
    }
    @Override
    public long getDurationSec() {
        return durationSec;
    }

    @Override
    public OFMeterStats.Builder setDurationSec(long durationSec) {
        this.durationSec = durationSec;
        this.durationSecSet = true;
        return this;
    }
    @Override
    public long getDurationNsec() {
        return durationNsec;
    }

    @Override
    public OFMeterStats.Builder setDurationNsec(long durationNsec) {
        this.durationNsec = durationNsec;
        this.durationNsecSet = true;
        return this;
    }
    @Override
    public List<OFMeterBandStats> getBandStats() {
        return bandStats;
    }

    @Override
    public OFMeterStats.Builder setBandStats(List<OFMeterBandStats> bandStats) {
        this.bandStats = bandStats;
        this.bandStatsSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFMeterStats build() {
                long meterId = this.meterIdSet ? this.meterId : parentMessage.meterId;
                long flowCount = this.flowCountSet ? this.flowCount : parentMessage.flowCount;
                U64 packetInCount = this.packetInCountSet ? this.packetInCount : parentMessage.packetInCount;
                if(packetInCount == null)
                    throw new NullPointerException("Property packetInCount must not be null");
                U64 byteInCount = this.byteInCountSet ? this.byteInCount : parentMessage.byteInCount;
                if(byteInCount == null)
                    throw new NullPointerException("Property byteInCount must not be null");
                long durationSec = this.durationSecSet ? this.durationSec : parentMessage.durationSec;
                long durationNsec = this.durationNsecSet ? this.durationNsec : parentMessage.durationNsec;
                List<OFMeterBandStats> bandStats = this.bandStatsSet ? this.bandStats : parentMessage.bandStats;
                if(bandStats == null)
                    throw new NullPointerException("Property bandStats must not be null");

                //
                return new OFMeterStatsVer14(
                    meterId,
                    flowCount,
                    packetInCount,
                    byteInCount,
                    durationSec,
                    durationNsec,
                    bandStats
                );
        }

    }

    static class Builder implements OFMeterStats.Builder {
        // OF message fields
        private boolean meterIdSet;
        private long meterId;
        private boolean flowCountSet;
        private long flowCount;
        private boolean packetInCountSet;
        private U64 packetInCount;
        private boolean byteInCountSet;
        private U64 byteInCount;
        private boolean durationSecSet;
        private long durationSec;
        private boolean durationNsecSet;
        private long durationNsec;
        private boolean bandStatsSet;
        private List<OFMeterBandStats> bandStats;

    @Override
    public long getMeterId() {
        return meterId;
    }

    @Override
    public OFMeterStats.Builder setMeterId(long meterId) {
        this.meterId = meterId;
        this.meterIdSet = true;
        return this;
    }
    @Override
    public long getFlowCount() {
        return flowCount;
    }

    @Override
    public OFMeterStats.Builder setFlowCount(long flowCount) {
        this.flowCount = flowCount;
        this.flowCountSet = true;
        return this;
    }
    @Override
    public U64 getPacketInCount() {
        return packetInCount;
    }

    @Override
    public OFMeterStats.Builder setPacketInCount(U64 packetInCount) {
        this.packetInCount = packetInCount;
        this.packetInCountSet = true;
        return this;
    }
    @Override
    public U64 getByteInCount() {
        return byteInCount;
    }

    @Override
    public OFMeterStats.Builder setByteInCount(U64 byteInCount) {
        this.byteInCount = byteInCount;
        this.byteInCountSet = true;
        return this;
    }
    @Override
    public long getDurationSec() {
        return durationSec;
    }

    @Override
    public OFMeterStats.Builder setDurationSec(long durationSec) {
        this.durationSec = durationSec;
        this.durationSecSet = true;
        return this;
    }
    @Override
    public long getDurationNsec() {
        return durationNsec;
    }

    @Override
    public OFMeterStats.Builder setDurationNsec(long durationNsec) {
        this.durationNsec = durationNsec;
        this.durationNsecSet = true;
        return this;
    }
    @Override
    public List<OFMeterBandStats> getBandStats() {
        return bandStats;
    }

    @Override
    public OFMeterStats.Builder setBandStats(List<OFMeterBandStats> bandStats) {
        this.bandStats = bandStats;
        this.bandStatsSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFMeterStats build() {
            long meterId = this.meterIdSet ? this.meterId : DEFAULT_METER_ID;
            long flowCount = this.flowCountSet ? this.flowCount : DEFAULT_FLOW_COUNT;
            U64 packetInCount = this.packetInCountSet ? this.packetInCount : DEFAULT_PACKET_IN_COUNT;
            if(packetInCount == null)
                throw new NullPointerException("Property packetInCount must not be null");
            U64 byteInCount = this.byteInCountSet ? this.byteInCount : DEFAULT_BYTE_IN_COUNT;
            if(byteInCount == null)
                throw new NullPointerException("Property byteInCount must not be null");
            long durationSec = this.durationSecSet ? this.durationSec : DEFAULT_DURATION_SEC;
            long durationNsec = this.durationNsecSet ? this.durationNsec : DEFAULT_DURATION_NSEC;
            List<OFMeterBandStats> bandStats = this.bandStatsSet ? this.bandStats : DEFAULT_BAND_STATS;
            if(bandStats == null)
                throw new NullPointerException("Property bandStats must not be null");


            return new OFMeterStatsVer14(
                    meterId,
                    flowCount,
                    packetInCount,
                    byteInCount,
                    durationSec,
                    durationNsec,
                    bandStats
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFMeterStats> {
        @Override
        public OFMeterStats readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            long meterId = U32.f(bb.readInt());
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
            // pad: 6 bytes
            bb.skipBytes(6);
            long flowCount = U32.f(bb.readInt());
            U64 packetInCount = U64.ofRaw(bb.readLong());
            U64 byteInCount = U64.ofRaw(bb.readLong());
            long durationSec = U32.f(bb.readInt());
            long durationNsec = U32.f(bb.readInt());
            List<OFMeterBandStats> bandStats = ChannelUtils.readList(bb, length - (bb.readerIndex() - start), OFMeterBandStatsVer14.READER);

            OFMeterStatsVer14 meterStatsVer14 = new OFMeterStatsVer14(
                    meterId,
                      flowCount,
                      packetInCount,
                      byteInCount,
                      durationSec,
                      durationNsec,
                      bandStats
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", meterStatsVer14);
            return meterStatsVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFMeterStatsVer14Funnel FUNNEL = new OFMeterStatsVer14Funnel();
    static class OFMeterStatsVer14Funnel implements Funnel<OFMeterStatsVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFMeterStatsVer14 message, PrimitiveSink sink) {
            sink.putLong(message.meterId);
            // FIXME: skip funnel of length
            // skip pad (6 bytes)
            sink.putLong(message.flowCount);
            message.packetInCount.putTo(sink);
            message.byteInCount.putTo(sink);
            sink.putLong(message.durationSec);
            sink.putLong(message.durationNsec);
            FunnelUtils.putList(message.bandStats, sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFMeterStatsVer14> {
        @Override
        public void write(ByteBuf bb, OFMeterStatsVer14 message) {
            int startIndex = bb.writerIndex();
            bb.writeInt(U32.t(message.meterId));
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            // pad: 6 bytes
            bb.writeZero(6);
            bb.writeInt(U32.t(message.flowCount));
            bb.writeLong(message.packetInCount.getValue());
            bb.writeLong(message.byteInCount.getValue());
            bb.writeInt(U32.t(message.durationSec));
            bb.writeInt(U32.t(message.durationNsec));
            ChannelUtils.writeList(bb, message.bandStats);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFMeterStatsVer14(");
        b.append("meterId=").append(meterId);
        b.append(", ");
        b.append("flowCount=").append(flowCount);
        b.append(", ");
        b.append("packetInCount=").append(packetInCount);
        b.append(", ");
        b.append("byteInCount=").append(byteInCount);
        b.append(", ");
        b.append("durationSec=").append(durationSec);
        b.append(", ");
        b.append("durationNsec=").append(durationNsec);
        b.append(", ");
        b.append("bandStats=").append(bandStats);
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
        OFMeterStatsVer14 other = (OFMeterStatsVer14) obj;

        if( meterId != other.meterId)
            return false;
        if( flowCount != other.flowCount)
            return false;
        if (packetInCount == null) {
            if (other.packetInCount != null)
                return false;
        } else if (!packetInCount.equals(other.packetInCount))
            return false;
        if (byteInCount == null) {
            if (other.byteInCount != null)
                return false;
        } else if (!byteInCount.equals(other.byteInCount))
            return false;
        if( durationSec != other.durationSec)
            return false;
        if( durationNsec != other.durationNsec)
            return false;
        if (bandStats == null) {
            if (other.bandStats != null)
                return false;
        } else if (!bandStats.equals(other.bandStats))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime *  (int) (meterId ^ (meterId >>> 32));
        result = prime *  (int) (flowCount ^ (flowCount >>> 32));
        result = prime * result + ((packetInCount == null) ? 0 : packetInCount.hashCode());
        result = prime * result + ((byteInCount == null) ? 0 : byteInCount.hashCode());
        result = prime *  (int) (durationSec ^ (durationSec >>> 32));
        result = prime *  (int) (durationNsec ^ (durationNsec >>> 32));
        result = prime * result + ((bandStats == null) ? 0 : bandStats.hashCode());
        return result;
    }

}
