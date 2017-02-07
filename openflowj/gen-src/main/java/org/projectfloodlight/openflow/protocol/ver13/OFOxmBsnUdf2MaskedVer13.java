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
import java.util.Set;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFOxmBsnUdf2MaskedVer13 implements OFOxmBsnUdf2Masked {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmBsnUdf2MaskedVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int LENGTH = 12;

        private final static UDF DEFAULT_VALUE = UDF.ZERO;
        private final static UDF DEFAULT_VALUE_MASK = UDF.ZERO;

    // OF message fields
    private final UDF value;
    private final UDF mask;
//
    // Immutable default instance
    final static OFOxmBsnUdf2MaskedVer13 DEFAULT = new OFOxmBsnUdf2MaskedVer13(
        DEFAULT_VALUE, DEFAULT_VALUE_MASK
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmBsnUdf2MaskedVer13(UDF value, UDF mask) {
        if(value == null) {
            throw new NullPointerException("OFOxmBsnUdf2MaskedVer13: property value cannot be null");
        }
        if(mask == null) {
            throw new NullPointerException("OFOxmBsnUdf2MaskedVer13: property mask cannot be null");
        }
        this.value = value;
        this.mask = mask;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x31508L;
    }

    @Override
    public UDF getValue() {
        return value;
    }

    @Override
    public UDF getMask() {
        return mask;
    }

    @Override
    public MatchField<UDF> getMatchField() {
        return MatchField.BSN_UDF2;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    public OFOxm<UDF> getCanonical() {
        if (UDF.NO_MASK.equals(mask)) {
            return new OFOxmBsnUdf2Ver13(value);
        } else if(UDF.FULL_MASK.equals(mask)) {
            return null;
        } else {
            return this;
        }
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFOxmBsnUdf2Masked.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmBsnUdf2Masked.Builder {
        final OFOxmBsnUdf2MaskedVer13 parentMessage;

        // OF message fields
        private boolean valueSet;
        private UDF value;
        private boolean maskSet;
        private UDF mask;

        BuilderWithParent(OFOxmBsnUdf2MaskedVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x31508L;
    }

    @Override
    public UDF getValue() {
        return value;
    }

    @Override
    public OFOxmBsnUdf2Masked.Builder setValue(UDF value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public UDF getMask() {
        return mask;
    }

    @Override
    public OFOxmBsnUdf2Masked.Builder setMask(UDF mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<UDF> getMatchField() {
        return MatchField.BSN_UDF2;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<UDF> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFOxmBsnUdf2Masked build() {
                UDF value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");
                UDF mask = this.maskSet ? this.mask : parentMessage.mask;
                if(mask == null)
                    throw new NullPointerException("Property mask must not be null");

                //
                return new OFOxmBsnUdf2MaskedVer13(
                    value,
                    mask
                );
        }

    }

    static class Builder implements OFOxmBsnUdf2Masked.Builder {
        // OF message fields
        private boolean valueSet;
        private UDF value;
        private boolean maskSet;
        private UDF mask;

    @Override
    public long getTypeLen() {
        return 0x31508L;
    }

    @Override
    public UDF getValue() {
        return value;
    }

    @Override
    public OFOxmBsnUdf2Masked.Builder setValue(UDF value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public UDF getMask() {
        return mask;
    }

    @Override
    public OFOxmBsnUdf2Masked.Builder setMask(UDF mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<UDF> getMatchField() {
        return MatchField.BSN_UDF2;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<UDF> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

//
        @Override
        public OFOxmBsnUdf2Masked build() {
            UDF value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");
            UDF mask = this.maskSet ? this.mask : DEFAULT_VALUE_MASK;
            if(mask == null)
                throw new NullPointerException("Property mask must not be null");


            return new OFOxmBsnUdf2MaskedVer13(
                    value,
                    mask
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmBsnUdf2Masked> {
        @Override
        public OFOxmBsnUdf2Masked readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x31508L
            int typeLen = bb.readInt();
            if(typeLen != 0x31508)
                throw new OFParseError("Wrong typeLen: Expected=0x31508L(0x31508L), got="+typeLen);
            UDF value = UDF.read4Bytes(bb);
            UDF mask = UDF.read4Bytes(bb);

            OFOxmBsnUdf2MaskedVer13 oxmBsnUdf2MaskedVer13 = new OFOxmBsnUdf2MaskedVer13(
                    value,
                      mask
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmBsnUdf2MaskedVer13);
            return oxmBsnUdf2MaskedVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmBsnUdf2MaskedVer13Funnel FUNNEL = new OFOxmBsnUdf2MaskedVer13Funnel();
    static class OFOxmBsnUdf2MaskedVer13Funnel implements Funnel<OFOxmBsnUdf2MaskedVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmBsnUdf2MaskedVer13 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x31508L
            sink.putInt(0x31508);
            message.value.putTo(sink);
            message.mask.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmBsnUdf2MaskedVer13> {
        @Override
        public void write(ByteBuf bb, OFOxmBsnUdf2MaskedVer13 message) {
            // fixed value property typeLen = 0x31508L
            bb.writeInt(0x31508);
            message.value.write4Bytes(bb);
            message.mask.write4Bytes(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmBsnUdf2MaskedVer13(");
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
        OFOxmBsnUdf2MaskedVer13 other = (OFOxmBsnUdf2MaskedVer13) obj;

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
