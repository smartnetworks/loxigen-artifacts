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
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFTableStatsEntryVer13 implements OFTableStatsEntry {
    private static final Logger logger = LoggerFactory.getLogger(OFTableStatsEntryVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int LENGTH = 24;

        private final static TableId DEFAULT_TABLE_ID = TableId.ALL;
        private final static long DEFAULT_ACTIVE_COUNT = 0x0L;
        private final static U64 DEFAULT_LOOKUP_COUNT = U64.ZERO;
        private final static U64 DEFAULT_MATCHED_COUNT = U64.ZERO;

    // OF message fields
    private final TableId tableId;
    private final long activeCount;
    private final U64 lookupCount;
    private final U64 matchedCount;
//
    // Immutable default instance
    final static OFTableStatsEntryVer13 DEFAULT = new OFTableStatsEntryVer13(
        DEFAULT_TABLE_ID, DEFAULT_ACTIVE_COUNT, DEFAULT_LOOKUP_COUNT, DEFAULT_MATCHED_COUNT
    );

    // package private constructor - used by readers, builders, and factory
    OFTableStatsEntryVer13(TableId tableId, long activeCount, U64 lookupCount, U64 matchedCount) {
        if(tableId == null) {
            throw new NullPointerException("OFTableStatsEntryVer13: property tableId cannot be null");
        }
        if(lookupCount == null) {
            throw new NullPointerException("OFTableStatsEntryVer13: property lookupCount cannot be null");
        }
        if(matchedCount == null) {
            throw new NullPointerException("OFTableStatsEntryVer13: property matchedCount cannot be null");
        }
        this.tableId = tableId;
        this.activeCount = activeCount;
        this.lookupCount = lookupCount;
        this.matchedCount = matchedCount;
    }

    // Accessors for OF message fields
    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public String getName()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property name not supported in version 1.3");
    }

    @Override
    public OFMatchBmap getMatch()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property match not supported in version 1.3");
    }

    @Override
    public int getWildcards()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property wildcards not supported in version 1.3");
    }

    @Override
    public long getWriteActions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property writeActions not supported in version 1.3");
    }

    @Override
    public long getApplyActions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property applyActions not supported in version 1.3");
    }

    @Override
    public U64 getWriteSetfields()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property writeSetfields not supported in version 1.3");
    }

    @Override
    public U64 getApplySetfields()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property applySetfields not supported in version 1.3");
    }

    @Override
    public U64 getMetadataMatch()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property metadataMatch not supported in version 1.3");
    }

    @Override
    public U64 getMetadataWrite()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property metadataWrite not supported in version 1.3");
    }

    @Override
    public long getInstructions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property instructions not supported in version 1.3");
    }

    @Override
    public long getConfig()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property config not supported in version 1.3");
    }

    @Override
    public long getMaxEntries()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property maxEntries not supported in version 1.3");
    }

    @Override
    public long getActiveCount() {
        return activeCount;
    }

    @Override
    public U64 getLookupCount() {
        return lookupCount;
    }

    @Override
    public U64 getMatchedCount() {
        return matchedCount;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFTableStatsEntry.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFTableStatsEntry.Builder {
        final OFTableStatsEntryVer13 parentMessage;

        // OF message fields
        private boolean tableIdSet;
        private TableId tableId;
        private boolean activeCountSet;
        private long activeCount;
        private boolean lookupCountSet;
        private U64 lookupCount;
        private boolean matchedCountSet;
        private U64 matchedCount;

        BuilderWithParent(OFTableStatsEntryVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public OFTableStatsEntry.Builder setTableId(TableId tableId) {
        this.tableId = tableId;
        this.tableIdSet = true;
        return this;
    }
    @Override
    public String getName()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property name not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setName(String name) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property name not supported in version 1.3");
    }
    @Override
    public OFMatchBmap getMatch()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property match not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setMatch(OFMatchBmap match) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property match not supported in version 1.3");
    }
    @Override
    public int getWildcards()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property wildcards not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setWildcards(int wildcards) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property wildcards not supported in version 1.3");
    }
    @Override
    public long getWriteActions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property writeActions not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setWriteActions(long writeActions) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property writeActions not supported in version 1.3");
    }
    @Override
    public long getApplyActions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property applyActions not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setApplyActions(long applyActions) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property applyActions not supported in version 1.3");
    }
    @Override
    public U64 getWriteSetfields()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property writeSetfields not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setWriteSetfields(U64 writeSetfields) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property writeSetfields not supported in version 1.3");
    }
    @Override
    public U64 getApplySetfields()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property applySetfields not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setApplySetfields(U64 applySetfields) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property applySetfields not supported in version 1.3");
    }
    @Override
    public U64 getMetadataMatch()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property metadataMatch not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setMetadataMatch(U64 metadataMatch) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property metadataMatch not supported in version 1.3");
    }
    @Override
    public U64 getMetadataWrite()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property metadataWrite not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setMetadataWrite(U64 metadataWrite) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property metadataWrite not supported in version 1.3");
    }
    @Override
    public long getInstructions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property instructions not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setInstructions(long instructions) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property instructions not supported in version 1.3");
    }
    @Override
    public long getConfig()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property config not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setConfig(long config) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property config not supported in version 1.3");
    }
    @Override
    public long getMaxEntries()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property maxEntries not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setMaxEntries(long maxEntries) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property maxEntries not supported in version 1.3");
    }
    @Override
    public long getActiveCount() {
        return activeCount;
    }

    @Override
    public OFTableStatsEntry.Builder setActiveCount(long activeCount) {
        this.activeCount = activeCount;
        this.activeCountSet = true;
        return this;
    }
    @Override
    public U64 getLookupCount() {
        return lookupCount;
    }

    @Override
    public OFTableStatsEntry.Builder setLookupCount(U64 lookupCount) {
        this.lookupCount = lookupCount;
        this.lookupCountSet = true;
        return this;
    }
    @Override
    public U64 getMatchedCount() {
        return matchedCount;
    }

    @Override
    public OFTableStatsEntry.Builder setMatchedCount(U64 matchedCount) {
        this.matchedCount = matchedCount;
        this.matchedCountSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFTableStatsEntry build() {
                TableId tableId = this.tableIdSet ? this.tableId : parentMessage.tableId;
                if(tableId == null)
                    throw new NullPointerException("Property tableId must not be null");
                long activeCount = this.activeCountSet ? this.activeCount : parentMessage.activeCount;
                U64 lookupCount = this.lookupCountSet ? this.lookupCount : parentMessage.lookupCount;
                if(lookupCount == null)
                    throw new NullPointerException("Property lookupCount must not be null");
                U64 matchedCount = this.matchedCountSet ? this.matchedCount : parentMessage.matchedCount;
                if(matchedCount == null)
                    throw new NullPointerException("Property matchedCount must not be null");

                //
                return new OFTableStatsEntryVer13(
                    tableId,
                    activeCount,
                    lookupCount,
                    matchedCount
                );
        }

    }

    static class Builder implements OFTableStatsEntry.Builder {
        // OF message fields
        private boolean tableIdSet;
        private TableId tableId;
        private boolean activeCountSet;
        private long activeCount;
        private boolean lookupCountSet;
        private U64 lookupCount;
        private boolean matchedCountSet;
        private U64 matchedCount;

    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public OFTableStatsEntry.Builder setTableId(TableId tableId) {
        this.tableId = tableId;
        this.tableIdSet = true;
        return this;
    }
    @Override
    public String getName()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property name not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setName(String name) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property name not supported in version 1.3");
    }
    @Override
    public OFMatchBmap getMatch()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property match not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setMatch(OFMatchBmap match) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property match not supported in version 1.3");
    }
    @Override
    public int getWildcards()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property wildcards not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setWildcards(int wildcards) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property wildcards not supported in version 1.3");
    }
    @Override
    public long getWriteActions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property writeActions not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setWriteActions(long writeActions) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property writeActions not supported in version 1.3");
    }
    @Override
    public long getApplyActions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property applyActions not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setApplyActions(long applyActions) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property applyActions not supported in version 1.3");
    }
    @Override
    public U64 getWriteSetfields()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property writeSetfields not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setWriteSetfields(U64 writeSetfields) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property writeSetfields not supported in version 1.3");
    }
    @Override
    public U64 getApplySetfields()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property applySetfields not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setApplySetfields(U64 applySetfields) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property applySetfields not supported in version 1.3");
    }
    @Override
    public U64 getMetadataMatch()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property metadataMatch not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setMetadataMatch(U64 metadataMatch) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property metadataMatch not supported in version 1.3");
    }
    @Override
    public U64 getMetadataWrite()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property metadataWrite not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setMetadataWrite(U64 metadataWrite) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property metadataWrite not supported in version 1.3");
    }
    @Override
    public long getInstructions()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property instructions not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setInstructions(long instructions) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property instructions not supported in version 1.3");
    }
    @Override
    public long getConfig()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property config not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setConfig(long config) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property config not supported in version 1.3");
    }
    @Override
    public long getMaxEntries()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property maxEntries not supported in version 1.3");
    }

    @Override
    public OFTableStatsEntry.Builder setMaxEntries(long maxEntries) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Property maxEntries not supported in version 1.3");
    }
    @Override
    public long getActiveCount() {
        return activeCount;
    }

    @Override
    public OFTableStatsEntry.Builder setActiveCount(long activeCount) {
        this.activeCount = activeCount;
        this.activeCountSet = true;
        return this;
    }
    @Override
    public U64 getLookupCount() {
        return lookupCount;
    }

    @Override
    public OFTableStatsEntry.Builder setLookupCount(U64 lookupCount) {
        this.lookupCount = lookupCount;
        this.lookupCountSet = true;
        return this;
    }
    @Override
    public U64 getMatchedCount() {
        return matchedCount;
    }

    @Override
    public OFTableStatsEntry.Builder setMatchedCount(U64 matchedCount) {
        this.matchedCount = matchedCount;
        this.matchedCountSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

//
        @Override
        public OFTableStatsEntry build() {
            TableId tableId = this.tableIdSet ? this.tableId : DEFAULT_TABLE_ID;
            if(tableId == null)
                throw new NullPointerException("Property tableId must not be null");
            long activeCount = this.activeCountSet ? this.activeCount : DEFAULT_ACTIVE_COUNT;
            U64 lookupCount = this.lookupCountSet ? this.lookupCount : DEFAULT_LOOKUP_COUNT;
            if(lookupCount == null)
                throw new NullPointerException("Property lookupCount must not be null");
            U64 matchedCount = this.matchedCountSet ? this.matchedCount : DEFAULT_MATCHED_COUNT;
            if(matchedCount == null)
                throw new NullPointerException("Property matchedCount must not be null");


            return new OFTableStatsEntryVer13(
                    tableId,
                    activeCount,
                    lookupCount,
                    matchedCount
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFTableStatsEntry> {
        @Override
        public OFTableStatsEntry readFrom(ByteBuf bb) throws OFParseError {
            TableId tableId = TableId.readByte(bb);
            // pad: 3 bytes
            bb.skipBytes(3);
            long activeCount = U32.f(bb.readInt());
            U64 lookupCount = U64.ofRaw(bb.readLong());
            U64 matchedCount = U64.ofRaw(bb.readLong());

            OFTableStatsEntryVer13 tableStatsEntryVer13 = new OFTableStatsEntryVer13(
                    tableId,
                      activeCount,
                      lookupCount,
                      matchedCount
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", tableStatsEntryVer13);
            return tableStatsEntryVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFTableStatsEntryVer13Funnel FUNNEL = new OFTableStatsEntryVer13Funnel();
    static class OFTableStatsEntryVer13Funnel implements Funnel<OFTableStatsEntryVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFTableStatsEntryVer13 message, PrimitiveSink sink) {
            message.tableId.putTo(sink);
            // skip pad (3 bytes)
            sink.putLong(message.activeCount);
            message.lookupCount.putTo(sink);
            message.matchedCount.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFTableStatsEntryVer13> {
        @Override
        public void write(ByteBuf bb, OFTableStatsEntryVer13 message) {
            message.tableId.writeByte(bb);
            // pad: 3 bytes
            bb.writeZero(3);
            bb.writeInt(U32.t(message.activeCount));
            bb.writeLong(message.lookupCount.getValue());
            bb.writeLong(message.matchedCount.getValue());


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFTableStatsEntryVer13(");
        b.append("tableId=").append(tableId);
        b.append(", ");
        b.append("activeCount=").append(activeCount);
        b.append(", ");
        b.append("lookupCount=").append(lookupCount);
        b.append(", ");
        b.append("matchedCount=").append(matchedCount);
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
        OFTableStatsEntryVer13 other = (OFTableStatsEntryVer13) obj;

        if (tableId == null) {
            if (other.tableId != null)
                return false;
        } else if (!tableId.equals(other.tableId))
            return false;
        if( activeCount != other.activeCount)
            return false;
        if (lookupCount == null) {
            if (other.lookupCount != null)
                return false;
        } else if (!lookupCount.equals(other.lookupCount))
            return false;
        if (matchedCount == null) {
            if (other.matchedCount != null)
                return false;
        } else if (!matchedCount.equals(other.matchedCount))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((tableId == null) ? 0 : tableId.hashCode());
        result = prime *  (int) (activeCount ^ (activeCount >>> 32));
        result = prime * result + ((lookupCount == null) ? 0 : lookupCount.hashCode());
        result = prime * result + ((matchedCount == null) ? 0 : matchedCount.hashCode());
        return result;
    }

}
