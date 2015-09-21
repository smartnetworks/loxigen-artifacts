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

class OFOxmVlanPcpMaskedVer12 implements OFOxmVlanPcpMasked {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmVlanPcpMaskedVer12.class);
    // version: 1.2
    final static byte WIRE_VERSION = 3;
    final static int LENGTH = 6;

        private final static VlanPcp DEFAULT_VALUE = VlanPcp.NONE;
        private final static VlanPcp DEFAULT_VALUE_MASK = VlanPcp.NONE;

    // OF message fields
    private final VlanPcp value;
    private final VlanPcp mask;
//
    // Immutable default instance
    final static OFOxmVlanPcpMaskedVer12 DEFAULT = new OFOxmVlanPcpMaskedVer12(
        DEFAULT_VALUE, DEFAULT_VALUE_MASK
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmVlanPcpMaskedVer12(VlanPcp value, VlanPcp mask) {
        if(value == null) {
            throw new NullPointerException("OFOxmVlanPcpMaskedVer12: property value cannot be null");
        }
        if(mask == null) {
            throw new NullPointerException("OFOxmVlanPcpMaskedVer12: property mask cannot be null");
        }
        this.value = value;
        this.mask = mask;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x80000f02L;
    }

    @Override
    public VlanPcp getValue() {
        return value;
    }

    @Override
    public VlanPcp getMask() {
        return mask;
    }

    @Override
    public MatchField<VlanPcp> getMatchField() {
        return MatchField.VLAN_PCP;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    public OFOxm<VlanPcp> getCanonical() {
        if (VlanPcp.NO_MASK.equals(mask)) {
            return new OFOxmVlanPcpVer12(value);
        } else if(VlanPcp.FULL_MASK.equals(mask)) {
            return null;
        } else {
            return this;
        }
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



    public OFOxmVlanPcpMasked.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmVlanPcpMasked.Builder {
        final OFOxmVlanPcpMaskedVer12 parentMessage;

        // OF message fields
        private boolean valueSet;
        private VlanPcp value;
        private boolean maskSet;
        private VlanPcp mask;

        BuilderWithParent(OFOxmVlanPcpMaskedVer12 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x80000f02L;
    }

    @Override
    public VlanPcp getValue() {
        return value;
    }

    @Override
    public OFOxmVlanPcpMasked.Builder setValue(VlanPcp value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public VlanPcp getMask() {
        return mask;
    }

    @Override
    public OFOxmVlanPcpMasked.Builder setMask(VlanPcp mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<VlanPcp> getMatchField() {
        return MatchField.VLAN_PCP;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<VlanPcp> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



        @Override
        public OFOxmVlanPcpMasked build() {
                VlanPcp value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");
                VlanPcp mask = this.maskSet ? this.mask : parentMessage.mask;
                if(mask == null)
                    throw new NullPointerException("Property mask must not be null");

                //
                return new OFOxmVlanPcpMaskedVer12(
                    value,
                    mask
                );
        }

    }

    static class Builder implements OFOxmVlanPcpMasked.Builder {
        // OF message fields
        private boolean valueSet;
        private VlanPcp value;
        private boolean maskSet;
        private VlanPcp mask;

    @Override
    public long getTypeLen() {
        return 0x80000f02L;
    }

    @Override
    public VlanPcp getValue() {
        return value;
    }

    @Override
    public OFOxmVlanPcpMasked.Builder setValue(VlanPcp value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public VlanPcp getMask() {
        return mask;
    }

    @Override
    public OFOxmVlanPcpMasked.Builder setMask(VlanPcp mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<VlanPcp> getMatchField() {
        return MatchField.VLAN_PCP;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<VlanPcp> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }

//
        @Override
        public OFOxmVlanPcpMasked build() {
            VlanPcp value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");
            VlanPcp mask = this.maskSet ? this.mask : DEFAULT_VALUE_MASK;
            if(mask == null)
                throw new NullPointerException("Property mask must not be null");


            return new OFOxmVlanPcpMaskedVer12(
                    value,
                    mask
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmVlanPcpMasked> {
        @Override
        public OFOxmVlanPcpMasked readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x80000f02L
            int typeLen = bb.readInt();
            if(typeLen != (int) 0x80000f02)
                throw new OFParseError("Wrong typeLen: Expected=0x80000f02L(0x80000f02L), got="+typeLen);
            VlanPcp value = VlanPcp.readByte(bb);
            VlanPcp mask = VlanPcp.readByte(bb);

            OFOxmVlanPcpMaskedVer12 oxmVlanPcpMaskedVer12 = new OFOxmVlanPcpMaskedVer12(
                    value,
                      mask
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmVlanPcpMaskedVer12);
            return oxmVlanPcpMaskedVer12;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmVlanPcpMaskedVer12Funnel FUNNEL = new OFOxmVlanPcpMaskedVer12Funnel();
    static class OFOxmVlanPcpMaskedVer12Funnel implements Funnel<OFOxmVlanPcpMaskedVer12> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmVlanPcpMaskedVer12 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x80000f02L
            sink.putInt((int) 0x80000f02);
            message.value.putTo(sink);
            message.mask.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmVlanPcpMaskedVer12> {
        @Override
        public void write(ByteBuf bb, OFOxmVlanPcpMaskedVer12 message) {
            // fixed value property typeLen = 0x80000f02L
            bb.writeInt((int) 0x80000f02);
            message.value.writeByte(bb);
            message.mask.writeByte(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmVlanPcpMaskedVer12(");
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
        OFOxmVlanPcpMaskedVer12 other = (OFOxmVlanPcpMaskedVer12) obj;

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
