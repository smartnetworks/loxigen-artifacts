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

class OFOxmIpEcnMaskedVer14 implements OFOxmIpEcnMasked {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmIpEcnMaskedVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int LENGTH = 6;

        private final static IpEcn DEFAULT_VALUE = IpEcn.NONE;
        private final static IpEcn DEFAULT_VALUE_MASK = IpEcn.NONE;

    // OF message fields
    private final IpEcn value;
    private final IpEcn mask;
//
    // Immutable default instance
    final static OFOxmIpEcnMaskedVer14 DEFAULT = new OFOxmIpEcnMaskedVer14(
        DEFAULT_VALUE, DEFAULT_VALUE_MASK
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmIpEcnMaskedVer14(IpEcn value, IpEcn mask) {
        if(value == null) {
            throw new NullPointerException("OFOxmIpEcnMaskedVer14: property value cannot be null");
        }
        if(mask == null) {
            throw new NullPointerException("OFOxmIpEcnMaskedVer14: property mask cannot be null");
        }
        this.value = value;
        this.mask = mask;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x80001302L;
    }

    @Override
    public IpEcn getValue() {
        return value;
    }

    @Override
    public IpEcn getMask() {
        return mask;
    }

    @Override
    public MatchField<IpEcn> getMatchField() {
        return MatchField.IP_ECN;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    public OFOxm<IpEcn> getCanonical() {
        if (IpEcn.NO_MASK.equals(mask)) {
            return new OFOxmIpEcnVer14(value);
        } else if(IpEcn.FULL_MASK.equals(mask)) {
            return null;
        } else {
            return this;
        }
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFOxmIpEcnMasked.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmIpEcnMasked.Builder {
        final OFOxmIpEcnMaskedVer14 parentMessage;

        // OF message fields
        private boolean valueSet;
        private IpEcn value;
        private boolean maskSet;
        private IpEcn mask;

        BuilderWithParent(OFOxmIpEcnMaskedVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x80001302L;
    }

    @Override
    public IpEcn getValue() {
        return value;
    }

    @Override
    public OFOxmIpEcnMasked.Builder setValue(IpEcn value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public IpEcn getMask() {
        return mask;
    }

    @Override
    public OFOxmIpEcnMasked.Builder setMask(IpEcn mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<IpEcn> getMatchField() {
        return MatchField.IP_ECN;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<IpEcn> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.4");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFOxmIpEcnMasked build() {
                IpEcn value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");
                IpEcn mask = this.maskSet ? this.mask : parentMessage.mask;
                if(mask == null)
                    throw new NullPointerException("Property mask must not be null");

                //
                return new OFOxmIpEcnMaskedVer14(
                    value,
                    mask
                );
        }

    }

    static class Builder implements OFOxmIpEcnMasked.Builder {
        // OF message fields
        private boolean valueSet;
        private IpEcn value;
        private boolean maskSet;
        private IpEcn mask;

    @Override
    public long getTypeLen() {
        return 0x80001302L;
    }

    @Override
    public IpEcn getValue() {
        return value;
    }

    @Override
    public OFOxmIpEcnMasked.Builder setValue(IpEcn value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public IpEcn getMask() {
        return mask;
    }

    @Override
    public OFOxmIpEcnMasked.Builder setMask(IpEcn mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<IpEcn> getMatchField() {
        return MatchField.IP_ECN;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<IpEcn> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.4");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFOxmIpEcnMasked build() {
            IpEcn value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");
            IpEcn mask = this.maskSet ? this.mask : DEFAULT_VALUE_MASK;
            if(mask == null)
                throw new NullPointerException("Property mask must not be null");


            return new OFOxmIpEcnMaskedVer14(
                    value,
                    mask
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmIpEcnMasked> {
        @Override
        public OFOxmIpEcnMasked readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x80001302L
            int typeLen = bb.readInt();
            if(typeLen != (int) 0x80001302)
                throw new OFParseError("Wrong typeLen: Expected=0x80001302L(0x80001302L), got="+typeLen);
            IpEcn value = IpEcn.readByte(bb);
            IpEcn mask = IpEcn.readByte(bb);

            OFOxmIpEcnMaskedVer14 oxmIpEcnMaskedVer14 = new OFOxmIpEcnMaskedVer14(
                    value,
                      mask
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmIpEcnMaskedVer14);
            return oxmIpEcnMaskedVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmIpEcnMaskedVer14Funnel FUNNEL = new OFOxmIpEcnMaskedVer14Funnel();
    static class OFOxmIpEcnMaskedVer14Funnel implements Funnel<OFOxmIpEcnMaskedVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmIpEcnMaskedVer14 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x80001302L
            sink.putInt((int) 0x80001302);
            message.value.putTo(sink);
            message.mask.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmIpEcnMaskedVer14> {
        @Override
        public void write(ByteBuf bb, OFOxmIpEcnMaskedVer14 message) {
            // fixed value property typeLen = 0x80001302L
            bb.writeInt((int) 0x80001302);
            message.value.writeByte(bb);
            message.mask.writeByte(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmIpEcnMaskedVer14(");
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
        OFOxmIpEcnMaskedVer14 other = (OFOxmIpEcnMaskedVer14) obj;

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
