// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver12;

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

class OFOxmTcpDstMaskedVer12 implements OFOxmTcpDstMasked {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmTcpDstMaskedVer12.class);
    // version: 1.2
    final static byte WIRE_VERSION = 3;
    final static int LENGTH = 8;

        private final static TransportPort DEFAULT_VALUE = TransportPort.NONE;
        private final static TransportPort DEFAULT_VALUE_MASK = TransportPort.NONE;

    // OF message fields
    private final TransportPort value;
    private final TransportPort mask;
//
    // Immutable default instance
    final static OFOxmTcpDstMaskedVer12 DEFAULT = new OFOxmTcpDstMaskedVer12(
        DEFAULT_VALUE, DEFAULT_VALUE_MASK
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmTcpDstMaskedVer12(TransportPort value, TransportPort mask) {
        if(value == null) {
            throw new NullPointerException("OFOxmTcpDstMaskedVer12: property value cannot be null");
        }
        if(mask == null) {
            throw new NullPointerException("OFOxmTcpDstMaskedVer12: property mask cannot be null");
        }
        this.value = value;
        this.mask = mask;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x80001d04L;
    }

    @Override
    public TransportPort getValue() {
        return value;
    }

    @Override
    public TransportPort getMask() {
        return mask;
    }

    @Override
    public MatchField<TransportPort> getMatchField() {
        return MatchField.TCP_DST;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    public OFOxm<TransportPort> getCanonical() {
        if (TransportPort.NO_MASK.equals(mask)) {
            return new OFOxmTcpDstVer12(value);
        } else if(TransportPort.FULL_MASK.equals(mask)) {
            return null;
        } else {
            return this;
        }
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



    public OFOxmTcpDstMasked.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmTcpDstMasked.Builder {
        final OFOxmTcpDstMaskedVer12 parentMessage;

        // OF message fields
        private boolean valueSet;
        private TransportPort value;
        private boolean maskSet;
        private TransportPort mask;

        BuilderWithParent(OFOxmTcpDstMaskedVer12 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x80001d04L;
    }

    @Override
    public TransportPort getValue() {
        return value;
    }

    @Override
    public OFOxmTcpDstMasked.Builder setValue(TransportPort value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public TransportPort getMask() {
        return mask;
    }

    @Override
    public OFOxmTcpDstMasked.Builder setMask(TransportPort mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<TransportPort> getMatchField() {
        return MatchField.TCP_DST;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<TransportPort> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



        @Override
        public OFOxmTcpDstMasked build() {
                TransportPort value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");
                TransportPort mask = this.maskSet ? this.mask : parentMessage.mask;
                if(mask == null)
                    throw new NullPointerException("Property mask must not be null");

                //
                return new OFOxmTcpDstMaskedVer12(
                    value,
                    mask
                );
        }

    }

    static class Builder implements OFOxmTcpDstMasked.Builder {
        // OF message fields
        private boolean valueSet;
        private TransportPort value;
        private boolean maskSet;
        private TransportPort mask;

    @Override
    public long getTypeLen() {
        return 0x80001d04L;
    }

    @Override
    public TransportPort getValue() {
        return value;
    }

    @Override
    public OFOxmTcpDstMasked.Builder setValue(TransportPort value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public TransportPort getMask() {
        return mask;
    }

    @Override
    public OFOxmTcpDstMasked.Builder setMask(TransportPort mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<TransportPort> getMatchField() {
        return MatchField.TCP_DST;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<TransportPort> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }

//
        @Override
        public OFOxmTcpDstMasked build() {
            TransportPort value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");
            TransportPort mask = this.maskSet ? this.mask : DEFAULT_VALUE_MASK;
            if(mask == null)
                throw new NullPointerException("Property mask must not be null");


            return new OFOxmTcpDstMaskedVer12(
                    value,
                    mask
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmTcpDstMasked> {
        @Override
        public OFOxmTcpDstMasked readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x80001d04L
            int typeLen = bb.readInt();
            if(typeLen != (int) 0x80001d04)
                throw new OFParseError("Wrong typeLen: Expected=0x80001d04L(0x80001d04L), got="+typeLen);
            TransportPort value = TransportPort.read2Bytes(bb);
            TransportPort mask = TransportPort.read2Bytes(bb);

            OFOxmTcpDstMaskedVer12 oxmTcpDstMaskedVer12 = new OFOxmTcpDstMaskedVer12(
                    value,
                      mask
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmTcpDstMaskedVer12);
            return oxmTcpDstMaskedVer12;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmTcpDstMaskedVer12Funnel FUNNEL = new OFOxmTcpDstMaskedVer12Funnel();
    static class OFOxmTcpDstMaskedVer12Funnel implements Funnel<OFOxmTcpDstMaskedVer12> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmTcpDstMaskedVer12 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x80001d04L
            sink.putInt((int) 0x80001d04);
            message.value.putTo(sink);
            message.mask.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmTcpDstMaskedVer12> {
        @Override
        public void write(ByteBuf bb, OFOxmTcpDstMaskedVer12 message) {
            // fixed value property typeLen = 0x80001d04L
            bb.writeInt((int) 0x80001d04);
            message.value.write2Bytes(bb);
            message.mask.write2Bytes(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmTcpDstMaskedVer12(");
        b.append("value=").append(value);
        b.append(", ");
        b.append("mask=").append(mask);
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
        OFOxmTcpDstMaskedVer12 other = (OFOxmTcpDstMaskedVer12) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (mask == null) {
            if (other.mask != null)
                return false;
        } else if (!mask.equals(other.mask))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((mask == null) ? 0 : mask.hashCode());
        return result;
    }

}
