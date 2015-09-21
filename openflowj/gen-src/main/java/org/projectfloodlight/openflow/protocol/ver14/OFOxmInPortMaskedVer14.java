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

class OFOxmInPortMaskedVer14 implements OFOxmInPortMasked {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmInPortMaskedVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int LENGTH = 12;

        private final static OFPort DEFAULT_VALUE = OFPort.ANY;
        private final static OFPort DEFAULT_VALUE_MASK = OFPort.ANY;

    // OF message fields
    private final OFPort value;
    private final OFPort mask;
//
    // Immutable default instance
    final static OFOxmInPortMaskedVer14 DEFAULT = new OFOxmInPortMaskedVer14(
        DEFAULT_VALUE, DEFAULT_VALUE_MASK
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmInPortMaskedVer14(OFPort value, OFPort mask) {
        if(value == null) {
            throw new NullPointerException("OFOxmInPortMaskedVer14: property value cannot be null");
        }
        if(mask == null) {
            throw new NullPointerException("OFOxmInPortMaskedVer14: property mask cannot be null");
        }
        this.value = value;
        this.mask = mask;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x80000108L;
    }

    @Override
    public OFPort getValue() {
        return value;
    }

    @Override
    public OFPort getMask() {
        return mask;
    }

    @Override
    public MatchField<OFPort> getMatchField() {
        return MatchField.IN_PORT;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    public OFOxm<OFPort> getCanonical() {
        if (OFPort.NO_MASK.equals(mask)) {
            return new OFOxmInPortVer14(value);
        } else if(OFPort.FULL_MASK.equals(mask)) {
            return null;
        } else {
            return this;
        }
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFOxmInPortMasked.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmInPortMasked.Builder {
        final OFOxmInPortMaskedVer14 parentMessage;

        // OF message fields
        private boolean valueSet;
        private OFPort value;
        private boolean maskSet;
        private OFPort mask;

        BuilderWithParent(OFOxmInPortMaskedVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x80000108L;
    }

    @Override
    public OFPort getValue() {
        return value;
    }

    @Override
    public OFOxmInPortMasked.Builder setValue(OFPort value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public OFPort getMask() {
        return mask;
    }

    @Override
    public OFOxmInPortMasked.Builder setMask(OFPort mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<OFPort> getMatchField() {
        return MatchField.IN_PORT;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<OFPort> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.4");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFOxmInPortMasked build() {
                OFPort value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");
                OFPort mask = this.maskSet ? this.mask : parentMessage.mask;
                if(mask == null)
                    throw new NullPointerException("Property mask must not be null");

                //
                return new OFOxmInPortMaskedVer14(
                    value,
                    mask
                );
        }

    }

    static class Builder implements OFOxmInPortMasked.Builder {
        // OF message fields
        private boolean valueSet;
        private OFPort value;
        private boolean maskSet;
        private OFPort mask;

    @Override
    public long getTypeLen() {
        return 0x80000108L;
    }

    @Override
    public OFPort getValue() {
        return value;
    }

    @Override
    public OFOxmInPortMasked.Builder setValue(OFPort value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public OFPort getMask() {
        return mask;
    }

    @Override
    public OFOxmInPortMasked.Builder setMask(OFPort mask) {
        this.mask = mask;
        this.maskSet = true;
        return this;
    }
    @Override
    public MatchField<OFPort> getMatchField() {
        return MatchField.IN_PORT;
    }

    @Override
    public boolean isMasked() {
        return true;
    }

    @Override
    public OFOxm<OFPort> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.4");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFOxmInPortMasked build() {
            OFPort value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");
            OFPort mask = this.maskSet ? this.mask : DEFAULT_VALUE_MASK;
            if(mask == null)
                throw new NullPointerException("Property mask must not be null");


            return new OFOxmInPortMaskedVer14(
                    value,
                    mask
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmInPortMasked> {
        @Override
        public OFOxmInPortMasked readFrom(ByteBuf bb) throws OFParseError {
            // fixed value property typeLen == 0x80000108L
            int typeLen = bb.readInt();
            if(typeLen != (int) 0x80000108)
                throw new OFParseError("Wrong typeLen: Expected=0x80000108L(0x80000108L), got="+typeLen);
            OFPort value = OFPort.read4Bytes(bb);
            OFPort mask = OFPort.read4Bytes(bb);

            OFOxmInPortMaskedVer14 oxmInPortMaskedVer14 = new OFOxmInPortMaskedVer14(
                    value,
                      mask
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmInPortMaskedVer14);
            return oxmInPortMaskedVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmInPortMaskedVer14Funnel FUNNEL = new OFOxmInPortMaskedVer14Funnel();
    static class OFOxmInPortMaskedVer14Funnel implements Funnel<OFOxmInPortMaskedVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmInPortMaskedVer14 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x80000108L
            sink.putInt((int) 0x80000108);
            message.value.putTo(sink);
            message.mask.putTo(sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmInPortMaskedVer14> {
        @Override
        public void write(ByteBuf bb, OFOxmInPortMaskedVer14 message) {
            // fixed value property typeLen = 0x80000108L
            bb.writeInt((int) 0x80000108);
            message.value.write4Bytes(bb);
            message.mask.write4Bytes(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmInPortMaskedVer14(");
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
        OFOxmInPortMaskedVer14 other = (OFOxmInPortMaskedVer14) obj;

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
