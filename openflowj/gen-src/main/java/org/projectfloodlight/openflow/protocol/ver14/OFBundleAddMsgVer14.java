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
import java.util.Set;
import com.google.common.collect.ImmutableSet;
import org.jboss.netty.buffer.ChannelBuffer;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;
import java.util.Arrays;

class OFBundleAddMsgVer14 implements OFBundleAddMsg {
    private static final Logger logger = LoggerFactory.getLogger(OFBundleAddMsgVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int MINIMUM_LENGTH = 16;

        private final static long DEFAULT_XID = 0x0L;
        private final static long DEFAULT_BUNDLE_ID = 0x0L;
        private final static Set<OFBundleFlags> DEFAULT_FLAGS = ImmutableSet.<OFBundleFlags>of();
        private final static byte[] DEFAULT_DATA = new byte[0];

    // OF message fields
    private final long xid;
    private final long bundleId;
    private final Set<OFBundleFlags> flags;
    private final byte[] data;
//
    // Immutable default instance
    final static OFBundleAddMsgVer14 DEFAULT = new OFBundleAddMsgVer14(
        DEFAULT_XID, DEFAULT_BUNDLE_ID, DEFAULT_FLAGS, DEFAULT_DATA
    );

    // package private constructor - used by readers, builders, and factory
    OFBundleAddMsgVer14(long xid, long bundleId, Set<OFBundleFlags> flags, byte[] data) {
        this.xid = xid;
        this.bundleId = bundleId;
        this.flags = flags;
        this.data = data;
    }

    // Accessors for OF message fields
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.BUNDLE_ADD_MESSAGE;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public long getBundleId() {
        return bundleId;
    }

    @Override
    public Set<OFBundleFlags> getFlags() {
        return flags;
    }

    @Override
    public byte[] getData() {
        return data;
    }



    public OFBundleAddMsg.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFBundleAddMsg.Builder {
        final OFBundleAddMsgVer14 parentMessage;

        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean bundleIdSet;
        private long bundleId;
        private boolean flagsSet;
        private Set<OFBundleFlags> flags;
        private boolean dataSet;
        private byte[] data;

        BuilderWithParent(OFBundleAddMsgVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.BUNDLE_ADD_MESSAGE;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFBundleAddMsg.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public long getBundleId() {
        return bundleId;
    }

    @Override
    public OFBundleAddMsg.Builder setBundleId(long bundleId) {
        this.bundleId = bundleId;
        this.bundleIdSet = true;
        return this;
    }
    @Override
    public Set<OFBundleFlags> getFlags() {
        return flags;
    }

    @Override
    public OFBundleAddMsg.Builder setFlags(Set<OFBundleFlags> flags) {
        this.flags = flags;
        this.flagsSet = true;
        return this;
    }
    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public OFBundleAddMsg.Builder setData(byte[] data) {
        this.data = data;
        this.dataSet = true;
        return this;
    }


        @Override
        public OFBundleAddMsg build() {
                long xid = this.xidSet ? this.xid : parentMessage.xid;
                long bundleId = this.bundleIdSet ? this.bundleId : parentMessage.bundleId;
                Set<OFBundleFlags> flags = this.flagsSet ? this.flags : parentMessage.flags;
                if(flags == null)
                    throw new NullPointerException("Property flags must not be null");
                byte[] data = this.dataSet ? this.data : parentMessage.data;
                if(data == null)
                    throw new NullPointerException("Property data must not be null");

                //
                return new OFBundleAddMsgVer14(
                    xid,
                    bundleId,
                    flags,
                    data
                );
        }

    }

    static class Builder implements OFBundleAddMsg.Builder {
        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean bundleIdSet;
        private long bundleId;
        private boolean flagsSet;
        private Set<OFBundleFlags> flags;
        private boolean dataSet;
        private byte[] data;

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.BUNDLE_ADD_MESSAGE;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFBundleAddMsg.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public long getBundleId() {
        return bundleId;
    }

    @Override
    public OFBundleAddMsg.Builder setBundleId(long bundleId) {
        this.bundleId = bundleId;
        this.bundleIdSet = true;
        return this;
    }
    @Override
    public Set<OFBundleFlags> getFlags() {
        return flags;
    }

    @Override
    public OFBundleAddMsg.Builder setFlags(Set<OFBundleFlags> flags) {
        this.flags = flags;
        this.flagsSet = true;
        return this;
    }
    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public OFBundleAddMsg.Builder setData(byte[] data) {
        this.data = data;
        this.dataSet = true;
        return this;
    }
//
        @Override
        public OFBundleAddMsg build() {
            long xid = this.xidSet ? this.xid : DEFAULT_XID;
            long bundleId = this.bundleIdSet ? this.bundleId : DEFAULT_BUNDLE_ID;
            Set<OFBundleFlags> flags = this.flagsSet ? this.flags : DEFAULT_FLAGS;
            if(flags == null)
                throw new NullPointerException("Property flags must not be null");
            byte[] data = this.dataSet ? this.data : DEFAULT_DATA;
            if(data == null)
                throw new NullPointerException("Property data must not be null");


            return new OFBundleAddMsgVer14(
                    xid,
                    bundleId,
                    flags,
                    data
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFBundleAddMsg> {
        @Override
        public OFBundleAddMsg readFrom(ChannelBuffer bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property version == 5
            byte version = bb.readByte();
            if(version != (byte) 0x5)
                throw new OFParseError("Wrong version: Expected=OFVersion.OF_14(5), got="+version);
            // fixed value property type == 34
            byte type = bb.readByte();
            if(type != (byte) 0x22)
                throw new OFParseError("Wrong type: Expected=OFType.BUNDLE_ADD_MESSAGE(34), got="+type);
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
            long bundleId = U32.f(bb.readInt());
            // pad: 2 bytes
            bb.skipBytes(2);
            Set<OFBundleFlags> flags = OFBundleFlagsSerializerVer14.readFrom(bb);
            byte[] data = ChannelUtils.readBytes(bb, length - (bb.readerIndex() - start));

            OFBundleAddMsgVer14 bundleAddMsgVer14 = new OFBundleAddMsgVer14(
                    xid,
                      bundleId,
                      flags,
                      data
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", bundleAddMsgVer14);
            return bundleAddMsgVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFBundleAddMsgVer14Funnel FUNNEL = new OFBundleAddMsgVer14Funnel();
    static class OFBundleAddMsgVer14Funnel implements Funnel<OFBundleAddMsgVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFBundleAddMsgVer14 message, PrimitiveSink sink) {
            // fixed value property version = 5
            sink.putByte((byte) 0x5);
            // fixed value property type = 34
            sink.putByte((byte) 0x22);
            // FIXME: skip funnel of length
            sink.putLong(message.xid);
            sink.putLong(message.bundleId);
            // skip pad (2 bytes)
            OFBundleFlagsSerializerVer14.putTo(message.flags, sink);
            sink.putBytes(message.data);
        }
    }


    public void writeTo(ChannelBuffer bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFBundleAddMsgVer14> {
        @Override
        public void write(ChannelBuffer bb, OFBundleAddMsgVer14 message) {
            int startIndex = bb.writerIndex();
            // fixed value property version = 5
            bb.writeByte((byte) 0x5);
            // fixed value property type = 34
            bb.writeByte((byte) 0x22);
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            bb.writeInt(U32.t(message.xid));
            bb.writeInt(U32.t(message.bundleId));
            // pad: 2 bytes
            bb.writeZero(2);
            OFBundleFlagsSerializerVer14.writeTo(bb, message.flags);
            bb.writeBytes(message.data);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFBundleAddMsgVer14(");
        b.append("xid=").append(xid);
        b.append(", ");
        b.append("bundleId=").append(bundleId);
        b.append(", ");
        b.append("flags=").append(flags);
        b.append(", ");
        b.append("data=").append(Arrays.toString(data));
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
        OFBundleAddMsgVer14 other = (OFBundleAddMsgVer14) obj;

        if( xid != other.xid)
            return false;
        if( bundleId != other.bundleId)
            return false;
        if (flags == null) {
            if (other.flags != null)
                return false;
        } else if (!flags.equals(other.flags))
            return false;
        if (!Arrays.equals(data, other.data))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime *  (int) (xid ^ (xid >>> 32));
        result = prime *  (int) (bundleId ^ (bundleId >>> 32));
        result = prime * result + ((flags == null) ? 0 : flags.hashCode());
        result = prime * result + Arrays.hashCode(data);
        return result;
    }

}