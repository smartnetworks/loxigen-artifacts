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
import org.projectfloodlight.openflow.protocol.stat.*;
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.oxs.*;
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

class OFTableModVer14 implements OFTableMod {
    private static final Logger logger = LoggerFactory.getLogger(OFTableModVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int MINIMUM_LENGTH = 16;

        private final static long DEFAULT_XID = 0x0L;
        private final static TableId DEFAULT_TABLE_ID = TableId.ALL;
        private final static long DEFAULT_CONFIG = 0x0L;
        private final static List<OFTableModProp> DEFAULT_PROPERTIES = ImmutableList.<OFTableModProp>of();

    // OF message fields
    private final long xid;
    private final TableId tableId;
    private final long config;
    private final List<OFTableModProp> properties;
//
    // Immutable default instance
    final static OFTableModVer14 DEFAULT = new OFTableModVer14(
        DEFAULT_XID, DEFAULT_TABLE_ID, DEFAULT_CONFIG, DEFAULT_PROPERTIES
    );

    // package private constructor - used by readers, builders, and factory
    OFTableModVer14(long xid, TableId tableId, long config, List<OFTableModProp> properties) {
        if(tableId == null) {
            throw new NullPointerException("OFTableModVer14: property tableId cannot be null");
        }
        if(properties == null) {
            throw new NullPointerException("OFTableModVer14: property properties cannot be null");
        }
        this.xid = xid;
        this.tableId = tableId;
        this.config = config;
        this.properties = properties;
    }

    // Accessors for OF message fields
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.TABLE_MOD;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public long getConfig() {
        return config;
    }

    @Override
    public List<OFTableModProp> getProperties() {
        return properties;
    }



    public OFTableMod.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFTableMod.Builder {
        final OFTableModVer14 parentMessage;

        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean tableIdSet;
        private TableId tableId;
        private boolean configSet;
        private long config;
        private boolean propertiesSet;
        private List<OFTableModProp> properties;

        BuilderWithParent(OFTableModVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.TABLE_MOD;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFTableMod.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public OFTableMod.Builder setTableId(TableId tableId) {
        this.tableId = tableId;
        this.tableIdSet = true;
        return this;
    }
    @Override
    public long getConfig() {
        return config;
    }

    @Override
    public OFTableMod.Builder setConfig(long config) {
        this.config = config;
        this.configSet = true;
        return this;
    }
    @Override
    public List<OFTableModProp> getProperties() {
        return properties;
    }

    @Override
    public OFTableMod.Builder setProperties(List<OFTableModProp> properties) {
        this.properties = properties;
        this.propertiesSet = true;
        return this;
    }


        @Override
        public OFTableMod build() {
                long xid = this.xidSet ? this.xid : parentMessage.xid;
                TableId tableId = this.tableIdSet ? this.tableId : parentMessage.tableId;
                if(tableId == null)
                    throw new NullPointerException("Property tableId must not be null");
                long config = this.configSet ? this.config : parentMessage.config;
                List<OFTableModProp> properties = this.propertiesSet ? this.properties : parentMessage.properties;
                if(properties == null)
                    throw new NullPointerException("Property properties must not be null");

                //
                return new OFTableModVer14(
                    xid,
                    tableId,
                    config,
                    properties
                );
        }

    }

    static class Builder implements OFTableMod.Builder {
        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean tableIdSet;
        private TableId tableId;
        private boolean configSet;
        private long config;
        private boolean propertiesSet;
        private List<OFTableModProp> properties;

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.TABLE_MOD;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFTableMod.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public TableId getTableId() {
        return tableId;
    }

    @Override
    public OFTableMod.Builder setTableId(TableId tableId) {
        this.tableId = tableId;
        this.tableIdSet = true;
        return this;
    }
    @Override
    public long getConfig() {
        return config;
    }

    @Override
    public OFTableMod.Builder setConfig(long config) {
        this.config = config;
        this.configSet = true;
        return this;
    }
    @Override
    public List<OFTableModProp> getProperties() {
        return properties;
    }

    @Override
    public OFTableMod.Builder setProperties(List<OFTableModProp> properties) {
        this.properties = properties;
        this.propertiesSet = true;
        return this;
    }
//
        @Override
        public OFTableMod build() {
            long xid = this.xidSet ? this.xid : DEFAULT_XID;
            TableId tableId = this.tableIdSet ? this.tableId : DEFAULT_TABLE_ID;
            if(tableId == null)
                throw new NullPointerException("Property tableId must not be null");
            long config = this.configSet ? this.config : DEFAULT_CONFIG;
            List<OFTableModProp> properties = this.propertiesSet ? this.properties : DEFAULT_PROPERTIES;
            if(properties == null)
                throw new NullPointerException("Property properties must not be null");


            return new OFTableModVer14(
                    xid,
                    tableId,
                    config,
                    properties
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFTableMod> {
        @Override
        public OFTableMod readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property version == 5
            byte version = bb.readByte();
            if(version != (byte) 0x5)
                throw new OFParseError("Wrong version: Expected=OFVersion.OF_14(5), got="+version);
            // fixed value property type == 17
            byte type = bb.readByte();
            if(type != (byte) 0x11)
                throw new OFParseError("Wrong type: Expected=OFType.TABLE_MOD(17), got="+type);
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
            long xid = U32.f(bb.readInt());
            TableId tableId = TableId.readByte(bb);
            // pad: 3 bytes
            bb.skipBytes(3);
            long config = U32.f(bb.readInt());
            List<OFTableModProp> properties = ChannelUtils.readList(bb, length - (bb.readerIndex() - start), OFTableModPropVer14.READER);

            OFTableModVer14 tableModVer14 = new OFTableModVer14(
                    xid,
                      tableId,
                      config,
                      properties
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", tableModVer14);
            return tableModVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFTableModVer14Funnel FUNNEL = new OFTableModVer14Funnel();
    static class OFTableModVer14Funnel implements Funnel<OFTableModVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFTableModVer14 message, PrimitiveSink sink) {
            // fixed value property version = 5
            sink.putByte((byte) 0x5);
            // fixed value property type = 17
            sink.putByte((byte) 0x11);
            // FIXME: skip funnel of length
            sink.putLong(message.xid);
            message.tableId.putTo(sink);
            // skip pad (3 bytes)
            sink.putLong(message.config);
            FunnelUtils.putList(message.properties, sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFTableModVer14> {
        @Override
        public void write(ByteBuf bb, OFTableModVer14 message) {
            int startIndex = bb.writerIndex();
            // fixed value property version = 5
            bb.writeByte((byte) 0x5);
            // fixed value property type = 17
            bb.writeByte((byte) 0x11);
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            bb.writeInt(U32.t(message.xid));
            message.tableId.writeByte(bb);
            // pad: 3 bytes
            bb.writeZero(3);
            bb.writeInt(U32.t(message.config));
            ChannelUtils.writeList(bb, message.properties);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFTableModVer14(");
        b.append("xid=").append(xid);
        b.append(", ");
        b.append("tableId=").append(tableId);
        b.append(", ");
        b.append("config=").append(config);
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
        OFTableModVer14 other = (OFTableModVer14) obj;

        if( xid != other.xid)
            return false;
        if (tableId == null) {
            if (other.tableId != null)
                return false;
        } else if (!tableId.equals(other.tableId))
            return false;
        if( config != other.config)
            return false;
        if (properties == null) {
            if (other.properties != null)
                return false;
        } else if (!properties.equals(other.properties))
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
        OFTableModVer14 other = (OFTableModVer14) obj;

        // ignore XID
        if (tableId == null) {
            if (other.tableId != null)
                return false;
        } else if (!tableId.equals(other.tableId))
            return false;
        if( config != other.config)
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

        result = prime *  (int) (xid ^ (xid >>> 32));
        result = prime * result + ((tableId == null) ? 0 : tableId.hashCode());
        result = prime *  (int) (config ^ (config >>> 32));
        result = prime * result + ((properties == null) ? 0 : properties.hashCode());
        return result;
    }

    @Override
    public int hashCodeIgnoreXid() {
        final int prime = 31;
        int result = 1;

        // ignore XID
        result = prime * result + ((tableId == null) ? 0 : tableId.hashCode());
        result = prime *  (int) (config ^ (config >>> 32));
        result = prime * result + ((properties == null) ? 0 : properties.hashCode());
        return result;
    }

}
