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

class OFBsnGenericCommandVer14 implements OFBsnGenericCommand {
    private static final Logger logger = LoggerFactory.getLogger(OFBsnGenericCommandVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int MINIMUM_LENGTH = 80;

        private final static long DEFAULT_XID = 0x0L;
        private final static String DEFAULT_NAME = "";
        private final static List<OFBsnTlv> DEFAULT_TLVS = ImmutableList.<OFBsnTlv>of();

    // OF message fields
    private final long xid;
    private final String name;
    private final List<OFBsnTlv> tlvs;
//
    // Immutable default instance
    final static OFBsnGenericCommandVer14 DEFAULT = new OFBsnGenericCommandVer14(
        DEFAULT_XID, DEFAULT_NAME, DEFAULT_TLVS
    );

    // package private constructor - used by readers, builders, and factory
    OFBsnGenericCommandVer14(long xid, String name, List<OFBsnTlv> tlvs) {
        if(name == null) {
            throw new NullPointerException("OFBsnGenericCommandVer14: property name cannot be null");
        }
        if(tlvs == null) {
            throw new NullPointerException("OFBsnGenericCommandVer14: property tlvs cannot be null");
        }
        this.xid = xid;
        this.name = name;
        this.tlvs = tlvs;
    }

    // Accessors for OF message fields
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.EXPERIMENTER;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getSubtype() {
        return 0x47L;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<OFBsnTlv> getTlvs() {
        return tlvs;
    }



    public OFBsnGenericCommand.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFBsnGenericCommand.Builder {
        final OFBsnGenericCommandVer14 parentMessage;

        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean nameSet;
        private String name;
        private boolean tlvsSet;
        private List<OFBsnTlv> tlvs;

        BuilderWithParent(OFBsnGenericCommandVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.EXPERIMENTER;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFBsnGenericCommand.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getSubtype() {
        return 0x47L;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public OFBsnGenericCommand.Builder setName(String name) {
        this.name = name;
        this.nameSet = true;
        return this;
    }
    @Override
    public List<OFBsnTlv> getTlvs() {
        return tlvs;
    }

    @Override
    public OFBsnGenericCommand.Builder setTlvs(List<OFBsnTlv> tlvs) {
        this.tlvs = tlvs;
        this.tlvsSet = true;
        return this;
    }


        @Override
        public OFBsnGenericCommand build() {
                long xid = this.xidSet ? this.xid : parentMessage.xid;
                String name = this.nameSet ? this.name : parentMessage.name;
                if(name == null)
                    throw new NullPointerException("Property name must not be null");
                List<OFBsnTlv> tlvs = this.tlvsSet ? this.tlvs : parentMessage.tlvs;
                if(tlvs == null)
                    throw new NullPointerException("Property tlvs must not be null");

                //
                return new OFBsnGenericCommandVer14(
                    xid,
                    name,
                    tlvs
                );
        }

    }

    static class Builder implements OFBsnGenericCommand.Builder {
        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean nameSet;
        private String name;
        private boolean tlvsSet;
        private List<OFBsnTlv> tlvs;

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

    @Override
    public OFType getType() {
        return OFType.EXPERIMENTER;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFBsnGenericCommand.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getSubtype() {
        return 0x47L;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public OFBsnGenericCommand.Builder setName(String name) {
        this.name = name;
        this.nameSet = true;
        return this;
    }
    @Override
    public List<OFBsnTlv> getTlvs() {
        return tlvs;
    }

    @Override
    public OFBsnGenericCommand.Builder setTlvs(List<OFBsnTlv> tlvs) {
        this.tlvs = tlvs;
        this.tlvsSet = true;
        return this;
    }
//
        @Override
        public OFBsnGenericCommand build() {
            long xid = this.xidSet ? this.xid : DEFAULT_XID;
            String name = this.nameSet ? this.name : DEFAULT_NAME;
            if(name == null)
                throw new NullPointerException("Property name must not be null");
            List<OFBsnTlv> tlvs = this.tlvsSet ? this.tlvs : DEFAULT_TLVS;
            if(tlvs == null)
                throw new NullPointerException("Property tlvs must not be null");


            return new OFBsnGenericCommandVer14(
                    xid,
                    name,
                    tlvs
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFBsnGenericCommand> {
        @Override
        public OFBsnGenericCommand readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property version == 5
            byte version = bb.readByte();
            if(version != (byte) 0x5)
                throw new OFParseError("Wrong version: Expected=OFVersion.OF_14(5), got="+version);
            // fixed value property type == 4
            byte type = bb.readByte();
            if(type != (byte) 0x4)
                throw new OFParseError("Wrong type: Expected=OFType.EXPERIMENTER(4), got="+type);
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
            // fixed value property experimenter == 0x5c16c7L
            int experimenter = bb.readInt();
            if(experimenter != 0x5c16c7)
                throw new OFParseError("Wrong experimenter: Expected=0x5c16c7L(0x5c16c7L), got="+experimenter);
            // fixed value property subtype == 0x47L
            int subtype = bb.readInt();
            if(subtype != 0x47)
                throw new OFParseError("Wrong subtype: Expected=0x47L(0x47L), got="+subtype);
            String name = ChannelUtils.readFixedLengthString(bb, 64);
            List<OFBsnTlv> tlvs = ChannelUtils.readList(bb, length - (bb.readerIndex() - start), OFBsnTlvVer14.READER);

            OFBsnGenericCommandVer14 bsnGenericCommandVer14 = new OFBsnGenericCommandVer14(
                    xid,
                      name,
                      tlvs
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", bsnGenericCommandVer14);
            return bsnGenericCommandVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFBsnGenericCommandVer14Funnel FUNNEL = new OFBsnGenericCommandVer14Funnel();
    static class OFBsnGenericCommandVer14Funnel implements Funnel<OFBsnGenericCommandVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFBsnGenericCommandVer14 message, PrimitiveSink sink) {
            // fixed value property version = 5
            sink.putByte((byte) 0x5);
            // fixed value property type = 4
            sink.putByte((byte) 0x4);
            // FIXME: skip funnel of length
            sink.putLong(message.xid);
            // fixed value property experimenter = 0x5c16c7L
            sink.putInt(0x5c16c7);
            // fixed value property subtype = 0x47L
            sink.putInt(0x47);
            sink.putUnencodedChars(message.name);
            FunnelUtils.putList(message.tlvs, sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFBsnGenericCommandVer14> {
        @Override
        public void write(ByteBuf bb, OFBsnGenericCommandVer14 message) {
            int startIndex = bb.writerIndex();
            // fixed value property version = 5
            bb.writeByte((byte) 0x5);
            // fixed value property type = 4
            bb.writeByte((byte) 0x4);
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            bb.writeInt(U32.t(message.xid));
            // fixed value property experimenter = 0x5c16c7L
            bb.writeInt(0x5c16c7);
            // fixed value property subtype = 0x47L
            bb.writeInt(0x47);
            ChannelUtils.writeFixedLengthString(bb, message.name, 64);
            ChannelUtils.writeList(bb, message.tlvs);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFBsnGenericCommandVer14(");
        b.append("xid=").append(xid);
        b.append(", ");
        b.append("name=").append(name);
        b.append(", ");
        b.append("tlvs=").append(tlvs);
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
        OFBsnGenericCommandVer14 other = (OFBsnGenericCommandVer14) obj;

        if( xid != other.xid)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (tlvs == null) {
            if (other.tlvs != null)
                return false;
        } else if (!tlvs.equals(other.tlvs))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime *  (int) (xid ^ (xid >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tlvs == null) ? 0 : tlvs.hashCode());
        return result;
    }

}
