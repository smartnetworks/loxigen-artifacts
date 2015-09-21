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
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFActionBsnSetTunnelDstVer14 implements OFActionBsnSetTunnelDst {
    private static final Logger logger = LoggerFactory.getLogger(OFActionBsnSetTunnelDstVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int LENGTH = 16;

        private final static long DEFAULT_DST = 0x0L;

    // OF message fields
    private final long dst;
//
    // Immutable default instance
    final static OFActionBsnSetTunnelDstVer14 DEFAULT = new OFActionBsnSetTunnelDstVer14(
        DEFAULT_DST
    );

    // package private constructor - used by readers, builders, and factory
    OFActionBsnSetTunnelDstVer14(long dst) {
        this.dst = dst;
    }

    // Accessors for OF message fields
    @Override
    public OFActionType getType() {
        return OFActionType.EXPERIMENTER;
    }

    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getSubtype() {
        return 0x2L;
    }

    @Override
    public long getDst() {
        return dst;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFActionBsnSetTunnelDst.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFActionBsnSetTunnelDst.Builder {
        final OFActionBsnSetTunnelDstVer14 parentMessage;

        // OF message fields
        private boolean dstSet;
        private long dst;

        BuilderWithParent(OFActionBsnSetTunnelDstVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public OFActionType getType() {
        return OFActionType.EXPERIMENTER;
    }

    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getSubtype() {
        return 0x2L;
    }

    @Override
    public long getDst() {
        return dst;
    }

    @Override
    public OFActionBsnSetTunnelDst.Builder setDst(long dst) {
        this.dst = dst;
        this.dstSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFActionBsnSetTunnelDst build() {
                long dst = this.dstSet ? this.dst : parentMessage.dst;

                //
                return new OFActionBsnSetTunnelDstVer14(
                    dst
                );
        }

    }

    static class Builder implements OFActionBsnSetTunnelDst.Builder {
        // OF message fields
        private boolean dstSet;
        private long dst;

    @Override
    public OFActionType getType() {
        return OFActionType.EXPERIMENTER;
    }

    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getSubtype() {
        return 0x2L;
    }

    @Override
    public long getDst() {
        return dst;
    }

    @Override
    public OFActionBsnSetTunnelDst.Builder setDst(long dst) {
        this.dst = dst;
        this.dstSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFActionBsnSetTunnelDst build() {
            long dst = this.dstSet ? this.dst : DEFAULT_DST;


            return new OFActionBsnSetTunnelDstVer14(
                    dst
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFActionBsnSetTunnelDst> {
        @Override
        public OFActionBsnSetTunnelDst readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 65535
            short type = bb.readShort();
            if(type != (short) 0xffff)
                throw new OFParseError("Wrong type: Expected=OFActionType.EXPERIMENTER(65535), got="+type);
            int length = U16.f(bb.readShort());
            if(length != 16)
                throw new OFParseError("Wrong length: Expected=16(16), got="+length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            // fixed value property experimenter == 0x5c16c7L
            int experimenter = bb.readInt();
            if(experimenter != 0x5c16c7)
                throw new OFParseError("Wrong experimenter: Expected=0x5c16c7L(0x5c16c7L), got="+experimenter);
            // fixed value property subtype == 0x2L
            int subtype = bb.readInt();
            if(subtype != 0x2)
                throw new OFParseError("Wrong subtype: Expected=0x2L(0x2L), got="+subtype);
            long dst = U32.f(bb.readInt());

            OFActionBsnSetTunnelDstVer14 actionBsnSetTunnelDstVer14 = new OFActionBsnSetTunnelDstVer14(
                    dst
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", actionBsnSetTunnelDstVer14);
            return actionBsnSetTunnelDstVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFActionBsnSetTunnelDstVer14Funnel FUNNEL = new OFActionBsnSetTunnelDstVer14Funnel();
    static class OFActionBsnSetTunnelDstVer14Funnel implements Funnel<OFActionBsnSetTunnelDstVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFActionBsnSetTunnelDstVer14 message, PrimitiveSink sink) {
            // fixed value property type = 65535
            sink.putShort((short) 0xffff);
            // fixed value property length = 16
            sink.putShort((short) 0x10);
            // fixed value property experimenter = 0x5c16c7L
            sink.putInt(0x5c16c7);
            // fixed value property subtype = 0x2L
            sink.putInt(0x2);
            sink.putLong(message.dst);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFActionBsnSetTunnelDstVer14> {
        @Override
        public void write(ByteBuf bb, OFActionBsnSetTunnelDstVer14 message) {
            // fixed value property type = 65535
            bb.writeShort((short) 0xffff);
            // fixed value property length = 16
            bb.writeShort((short) 0x10);
            // fixed value property experimenter = 0x5c16c7L
            bb.writeInt(0x5c16c7);
            // fixed value property subtype = 0x2L
            bb.writeInt(0x2);
            bb.writeInt(U32.t(message.dst));


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFActionBsnSetTunnelDstVer14(");
        b.append("dst=").append(dst);
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
        OFActionBsnSetTunnelDstVer14 other = (OFActionBsnSetTunnelDstVer14) obj;

        if( dst != other.dst)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime *  (int) (dst ^ (dst >>> 32));
        return result;
    }

}
