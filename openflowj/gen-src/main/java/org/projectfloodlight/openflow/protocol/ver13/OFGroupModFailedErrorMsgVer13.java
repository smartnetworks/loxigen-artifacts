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
import org.projectfloodlight.openflow.protocol.meterband.*;
import org.projectfloodlight.openflow.protocol.instruction.*;
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

class OFGroupModFailedErrorMsgVer13 implements OFGroupModFailedErrorMsg {
    private static final Logger logger = LoggerFactory.getLogger(OFGroupModFailedErrorMsgVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int MINIMUM_LENGTH = 12;

        private final static long DEFAULT_XID = 0x0L;
        private final static byte[] DEFAULT_DATA = new byte[0];

    // OF message fields
    private final long xid;
    private final OFGroupModFailedCode code;
    private final byte[] data;
//

    // package private constructor - used by readers, builders, and factory
    OFGroupModFailedErrorMsgVer13(long xid, OFGroupModFailedCode code, byte[] data) {
        this.xid = xid;
        this.code = code;
        this.data = data;
    }

    // Accessors for OF message fields
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

    @Override
    public OFType getType() {
        return OFType.ERROR;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFErrorType getErrType() {
        return OFErrorType.GROUP_MOD_FAILED;
    }

    @Override
    public OFGroupModFailedCode getCode() {
        return code;
    }

    @Override
    public byte[] getData() {
        return data;
    }



    public OFGroupModFailedErrorMsg.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFGroupModFailedErrorMsg.Builder {
        final OFGroupModFailedErrorMsgVer13 parentMessage;

        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean codeSet;
        private OFGroupModFailedCode code;
        private boolean dataSet;
        private byte[] data;

        BuilderWithParent(OFGroupModFailedErrorMsgVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

    @Override
    public OFType getType() {
        return OFType.ERROR;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFGroupModFailedErrorMsg.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public OFErrorType getErrType() {
        return OFErrorType.GROUP_MOD_FAILED;
    }

    @Override
    public OFGroupModFailedCode getCode() {
        return code;
    }

    @Override
    public OFGroupModFailedErrorMsg.Builder setCode(OFGroupModFailedCode code) {
        this.code = code;
        this.codeSet = true;
        return this;
    }
    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public OFGroupModFailedErrorMsg.Builder setData(byte[] data) {
        this.data = data;
        this.dataSet = true;
        return this;
    }


        @Override
        public OFGroupModFailedErrorMsg build() {
                long xid = this.xidSet ? this.xid : parentMessage.xid;
                OFGroupModFailedCode code = this.codeSet ? this.code : parentMessage.code;
                if(code == null)
                    throw new NullPointerException("Property code must not be null");
                byte[] data = this.dataSet ? this.data : parentMessage.data;
                if(data == null)
                    throw new NullPointerException("Property data must not be null");

                //
                return new OFGroupModFailedErrorMsgVer13(
                    xid,
                    code,
                    data
                );
        }

    }

    static class Builder implements OFGroupModFailedErrorMsg.Builder {
        // OF message fields
        private boolean xidSet;
        private long xid;
        private boolean codeSet;
        private OFGroupModFailedCode code;
        private boolean dataSet;
        private byte[] data;

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

    @Override
    public OFType getType() {
        return OFType.ERROR;
    }

    @Override
    public long getXid() {
        return xid;
    }

    @Override
    public OFGroupModFailedErrorMsg.Builder setXid(long xid) {
        this.xid = xid;
        this.xidSet = true;
        return this;
    }
    @Override
    public OFErrorType getErrType() {
        return OFErrorType.GROUP_MOD_FAILED;
    }

    @Override
    public OFGroupModFailedCode getCode() {
        return code;
    }

    @Override
    public OFGroupModFailedErrorMsg.Builder setCode(OFGroupModFailedCode code) {
        this.code = code;
        this.codeSet = true;
        return this;
    }
    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public OFGroupModFailedErrorMsg.Builder setData(byte[] data) {
        this.data = data;
        this.dataSet = true;
        return this;
    }
//
        @Override
        public OFGroupModFailedErrorMsg build() {
            long xid = this.xidSet ? this.xid : DEFAULT_XID;
            if(!this.codeSet)
                throw new IllegalStateException("Property code doesn't have default value -- must be set");
            if(code == null)
                throw new NullPointerException("Property code must not be null");
            byte[] data = this.dataSet ? this.data : DEFAULT_DATA;
            if(data == null)
                throw new NullPointerException("Property data must not be null");


            return new OFGroupModFailedErrorMsgVer13(
                    xid,
                    code,
                    data
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFGroupModFailedErrorMsg> {
        @Override
        public OFGroupModFailedErrorMsg readFrom(ChannelBuffer bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property version == 4
            byte version = bb.readByte();
            if(version != (byte) 0x4)
                throw new OFParseError("Wrong version: Expected=OFVersion.OF_13(4), got="+version);
            // fixed value property type == 1
            byte type = bb.readByte();
            if(type != (byte) 0x1)
                throw new OFParseError("Wrong type: Expected=OFType.ERROR(1), got="+type);
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
            // fixed value property errType == 6
            short errType = bb.readShort();
            if(errType != (short) 0x6)
                throw new OFParseError("Wrong errType: Expected=OFErrorType.GROUP_MOD_FAILED(6), got="+errType);
            OFGroupModFailedCode code = OFGroupModFailedCodeSerializerVer13.readFrom(bb);
            byte[] data = ChannelUtils.readBytes(bb, length - (bb.readerIndex() - start));

            OFGroupModFailedErrorMsgVer13 groupModFailedErrorMsgVer13 = new OFGroupModFailedErrorMsgVer13(
                    xid,
                      code,
                      data
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", groupModFailedErrorMsgVer13);
            return groupModFailedErrorMsgVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFGroupModFailedErrorMsgVer13Funnel FUNNEL = new OFGroupModFailedErrorMsgVer13Funnel();
    static class OFGroupModFailedErrorMsgVer13Funnel implements Funnel<OFGroupModFailedErrorMsgVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFGroupModFailedErrorMsgVer13 message, PrimitiveSink sink) {
            // fixed value property version = 4
            sink.putByte((byte) 0x4);
            // fixed value property type = 1
            sink.putByte((byte) 0x1);
            // FIXME: skip funnel of length
            sink.putLong(message.xid);
            // fixed value property errType = 6
            sink.putShort((short) 0x6);
            OFGroupModFailedCodeSerializerVer13.putTo(message.code, sink);
            sink.putBytes(message.data);
        }
    }


    public void writeTo(ChannelBuffer bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFGroupModFailedErrorMsgVer13> {
        @Override
        public void write(ChannelBuffer bb, OFGroupModFailedErrorMsgVer13 message) {
            int startIndex = bb.writerIndex();
            // fixed value property version = 4
            bb.writeByte((byte) 0x4);
            // fixed value property type = 1
            bb.writeByte((byte) 0x1);
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            bb.writeInt(U32.t(message.xid));
            // fixed value property errType = 6
            bb.writeShort((short) 0x6);
            OFGroupModFailedCodeSerializerVer13.writeTo(bb, message.code);
            bb.writeBytes(message.data);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFGroupModFailedErrorMsgVer13(");
        b.append("xid=").append(xid);
        b.append(", ");
        b.append("code=").append(code);
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
        OFGroupModFailedErrorMsgVer13 other = (OFGroupModFailedErrorMsgVer13) obj;

        if( xid != other.xid)
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
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
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + Arrays.hashCode(data);
        return result;
    }

}