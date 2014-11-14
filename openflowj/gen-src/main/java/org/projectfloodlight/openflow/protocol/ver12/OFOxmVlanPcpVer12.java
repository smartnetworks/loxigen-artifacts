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
import org.jboss.netty.buffer.ChannelBuffer;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFOxmVlanPcpVer12 implements OFOxmVlanPcp {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmVlanPcpVer12.class);
    // version: 1.2
    final static byte WIRE_VERSION = 3;
    final static int LENGTH = 5;

        private final static VlanPcp DEFAULT_VALUE = VlanPcp.NONE;

    // OF message fields
    private final VlanPcp value;
//
    // Immutable default instance
    final static OFOxmVlanPcpVer12 DEFAULT = new OFOxmVlanPcpVer12(
        DEFAULT_VALUE
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmVlanPcpVer12(VlanPcp value) {
        if(value == null) {
            throw new NullPointerException("OFOxmVlanPcpVer12: property value cannot be null");
        }
        this.value = value;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x80000e01L;
    }

    @Override
    public VlanPcp getValue() {
        return value;
    }

    @Override
    public MatchField<VlanPcp> getMatchField() {
        return MatchField.VLAN_PCP;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    public OFOxm<VlanPcp> getCanonical() {
        // exact match OXM is always canonical
        return this;
    }

    @Override
    public VlanPcp getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



    public OFOxmVlanPcp.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmVlanPcp.Builder {
        final OFOxmVlanPcpVer12 parentMessage;

        // OF message fields
        private boolean valueSet;
        private VlanPcp value;

        BuilderWithParent(OFOxmVlanPcpVer12 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x80000e01L;
    }

    @Override
    public VlanPcp getValue() {
        return value;
    }

    @Override
    public OFOxmVlanPcp.Builder setValue(VlanPcp value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public MatchField<VlanPcp> getMatchField() {
        return MatchField.VLAN_PCP;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    @Override
    public OFOxm<VlanPcp> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.2");
    }

    @Override
    public VlanPcp getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }



        @Override
        public OFOxmVlanPcp build() {
                VlanPcp value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");

                //
                return new OFOxmVlanPcpVer12(
                    value
                );
        }

    }

    static class Builder implements OFOxmVlanPcp.Builder {
        // OF message fields
        private boolean valueSet;
        private VlanPcp value;

    @Override
    public long getTypeLen() {
        return 0x80000e01L;
    }

    @Override
    public VlanPcp getValue() {
        return value;
    }

    @Override
    public OFOxmVlanPcp.Builder setValue(VlanPcp value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public MatchField<VlanPcp> getMatchField() {
        return MatchField.VLAN_PCP;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    @Override
    public OFOxm<VlanPcp> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.2");
    }

    @Override
    public VlanPcp getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.2");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_12;
    }

//
        @Override
        public OFOxmVlanPcp build() {
            VlanPcp value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");


            return new OFOxmVlanPcpVer12(
                    value
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmVlanPcp> {
        @Override
        public OFOxmVlanPcp readFrom(ChannelBuffer bb) throws OFParseError {
            // fixed value property typeLen == 0x80000e01L
            int typeLen = bb.readInt();
            if(typeLen != (int) 0x80000e01)
                throw new OFParseError("Wrong typeLen: Expected=0x80000e01L(0x80000e01L), got="+typeLen);
            VlanPcp value = VlanPcp.readByte(bb);

            OFOxmVlanPcpVer12 oxmVlanPcpVer12 = new OFOxmVlanPcpVer12(
                    value
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmVlanPcpVer12);
            return oxmVlanPcpVer12;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmVlanPcpVer12Funnel FUNNEL = new OFOxmVlanPcpVer12Funnel();
    static class OFOxmVlanPcpVer12Funnel implements Funnel<OFOxmVlanPcpVer12> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmVlanPcpVer12 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x80000e01L
            sink.putInt((int) 0x80000e01);
            message.value.putTo(sink);
        }
    }


    public void writeTo(ChannelBuffer bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmVlanPcpVer12> {
        @Override
        public void write(ChannelBuffer bb, OFOxmVlanPcpVer12 message) {
            // fixed value property typeLen = 0x80000e01L
            bb.writeInt((int) 0x80000e01);
            message.value.writeByte(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmVlanPcpVer12(");
        b.append("value=").append(value);
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
        OFOxmVlanPcpVer12 other = (OFOxmVlanPcpVer12) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

}
