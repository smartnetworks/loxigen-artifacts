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

class OFOxmIpDscpVer13 implements OFOxmIpDscp {
    private static final Logger logger = LoggerFactory.getLogger(OFOxmIpDscpVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int LENGTH = 5;

        private final static IpDscp DEFAULT_VALUE = IpDscp.NONE;

    // OF message fields
    private final IpDscp value;
//
    // Immutable default instance
    final static OFOxmIpDscpVer13 DEFAULT = new OFOxmIpDscpVer13(
        DEFAULT_VALUE
    );

    // package private constructor - used by readers, builders, and factory
    OFOxmIpDscpVer13(IpDscp value) {
        if(value == null) {
            throw new NullPointerException("OFOxmIpDscpVer13: property value cannot be null");
        }
        this.value = value;
    }

    // Accessors for OF message fields
    @Override
    public long getTypeLen() {
        return 0x80001001L;
    }

    @Override
    public IpDscp getValue() {
        return value;
    }

    @Override
    public MatchField<IpDscp> getMatchField() {
        return MatchField.IP_DSCP;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    public OFOxm<IpDscp> getCanonical() {
        // exact match OXM is always canonical
        return this;
    }

    @Override
    public IpDscp getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFOxmIpDscp.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFOxmIpDscp.Builder {
        final OFOxmIpDscpVer13 parentMessage;

        // OF message fields
        private boolean valueSet;
        private IpDscp value;

        BuilderWithParent(OFOxmIpDscpVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public long getTypeLen() {
        return 0x80001001L;
    }

    @Override
    public IpDscp getValue() {
        return value;
    }

    @Override
    public OFOxmIpDscp.Builder setValue(IpDscp value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public MatchField<IpDscp> getMatchField() {
        return MatchField.IP_DSCP;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    @Override
    public OFOxm<IpDscp> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.3");
    }

    @Override
    public IpDscp getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFOxmIpDscp build() {
                IpDscp value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");

                //
                return new OFOxmIpDscpVer13(
                    value
                );
        }

    }

    static class Builder implements OFOxmIpDscp.Builder {
        // OF message fields
        private boolean valueSet;
        private IpDscp value;

    @Override
    public long getTypeLen() {
        return 0x80001001L;
    }

    @Override
    public IpDscp getValue() {
        return value;
    }

    @Override
    public OFOxmIpDscp.Builder setValue(IpDscp value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public MatchField<IpDscp> getMatchField() {
        return MatchField.IP_DSCP;
    }

    @Override
    public boolean isMasked() {
        return false;
    }

    @Override
    public OFOxm<IpDscp> getCanonical()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property canonical not supported in version 1.3");
    }

    @Override
    public IpDscp getMask()throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Property mask not supported in version 1.3");
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

//
        @Override
        public OFOxmIpDscp build() {
            IpDscp value = this.valueSet ? this.value : DEFAULT_VALUE;
            if(value == null)
                throw new NullPointerException("Property value must not be null");


            return new OFOxmIpDscpVer13(
                    value
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFOxmIpDscp> {
        @Override
        public OFOxmIpDscp readFrom(ChannelBuffer bb) throws OFParseError {
            // fixed value property typeLen == 0x80001001L
            int typeLen = bb.readInt();
            if(typeLen != (int) 0x80001001)
                throw new OFParseError("Wrong typeLen: Expected=0x80001001L(0x80001001L), got="+typeLen);
            IpDscp value = IpDscp.readByte(bb);

            OFOxmIpDscpVer13 oxmIpDscpVer13 = new OFOxmIpDscpVer13(
                    value
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", oxmIpDscpVer13);
            return oxmIpDscpVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFOxmIpDscpVer13Funnel FUNNEL = new OFOxmIpDscpVer13Funnel();
    static class OFOxmIpDscpVer13Funnel implements Funnel<OFOxmIpDscpVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFOxmIpDscpVer13 message, PrimitiveSink sink) {
            // fixed value property typeLen = 0x80001001L
            sink.putInt((int) 0x80001001);
            message.value.putTo(sink);
        }
    }


    public void writeTo(ChannelBuffer bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFOxmIpDscpVer13> {
        @Override
        public void write(ChannelBuffer bb, OFOxmIpDscpVer13 message) {
            // fixed value property typeLen = 0x80001001L
            bb.writeInt((int) 0x80001001);
            message.value.writeByte(bb);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFOxmIpDscpVer13(");
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
        OFOxmIpDscpVer13 other = (OFOxmIpDscpVer13) obj;

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
