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

class OFOxmBsnVrfMaskedVer14 implements OFOxmBsnVrfMasked {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmBsnVrfMaskedVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int LENGTH = 12;

        private final static VRF DEFAULT_VALUE = VRF.ZERO;
        private final static VRF DEFAULT_VALUE_MASK = VRF.ZERO;

    // OF message fields
    private final VRF value;
    private final VRF mask;
//
    // Immutable default instance
    final static OFOxmBsnVrfMaskedVer14 DEFAULT = new OFOxmBsnVrfMaskedVer14(
        DEFAULT_VALUE, DEFAULT_VALUE_MASK
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmBsnVrfMaskedVer14(VRF value, VRF mask) {
        if(value == null) {
            throw new NullPointerException("OFOxmBsnVrfMaskedVer14: property value cannot be null");
        }
        if(mask == null) {
            throw new NullPointerException("OFOxmBsnVrfMaskedVer14: property mask cannot be null");
        }
        this.value = value;
        this.mask = mask;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x30508L;
    }

    @Override
    public VRF getValue() {
        return value;
    }

    @Override
    public VRF getMask() {
        return mask;
    }

    @Override
    public MatchField<VRF> getMatchField() {
        return MatchField.BSN_VRF;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    public OFOxm<VRF> getCanonical() {
        if (VRF.NO_MASK.equals(mask)) {
            return new OFOxmBsnVrfVer14(value);
        } else if(VRF.FULL_MASK.equals(mask)) {
            return null;
        } else {
            return this;
        }
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFOxmBsnVrfMasked.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmBsnVrfMasked.Builder {
        final OFOxmBsnVrfMaskedVer14 parentMessage;

        // OF message fields
        private boolean valueSet;
        private VRF value;
        private boolean maskSet;
        private VRF mask;

        BuilderWithParent(OFOxmBsnVrfMaskedVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x30508L;
    }

    @Override
    public VRF getValue() {
        return value;
    }

    @Override
    public OFOxmBsnVrfMasked.Builder setValue(VRF value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public VRF getMask() {
        return mask;
    }

    @Override
    public OFOxmBsnVrfMasked.Builder setMask(VRF mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<VRF> getMatchField() {
        return MatchField.BSN_VRF;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<VRF> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.4");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFOxmBsnVrfMasked build() {
                VRF value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");
                VRF mask = this.maskSet ? this.mask : parentMessage.mask;
                if(mask == null)
                    throw new NullPointerException("Property mask must not be null");

                //
                return new OFOxmBsnVrfMaskedVer14(
                    value,
                    mask
                );
        }

    }

    static class Builder implements OFOxmBsnVrfMasked.Builder {
        // OF message fields
        private boolean valueSet;
        private VRF value;
        private boolean maskSet;
        private VRF mask;

    @Override
    public long getTypeLen() {
        return 0x30508L;
    }

    @Override
    public VRF getValue() {
        return value;
    }

    @Override
    public OFOxmBsnVrfMasked.Builder setValue(VRF value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public VRF getMask() {
        return mask;
    }

    @Override
    public OFOxmBsnVrfMasked.Builder setMask(VRF mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<VRF> getMatchField() {
        return MatchField.BSN_VRF;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<VRF> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.4");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFOxmBsnVrfMasked build() {
            VRF value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");
            VRF mask = this.maskSet ? this.mask : DEFAULT_VALUE_MASK;
            if(mask == null)
                throw new NullPointerException("Property mask must not be null");


            return new OFOxmBsnVrfMaskedVer14(
                    value,
                    mask
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmBsnVrfMasked> {
        @Override
        public OFOxmBsnVrfMasked readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x30508L
            int typeLen = bb.readInt();
            if(typeLen != 0x30508)
                throw new OFParseError("Wrong typeLen: Expected=0x30508L(0x30508L), got="+typeLen);
            VRF value = VRF.read4Bytes(bb);
            VRF mask = VRF.read4Bytes(bb);

            OFOxmBsnVrfMaskedVer14 oxmBsnVrfMaskedVer14 = new OFOxmBsnVrfMaskedVer14(
                    value,
                      mask
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmBsnVrfMaskedVer14);
            return oxmBsnVrfMaskedVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmBsnVrfMaskedVer14Funnel FUNNEL = new OFOxmBsnVrfMaskedVer14Funnel();
    static class OFOxmBsnVrfMaskedVer14Funnel implements Funnel<OFOxmBsnVrfMaskedVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmBsnVrfMaskedVer14 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x30508L
            sink.putInt(0x30508);
            message.value.putTo(sink);
            message.mask.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmBsnVrfMaskedVer14> {
        @Override
        public void write(ByteBuf bb, OFOxmBsnVrfMaskedVer14 message) {
            // fixed value property typeLen = 0x30508L
            bb.writeInt(0x30508);
            message.value.write4Bytes(bb);
            message.mask.write4Bytes(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmBsnVrfMaskedVer14(");
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
        OFOxmBsnVrfMaskedVer14 other = (OFOxmBsnVrfMaskedVer14) obj;

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
