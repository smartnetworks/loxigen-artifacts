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

class OFTableFeaturesVer14 implements OFTableFeatures {
    private static final Logger logger = LoggerFactory.getLogger(OFTableFeaturesVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int MINIMUM_LENGTH = 64;

        private final static TableId DEFAULT_TABLE_ID = TableId.ALL;
        private final static String DEFAULT_NAME = "";
        private final static U64 DEFAULT_METADATA_MATCH = U64.ZERO;
        private final static U64 DEFAULT_METADATA_WRITE = U64.ZERO;
        private final static long DEFAULT_CONFIG = 0x0L;
        private final static long DEFAULT_MAX_ENTRIES = 0x0L;
        private final static List<OFTableFeatureProp> DEFAULT_PROPERTIES = ImmutableList.<OFTableFeatureProp>of();

    // OF message fields
    private final TableId tableId;
    private final String name;
    private final U64 metadataMatch;
    private final U64 metadataWrite;
    private final long config;
    private final long maxEntries;
    private final List<OFTableFeatureProp> properties;
//
    // Immutable default instance
    final static OFTableFeaturesVer14 DEFAULT = new OFTableFeaturesVer14(
        DEFAULT_TABLE_ID, DEFAULT_NAME, DEFAULT_METADATA_MATCH, DEFAULT_METADATA_WRITE, DEFAULT_CONFIG, DEFAULT_MAX_ENTRIES, DEFAULT_PROPERTIES
    );

    // package private constructor - used by readers, builders, and factory
    OFTableFeaturesVer14(TableId tableId, String name, U64 metadataMatch, U64 metadataWrite, long config, long maxEntries, List<OFTableFeatureProp> properties) {
        if(tableId == null) {
            throw new NullPointerException("OFTableFeaturesVer14: property tableId cannot be null");
        }
        if(name == null) {
            throw new NullPointerException("OFTableFeaturesVer14: property name cannot be null");
        }
        if(metadataMatch == null) {
            throw new NullPointerException("OFTableFeaturesVer14: property metadataMatch cannot be null");
        }
        if(metadataWrite == null) {
            throw new NullPointerException("OFTableFeaturesVer14: property metadataWrite cannot be null");
        }
        if(properties == null) {
            throw new NullPointerException("OFTableFeaturesVer14: property properties cannot be null");
        }
        this.tableId = tableId;
        this.name = name;
        this.metadataMatch = metadataMatch;
        this.metadataWrite = metadataWrite;
        this.config = config;
        this.maxEntries = maxEntries;
        this.properties = properties;
    }

    // Accessors for OF message fields
    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public U64 getMetadataMatch() {
        return metadataMatch;
    }

    @Override
    public U64 getMetadataWrite() {
        return metadataWrite;
    }

    @Override
    public long getConfig() {
        return config;
    }

    @Override
    public long getMaxEntries() {
        return maxEntries;
    }

    @Override
    public List<OFTableFeatureProp> getProperties() {
        return properties;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFTableFeatures.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFTableFeatures.Builder {
        final OFTableFeaturesVer14 parentMessage;

        // OF message fields
        private boolean tableIdSet;
        private TableId tableId;
        private boolean nameSet;
        private String name;
        private boolean metadataMatchSet;
        private U64 metadataMatch;
        private boolean metadataWriteSet;
        private U64 metadataWrite;
        private boolean configSet;
        private long config;
        private boolean maxEntriesSet;
        private long maxEntries;
        private boolean propertiesSet;
        private List<OFTableFeatureProp> properties;

        BuilderWithParent(OFTableFeaturesVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public OFTableFeatures.Builder setTableId(TableId tableId) {
        this.tableId = tableId;
        this.tableIdSet = true;
        return this;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public OFTableFeatures.Builder setName(String name) {
        this.name = name;
        this.nameSet = true;
        return this;
    }
    @Override
    public U64 getMetadataMatch() {
        return metadataMatch;
    }

    @Override
    public OFTableFeatures.Builder setMetadataMatch(U64 metadataMatch) {
        this.metadataMatch = metadataMatch;
        this.metadataMatchSet = true;
        return this;
    }
    @Override
    public U64 getMetadataWrite() {
        return metadataWrite;
    }

    @Override
    public OFTableFeatures.Builder setMetadataWrite(U64 metadataWrite) {
        this.metadataWrite = metadataWrite;
        this.metadataWriteSet = true;
        return this;
    }
    @Override
    public long getConfig() {
        return config;
    }

    @Override
    public OFTableFeatures.Builder setConfig(long config) {
        this.config = config;
        this.configSet = true;
        return this;
    }
    @Override
    public long getMaxEntries() {
        return maxEntries;
    }

    @Override
    public OFTableFeatures.Builder setMaxEntries(long maxEntries) {
        this.maxEntries = maxEntries;
        this.maxEntriesSet = true;
        return this;
    }
    @Override
    public List<OFTableFeatureProp> getProperties() {
        return properties;
    }

    @Override
    public OFTableFeatures.Builder setProperties(List<OFTableFeatureProp> properties) {
        this.properties = properties;
        this.propertiesSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFTableFeatures build() {
                TableId tableId = this.tableIdSet ? this.tableId : parentMessage.tableId;
                if(tableId == null)
                    throw new NullPointerException("Property tableId must not be null");
                String name = this.nameSet ? this.name : parentMessage.name;
                if(name == null)
                    throw new NullPointerException("Property name must not be null");
                U64 metadataMatch = this.metadataMatchSet ? this.metadataMatch : parentMessage.metadataMatch;
                if(metadataMatch == null)
                    throw new NullPointerException("Property metadataMatch must not be null");
                U64 metadataWrite = this.metadataWriteSet ? this.metadataWrite : parentMessage.metadataWrite;
                if(metadataWrite == null)
                    throw new NullPointerException("Property metadataWrite must not be null");
                long config = this.configSet ? this.config : parentMessage.config;
                long maxEntries = this.maxEntriesSet ? this.maxEntries : parentMessage.maxEntries;
                List<OFTableFeatureProp> properties = this.propertiesSet ? this.properties : parentMessage.properties;
                if(properties == null)
                    throw new NullPointerException("Property properties must not be null");

                //
                return new OFTableFeaturesVer14(
                    tableId,
                    name,
                    metadataMatch,
                    metadataWrite,
                    config,
                    maxEntries,
                    properties
                );
        }

    }

    static class Builder implements OFTableFeatures.Builder {
        // OF message fields
        private boolean tableIdSet;
        private TableId tableId;
        private boolean nameSet;
        private String name;
        private boolean metadataMatchSet;
        private U64 metadataMatch;
        private boolean metadataWriteSet;
        private U64 metadataWrite;
        private boolean configSet;
        private long config;
        private boolean maxEntriesSet;
        private long maxEntries;
        private boolean propertiesSet;
        private List<OFTableFeatureProp> properties;

    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public OFTableFeatures.Builder setTableId(TableId tableId) {
        this.tableId = tableId;
        this.tableIdSet = true;
        return this;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public OFTableFeatures.Builder setName(String name) {
        this.name = name;
        this.nameSet = true;
        return this;
    }
    @Override
    public U64 getMetadataMatch() {
        return metadataMatch;
    }

    @Override
    public OFTableFeatures.Builder setMetadataMatch(U64 metadataMatch) {
        this.metadataMatch = metadataMatch;
        this.metadataMatchSet = true;
        return this;
    }
    @Override
    public U64 getMetadataWrite() {
        return metadataWrite;
    }

    @Override
    public OFTableFeatures.Builder setMetadataWrite(U64 metadataWrite) {
        this.metadataWrite = metadataWrite;
        this.metadataWriteSet = true;
        return this;
    }
    @Override
    public long getConfig() {
        return config;
    }

    @Override
    public OFTableFeatures.Builder setConfig(long config) {
        this.config = config;
        this.configSet = true;
        return this;
    }
    @Override
    public long getMaxEntries() {
        return maxEntries;
    }

    @Override
    public OFTableFeatures.Builder setMaxEntries(long maxEntries) {
        this.maxEntries = maxEntries;
        this.maxEntriesSet = true;
        return this;
    }
    @Override
    public List<OFTableFeatureProp> getProperties() {
        return properties;
    }

    @Override
    public OFTableFeatures.Builder setProperties(List<OFTableFeatureProp> properties) {
        this.properties = properties;
        this.propertiesSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFTableFeatures build() {
            TableId tableId = this.tableIdSet ? this.tableId : DEFAULT_TABLE_ID;
            if(tableId == null)
                throw new NullPointerException("Property tableId must not be null");
            String name = this.nameSet ? this.name : DEFAULT_NAME;
            if(name == null)
                throw new NullPointerException("Property name must not be null");
            U64 metadataMatch = this.metadataMatchSet ? this.metadataMatch : DEFAULT_METADATA_MATCH;
            if(metadataMatch == null)
                throw new NullPointerException("Property metadataMatch must not be null");
            U64 metadataWrite = this.metadataWriteSet ? this.metadataWrite : DEFAULT_METADATA_WRITE;
            if(metadataWrite == null)
                throw new NullPointerException("Property metadataWrite must not be null");
            long config = this.configSet ? this.config : DEFAULT_CONFIG;
            long maxEntries = this.maxEntriesSet ? this.maxEntries : DEFAULT_MAX_ENTRIES;
            List<OFTableFeatureProp> properties = this.propertiesSet ? this.properties : DEFAULT_PROPERTIES;
            if(properties == null)
                throw new NullPointerException("Property properties must not be null");


            return new OFTableFeaturesVer14(
                    tableId,
                    name,
                    metadataMatch,
                    metadataWrite,
                    config,
                    maxEntries,
                    properties
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFTableFeatures> {
        @Override
        public OFTableFeatures readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
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
            TableId tableId = TableId.readByte(bb);
            // pad: 5 bytes
            bb.skipBytes(5);
            String name = ChannelUtils.readFixedLengthString(bb, 32);
            U64 metadataMatch = U64.ofRaw(bb.readLong());
            U64 metadataWrite = U64.ofRaw(bb.readLong());
            long config = U32.f(bb.readInt());
            long maxEntries = U32.f(bb.readInt());
            List<OFTableFeatureProp> properties = ChannelUtils.readList(bb, length - (bb.readerIndex() - start), OFTableFeaturePropVer14.READER);

            OFTableFeaturesVer14 tableFeaturesVer14 = new OFTableFeaturesVer14(
                    tableId,
                      name,
                      metadataMatch,
                      metadataWrite,
                      config,
                      maxEntries,
                      properties
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", tableFeaturesVer14);
            return tableFeaturesVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFTableFeaturesVer14Funnel FUNNEL = new OFTableFeaturesVer14Funnel();
    static class OFTableFeaturesVer14Funnel implements Funnel<OFTableFeaturesVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFTableFeaturesVer14 message, PrimitiveSink sink) {
            // FIXME: skip funnel of length
            message.tableId.putTo(sink);
            // skip pad (5 bytes)
            sink.putUnencodedChars(message.name);
            message.metadataMatch.putTo(sink);
            message.metadataWrite.putTo(sink);
            sink.putLong(message.config);
            sink.putLong(message.maxEntries);
            FunnelUtils.putList(message.properties, sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFTableFeaturesVer14> {
        @Override
        public void write(ByteBuf bb, OFTableFeaturesVer14 message) {
            int startIndex = bb.writerIndex();
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            message.tableId.writeByte(bb);
            // pad: 5 bytes
            bb.writeZero(5);
            ChannelUtils.writeFixedLengthString(bb, message.name, 32);
            bb.writeLong(message.metadataMatch.getValue());
            bb.writeLong(message.metadataWrite.getValue());
            bb.writeInt(U32.t(message.config));
            bb.writeInt(U32.t(message.maxEntries));
            ChannelUtils.writeList(bb, message.properties);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFTableFeaturesVer14(");
        b.append("tableId=").append(tableId);
        b.append(", ");
        b.append("name=").append(name);
        b.append(", ");
        b.append("metadataMatch=").append(metadataMatch);
        b.append(", ");
        b.append("metadataWrite=").append(metadataWrite);
        b.append(", ");
        b.append("config=").append(config);
        b.append(", ");
        b.append("maxEntries=").append(maxEntries);
        b.append(", ");
        b.append("properties=").append(properties);
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
        OFTableFeaturesVer14 other = (OFTableFeaturesVer14) obj;

        if (tableId == null) {
            if (other.tableId != null)
                return false;
        } else if (!tableId.equals(other.tableId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (metadataMatch == null) {
            if (other.metadataMatch != null)
                return false;
        } else if (!metadataMatch.equals(other.metadataMatch))
            return false;
        if (metadataWrite == null) {
            if (other.metadataWrite != null)
                return false;
        } else if (!metadataWrite.equals(other.metadataWrite))
            return false;
        if( config != other.config)
            return false;
        if( maxEntries != other.maxEntries)
            return false;
        if (properties == null) {
            if (other.properties != null)
                return false;
        } else if (!properties.equals(other.properties))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((tableId == null) ? 0 : tableId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((metadataMatch == null) ? 0 : metadataMatch.hashCode());
        result = prime * result + ((metadataWrite == null) ? 0 : metadataWrite.hashCode());
        result = prime *  (int) (config ^ (config >>> 32));
        result = prime *  (int) (maxEntries ^ (maxEntries >>> 32));
        result = prime * result + ((properties == null) ? 0 : properties.hashCode());
        return result;
    }

}
