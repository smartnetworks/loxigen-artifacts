// Created manually, following the template for OFActionNiciraDecTtlVer13.java

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
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFActionNiciraPopL2Ver13 implements OFActionNiciraPopL2 {
    private static final Logger logger = LoggerFactory.getLogger(OFActionNiciraPopL2Ver13.class);
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int LENGTH = 16;


    // OF message fields
    //
    // Immutable default instance
    final static OFActionNiciraPopL2Ver13 DEFAULT = new OFActionNiciraPopL2Ver13(

    );

    final static OFActionNiciraPopL2Ver13 INSTANCE = new OFActionNiciraPopL2Ver13();
    // private empty constructor - use shared instance!
    private OFActionNiciraPopL2Ver13() {
    }

    // Accessors for OF message fields
    @Override
    public OFActionType getType() {
        return OFActionType.EXPERIMENTER;
    }

    @Override
    public long getExperimenter() {
        return 0x2320L;
    }

    @Override
    public int getSubtype() {
        return 0x1A;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_13;
    }



    // no data members - do not support builder
    public OFActionNiciraPopL2.Builder createBuilder() {
        throw new UnsupportedOperationException("OFActionNiciraPopL2Ver13 has no mutable properties -- builder unneeded");
    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFActionNiciraPopL2> {
        @Override
        public OFActionNiciraPopL2 readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 65535
            short type = bb.readShort();
            if(type != (short) 0xffff)
                throw new OFParseError("Wrong type: Expected=OFActionType.EXPERIMENTER(65535), got="+type);
            int length = U16.f(bb.readShort());
            if(length != 16)
                throw new OFParseError("Wrong length: Expected=16(16), got="+length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            // fixed value property experimenter == 0x2320L
            int experimenter = bb.readInt();
            if(experimenter != 0x2320)
                throw new OFParseError("Wrong experimenter: Expected=0x2320L(0x2320L), got="+experimenter);
            // fixed value property subtype == 0x1A
            short subtype = bb.readShort();
            if(subtype != (short) 0x1A)
                throw new OFParseError("Wrong subtype: Expected=0x1A(0x1A), got="+subtype);
            // pad: 2 bytes
            bb.skipBytes(2);
            // pad: 4 bytes
            bb.skipBytes(4);

            if(logger.isTraceEnabled())
                logger.trace("readFrom - returning shared instance={}", INSTANCE);
            return INSTANCE;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFActionNiciraPopL2Ver13Funnel FUNNEL = new OFActionNiciraPopL2Ver13Funnel();
    static class OFActionNiciraPopL2Ver13Funnel implements Funnel<OFActionNiciraPopL2Ver13> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFActionNiciraPopL2Ver13 message, PrimitiveSink sink) {
            // fixed value property type = 65535
            sink.putShort((short) 0xffff);
            // fixed value property length = 16
            sink.putShort((short) 0x10);
            // fixed value property experimenter = 0x2320L
            sink.putInt(0x2320);
            // fixed value property subtype = 0x1A
            sink.putShort((short) 0x1A);
            // skip pad (2 bytes)
            // skip pad (4 bytes)
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFActionNiciraPopL2Ver13> {
        @Override
        public void write(ByteBuf bb, OFActionNiciraPopL2Ver13 message) {
            // fixed value property type = 65535
            bb.writeShort((short) 0xffff);
            // fixed value property length = 16
            bb.writeShort((short) 0x10);
            // fixed value property experimenter = 0x2320L
            bb.writeInt(0x2320);
            // fixed value property subtype = 0x1A
            bb.writeShort((short) 0x1A);
            // pad: 2 bytes
            bb.writeZero(2);
            // pad: 4 bytes
            bb.writeZero(4);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFActionNiciraPopL2Ver13(");
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        return result;
    }

}
