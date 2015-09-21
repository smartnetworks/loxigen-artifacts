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
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFPortStatsPropEthernetVer14 implements OFPortStatsPropEthernet {
    private static final Logger logger = LoggerFactory.getLogger(OFPortStatsPropEthernetVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int LENGTH = 40;

        private final static U64 DEFAULT_RX_FRAME_ERR = U64.ZERO;
        private final static U64 DEFAULT_RX_OVER_ERR = U64.ZERO;
        private final static U64 DEFAULT_RX_CRC_ERR = U64.ZERO;
        private final static U64 DEFAULT_COLLISIONS = U64.ZERO;

    // OF message fields
    private final U64 rxFrameErr;
    private final U64 rxOverErr;
    private final U64 rxCrcErr;
    private final U64 collisions;
//
    // Immutable default instance
    final static OFPortStatsPropEthernetVer14 DEFAULT = new OFPortStatsPropEthernetVer14(
        DEFAULT_RX_FRAME_ERR, DEFAULT_RX_OVER_ERR, DEFAULT_RX_CRC_ERR, DEFAULT_COLLISIONS
    );

    // package private constructor - used by readers, builders, and factory
    OFPortStatsPropEthernetVer14(U64 rxFrameErr, U64 rxOverErr, U64 rxCrcErr, U64 collisions) {
        if(rxFrameErr == null) {
            throw new NullPointerException("OFPortStatsPropEthernetVer14: property rxFrameErr cannot be null");
        }
        if(rxOverErr == null) {
            throw new NullPointerException("OFPortStatsPropEthernetVer14: property rxOverErr cannot be null");
        }
        if(rxCrcErr == null) {
            throw new NullPointerException("OFPortStatsPropEthernetVer14: property rxCrcErr cannot be null");
        }
        if(collisions == null) {
            throw new NullPointerException("OFPortStatsPropEthernetVer14: property collisions cannot be null");
        }
        this.rxFrameErr = rxFrameErr;
        this.rxOverErr = rxOverErr;
        this.rxCrcErr = rxCrcErr;
        this.collisions = collisions;
    }

    // Accessors for OF message fields
    @Override
    public int getType() {
        return 0x0;
    }

    @Override
    public U64 getRxFrameErr() {
        return rxFrameErr;
    }

    @Override
    public U64 getRxOverErr() {
        return rxOverErr;
    }

    @Override
    public U64 getRxCrcErr() {
        return rxCrcErr;
    }

    @Override
    public U64 getCollisions() {
        return collisions;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFPortStatsPropEthernet.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFPortStatsPropEthernet.Builder {
        final OFPortStatsPropEthernetVer14 parentMessage;

        // OF message fields
        private boolean rxFrameErrSet;
        private U64 rxFrameErr;
        private boolean rxOverErrSet;
        private U64 rxOverErr;
        private boolean rxCrcErrSet;
        private U64 rxCrcErr;
        private boolean collisionsSet;
        private U64 collisions;

        BuilderWithParent(OFPortStatsPropEthernetVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public int getType() {
        return 0x0;
    }

    @Override
    public U64 getRxFrameErr() {
        return rxFrameErr;
    }

    @Override
    public OFPortStatsPropEthernet.Builder setRxFrameErr(U64 rxFrameErr) {
        this.rxFrameErr = rxFrameErr;
        this.rxFrameErrSet = true;
        return this;
    }
    @Override
    public U64 getRxOverErr() {
        return rxOverErr;
    }

    @Override
    public OFPortStatsPropEthernet.Builder setRxOverErr(U64 rxOverErr) {
        this.rxOverErr = rxOverErr;
        this.rxOverErrSet = true;
        return this;
    }
    @Override
    public U64 getRxCrcErr() {
        return rxCrcErr;
    }

    @Override
    public OFPortStatsPropEthernet.Builder setRxCrcErr(U64 rxCrcErr) {
        this.rxCrcErr = rxCrcErr;
        this.rxCrcErrSet = true;
        return this;
    }
    @Override
    public U64 getCollisions() {
        return collisions;
    }

    @Override
    public OFPortStatsPropEthernet.Builder setCollisions(U64 collisions) {
        this.collisions = collisions;
        this.collisionsSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFPortStatsPropEthernet build() {
                U64 rxFrameErr = this.rxFrameErrSet ? this.rxFrameErr : parentMessage.rxFrameErr;
                if(rxFrameErr == null)
                    throw new NullPointerException("Property rxFrameErr must not be null");
                U64 rxOverErr = this.rxOverErrSet ? this.rxOverErr : parentMessage.rxOverErr;
                if(rxOverErr == null)
                    throw new NullPointerException("Property rxOverErr must not be null");
                U64 rxCrcErr = this.rxCrcErrSet ? this.rxCrcErr : parentMessage.rxCrcErr;
                if(rxCrcErr == null)
                    throw new NullPointerException("Property rxCrcErr must not be null");
                U64 collisions = this.collisionsSet ? this.collisions : parentMessage.collisions;
                if(collisions == null)
                    throw new NullPointerException("Property collisions must not be null");

                //
                return new OFPortStatsPropEthernetVer14(
                    rxFrameErr,
                    rxOverErr,
                    rxCrcErr,
                    collisions
                );
        }

    }

    static class Builder implements OFPortStatsPropEthernet.Builder {
        // OF message fields
        private boolean rxFrameErrSet;
        private U64 rxFrameErr;
        private boolean rxOverErrSet;
        private U64 rxOverErr;
        private boolean rxCrcErrSet;
        private U64 rxCrcErr;
        private boolean collisionsSet;
        private U64 collisions;

    @Override
    public int getType() {
        return 0x0;
    }

    @Override
    public U64 getRxFrameErr() {
        return rxFrameErr;
    }

    @Override
    public OFPortStatsPropEthernet.Builder setRxFrameErr(U64 rxFrameErr) {
        this.rxFrameErr = rxFrameErr;
        this.rxFrameErrSet = true;
        return this;
    }
    @Override
    public U64 getRxOverErr() {
        return rxOverErr;
    }

    @Override
    public OFPortStatsPropEthernet.Builder setRxOverErr(U64 rxOverErr) {
        this.rxOverErr = rxOverErr;
        this.rxOverErrSet = true;
        return this;
    }
    @Override
    public U64 getRxCrcErr() {
        return rxCrcErr;
    }

    @Override
    public OFPortStatsPropEthernet.Builder setRxCrcErr(U64 rxCrcErr) {
        this.rxCrcErr = rxCrcErr;
        this.rxCrcErrSet = true;
        return this;
    }
    @Override
    public U64 getCollisions() {
        return collisions;
    }

    @Override
    public OFPortStatsPropEthernet.Builder setCollisions(U64 collisions) {
        this.collisions = collisions;
        this.collisionsSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFPortStatsPropEthernet build() {
            U64 rxFrameErr = this.rxFrameErrSet ? this.rxFrameErr : DEFAULT_RX_FRAME_ERR;
            if(rxFrameErr == null)
                throw new NullPointerException("Property rxFrameErr must not be null");
            U64 rxOverErr = this.rxOverErrSet ? this.rxOverErr : DEFAULT_RX_OVER_ERR;
            if(rxOverErr == null)
                throw new NullPointerException("Property rxOverErr must not be null");
            U64 rxCrcErr = this.rxCrcErrSet ? this.rxCrcErr : DEFAULT_RX_CRC_ERR;
            if(rxCrcErr == null)
                throw new NullPointerException("Property rxCrcErr must not be null");
            U64 collisions = this.collisionsSet ? this.collisions : DEFAULT_COLLISIONS;
            if(collisions == null)
                throw new NullPointerException("Property collisions must not be null");


            return new OFPortStatsPropEthernetVer14(
                    rxFrameErr,
                    rxOverErr,
                    rxCrcErr,
                    collisions
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFPortStatsPropEthernet> {
        @Override
        public OFPortStatsPropEthernet readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 0x0
            short type = bb.readShort();
            if(type != (short) 0x0)
                throw new OFParseError("Wrong type: Expected=0x0(0x0), got="+type);
            int length = U16.f(bb.readShort());
            if(length != 40)
                throw new OFParseError("Wrong length: Expected=40(40), got="+length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            // pad: 4 bytes
            bb.skipBytes(4);
            U64 rxFrameErr = U64.ofRaw(bb.readLong());
            U64 rxOverErr = U64.ofRaw(bb.readLong());
            U64 rxCrcErr = U64.ofRaw(bb.readLong());
            U64 collisions = U64.ofRaw(bb.readLong());

            OFPortStatsPropEthernetVer14 portStatsPropEthernetVer14 = new OFPortStatsPropEthernetVer14(
                    rxFrameErr,
                      rxOverErr,
                      rxCrcErr,
                      collisions
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", portStatsPropEthernetVer14);
            return portStatsPropEthernetVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFPortStatsPropEthernetVer14Funnel FUNNEL = new OFPortStatsPropEthernetVer14Funnel();
    static class OFPortStatsPropEthernetVer14Funnel implements Funnel<OFPortStatsPropEthernetVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFPortStatsPropEthernetVer14 message, PrimitiveSink sink) {
            // fixed value property type = 0x0
            sink.putShort((short) 0x0);
            // fixed value property length = 40
            sink.putShort((short) 0x28);
            // skip pad (4 bytes)
            message.rxFrameErr.putTo(sink);
            message.rxOverErr.putTo(sink);
            message.rxCrcErr.putTo(sink);
            message.collisions.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFPortStatsPropEthernetVer14> {
        @Override
        public void write(ByteBuf bb, OFPortStatsPropEthernetVer14 message) {
            // fixed value property type = 0x0
            bb.writeShort((short) 0x0);
            // fixed value property length = 40
            bb.writeShort((short) 0x28);
            // pad: 4 bytes
            bb.writeZero(4);
            bb.writeLong(message.rxFrameErr.getValue());
            bb.writeLong(message.rxOverErr.getValue());
            bb.writeLong(message.rxCrcErr.getValue());
            bb.writeLong(message.collisions.getValue());


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFPortStatsPropEthernetVer14(");
        b.append("rxFrameErr=").append(rxFrameErr);
        b.append(", ");
        b.append("rxOverErr=").append(rxOverErr);
        b.append(", ");
        b.append("rxCrcErr=").append(rxCrcErr);
        b.append(", ");
        b.append("collisions=").append(collisions);
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
        OFPortStatsPropEthernetVer14 other = (OFPortStatsPropEthernetVer14) obj;

        if (rxFrameErr == null) {
            if (other.rxFrameErr != null)
                return false;
        } else if (!rxFrameErr.equals(other.rxFrameErr))
            return false;
        if (rxOverErr == null) {
            if (other.rxOverErr != null)
                return false;
        } else if (!rxOverErr.equals(other.rxOverErr))
            return false;
        if (rxCrcErr == null) {
            if (other.rxCrcErr != null)
                return false;
        } else if (!rxCrcErr.equals(other.rxCrcErr))
            return false;
        if (collisions == null) {
            if (other.collisions != null)
                return false;
        } else if (!collisions.equals(other.collisions))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((rxFrameErr == null) ? 0 : rxFrameErr.hashCode());
        result = prime * result + ((rxOverErr == null) ? 0 : rxOverErr.hashCode());
        result = prime * result + ((rxCrcErr == null) ? 0 : rxCrcErr.hashCode());
        result = prime * result + ((collisions == null) ? 0 : collisions.hashCode());
        return result;
    }

}
