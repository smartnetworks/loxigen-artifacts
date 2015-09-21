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
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFBsnControllerConnectionVer13 implements OFBsnControllerConnection {
    private static final Logger logger = LoggerFactory.getLogger(OFBsnControllerConnectionVer13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int LENGTH = 264;

        private final static OFAuxId DEFAULT_AUXILIARY_ID = OFAuxId.MAIN;
        private final static String DEFAULT_URI = "";

    // OF message fields
    private final OFBsnControllerConnectionState state;
    private final OFAuxId auxiliaryId;
    private final OFControllerRole role;
    private final String uri;
//

    // package private constructor - used by readers, builders, and factory
    OFBsnControllerConnectionVer13(OFBsnControllerConnectionState state, OFAuxId auxiliaryId, OFControllerRole role, String uri) {
        if(state == null) {
            throw new NullPointerException("OFBsnControllerConnectionVer13: property state cannot be null");
        }
        if(auxiliaryId == null) {
            throw new NullPointerException("OFBsnControllerConnectionVer13: property auxiliaryId cannot be null");
        }
        if(role == null) {
            throw new NullPointerException("OFBsnControllerConnectionVer13: property role cannot be null");
        }
        if(uri == null) {
            throw new NullPointerException("OFBsnControllerConnectionVer13: property uri cannot be null");
        }
        this.state = state;
        this.auxiliaryId = auxiliaryId;
        this.role = role;
        this.uri = uri;
    }

    // Accessors for OF message fields
    @Override
    public OFBsnControllerConnectionState getState() {
        return state;
    }

    @Override
    public OFAuxId getAuxiliaryId() {
        return auxiliaryId;
    }

    @Override
    public OFControllerRole getRole() {
        return role;
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    public OFBsnControllerConnection.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFBsnControllerConnection.Builder {
        final OFBsnControllerConnectionVer13 parentMessage;

        // OF message fields
        private boolean stateSet;
        private OFBsnControllerConnectionState state;
        private boolean auxiliaryIdSet;
        private OFAuxId auxiliaryId;
        private boolean roleSet;
        private OFControllerRole role;
        private boolean uriSet;
        private String uri;

        BuilderWithParent(OFBsnControllerConnectionVer13 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public OFBsnControllerConnectionState getState() {
        return state;
    }

    @Override
    public OFBsnControllerConnection.Builder setState(OFBsnControllerConnectionState state) {
        this.state = state;
        this.stateSet = true;
        return this;
    }
    @Override
    public OFAuxId getAuxiliaryId() {
        return auxiliaryId;
    }

    @Override
    public OFBsnControllerConnection.Builder setAuxiliaryId(OFAuxId auxiliaryId) {
        this.auxiliaryId = auxiliaryId;
        this.auxiliaryIdSet = true;
        return this;
    }
    @Override
    public OFControllerRole getRole() {
        return role;
    }

    @Override
    public OFBsnControllerConnection.Builder setRole(OFControllerRole role) {
        this.role = role;
        this.roleSet = true;
        return this;
    }
    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public OFBsnControllerConnection.Builder setUri(String uri) {
        this.uri = uri;
        this.uriSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



        @Override
        public OFBsnControllerConnection build() {
                OFBsnControllerConnectionState state = this.stateSet ? this.state : parentMessage.state;
                if(state == null)
                    throw new NullPointerException("Property state must not be null");
                OFAuxId auxiliaryId = this.auxiliaryIdSet ? this.auxiliaryId : parentMessage.auxiliaryId;
                if(auxiliaryId == null)
                    throw new NullPointerException("Property auxiliaryId must not be null");
                OFControllerRole role = this.roleSet ? this.role : parentMessage.role;
                if(role == null)
                    throw new NullPointerException("Property role must not be null");
                String uri = this.uriSet ? this.uri : parentMessage.uri;
                if(uri == null)
                    throw new NullPointerException("Property uri must not be null");

                //
                return new OFBsnControllerConnectionVer13(
                    state,
                    auxiliaryId,
                    role,
                    uri
                );
        }

    }

    static class Builder implements OFBsnControllerConnection.Builder {
        // OF message fields
        private boolean stateSet;
        private OFBsnControllerConnectionState state;
        private boolean auxiliaryIdSet;
        private OFAuxId auxiliaryId;
        private boolean roleSet;
        private OFControllerRole role;
        private boolean uriSet;
        private String uri;

    @Override
    public OFBsnControllerConnectionState getState() {
        return state;
    }

    @Override
    public OFBsnControllerConnection.Builder setState(OFBsnControllerConnectionState state) {
        this.state = state;
        this.stateSet = true;
        return this;
    }
    @Override
    public OFAuxId getAuxiliaryId() {
        return auxiliaryId;
    }

    @Override
    public OFBsnControllerConnection.Builder setAuxiliaryId(OFAuxId auxiliaryId) {
        this.auxiliaryId = auxiliaryId;
        this.auxiliaryIdSet = true;
        return this;
    }
    @Override
    public OFControllerRole getRole() {
        return role;
    }

    @Override
    public OFBsnControllerConnection.Builder setRole(OFControllerRole role) {
        this.role = role;
        this.roleSet = true;
        return this;
    }
    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public OFBsnControllerConnection.Builder setUri(String uri) {
        this.uri = uri;
        this.uriSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }

//
        @Override
        public OFBsnControllerConnection build() {
            if(!this.stateSet)
                throw new IllegalStateException("Property state doesn't have default value -- must be set");
            if(state == null)
                throw new NullPointerException("Property state must not be null");
            OFAuxId auxiliaryId = this.auxiliaryIdSet ? this.auxiliaryId : DEFAULT_AUXILIARY_ID;
            if(auxiliaryId == null)
                throw new NullPointerException("Property auxiliaryId must not be null");
            if(!this.roleSet)
                throw new IllegalStateException("Property role doesn't have default value -- must be set");
            if(role == null)
                throw new NullPointerException("Property role must not be null");
            String uri = this.uriSet ? this.uri : DEFAULT_URI;
            if(uri == null)
                throw new NullPointerException("Property uri must not be null");


            return new OFBsnControllerConnectionVer13(
                    state,
                    auxiliaryId,
                    role,
                    uri
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFBsnControllerConnection> {
        @Override
        public OFBsnControllerConnection readFrom(ByteBuf bb) throws OFParseError {
            OFBsnControllerConnectionState state = OFBsnControllerConnectionStateSerializerVer13.readFrom(bb);
            OFAuxId auxiliaryId = OFAuxId.readByte(bb);
            // pad: 2 bytes
            bb.skipBytes(2);
            OFControllerRole role = OFControllerRoleSerializerVer13.readFrom(bb);
            String uri = ChannelUtils.readFixedLengthString(bb, 256);

            OFBsnControllerConnectionVer13 bsnControllerConnectionVer13 = new OFBsnControllerConnectionVer13(
                    state,
                      auxiliaryId,
                      role,
                      uri
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", bsnControllerConnectionVer13);
            return bsnControllerConnectionVer13;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFBsnControllerConnectionVer13Funnel FUNNEL = new OFBsnControllerConnectionVer13Funnel();
    static class OFBsnControllerConnectionVer13Funnel implements Funnel<OFBsnControllerConnectionVer13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFBsnControllerConnectionVer13 message, PrimitiveSink sink) {
            OFBsnControllerConnectionStateSerializerVer13.putTo(message.state, sink);
            message.auxiliaryId.putTo(sink);
            // skip pad (2 bytes)
            OFControllerRoleSerializerVer13.putTo(message.role, sink);
            sink.putUnencodedChars(message.uri);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFBsnControllerConnectionVer13> {
        @Override
        public void write(ByteBuf bb, OFBsnControllerConnectionVer13 message) {
            OFBsnControllerConnectionStateSerializerVer13.writeTo(bb, message.state);
            message.auxiliaryId.writeByte(bb);
            // pad: 2 bytes
            bb.writeZero(2);
            OFControllerRoleSerializerVer13.writeTo(bb, message.role);
            ChannelUtils.writeFixedLengthString(bb, message.uri, 256);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFBsnControllerConnectionVer13(");
        b.append("state=").append(state);
        b.append(", ");
        b.append("auxiliaryId=").append(auxiliaryId);
        b.append(", ");
        b.append("role=").append(role);
        b.append(", ");
        b.append("uri=").append(uri);
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
        OFBsnControllerConnectionVer13 other = (OFBsnControllerConnectionVer13) obj;

        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (auxiliaryId == null) {
            if (other.auxiliaryId != null)
                return false;
        } else if (!auxiliaryId.equals(other.auxiliaryId))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (uri == null) {
            if (other.uri != null)
                return false;
        } else if (!uri.equals(other.uri))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((auxiliaryId == null) ? 0 : auxiliaryId.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((uri == null) ? 0 : uri.hashCode());
        return result;
    }

}
