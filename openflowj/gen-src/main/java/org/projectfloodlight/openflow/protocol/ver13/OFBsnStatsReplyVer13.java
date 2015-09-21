// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_virtual_class.java
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
import io.netty.buffer.ByteBuf;

abstract class OFBsnStatsReplyVer13 {
    // version: 1.3
    final static byte WIRE_VERSION = 4;
    final static int MINIMUM_LENGTH = 24;


    public final static OFBsnStatsReplyVer13.Reader READER = new Reader();

    static class Reader implements OFMessageReader<OFBsnStatsReply> {
        @Override
        public OFBsnStatsReply readFrom(ByteBuf bb) throws OFParseError {
            if(bb.readableBytes() < MINIMUM_LENGTH)
                return null;
            int start = bb.readerIndex();
            // fixed value property version == 4
            byte version = bb.readByte();
            if(version != (byte) 0x4)
                throw new OFParseError("Wrong version: Expected=OFVersion.OF_13(4), got="+version);
            // fixed value property type == 19
            byte type = bb.readByte();
            if(type != (byte) 0x13)
                throw new OFParseError("Wrong type: Expected=OFType.STATS_REPLY(19), got="+type);
            int length = U16.f(bb.readShort());
            if(length < MINIMUM_LENGTH)
                throw new OFParseError("Wrong length: Expected to be >= " + MINIMUM_LENGTH + ", was: " + length);
            U32.f(bb.readInt());
            // fixed value property statsType == 65535
            short statsType = bb.readShort();
            if(statsType != (short) 0xffff)
                throw new OFParseError("Wrong statsType: Expected=OFStatsType.EXPERIMENTER(65535), got="+statsType);
            OFStatsReplyFlagsSerializerVer13.readFrom(bb);
            // pad: 4 bytes
            bb.skipBytes(4);
            // fixed value property experimenter == 0x5c16c7L
            int experimenter = bb.readInt();
            if(experimenter != 0x5c16c7)
                throw new OFParseError("Wrong experimenter: Expected=0x5c16c7L(0x5c16c7L), got="+experimenter);
            int subtype = bb.readInt();
            bb.readerIndex(start);
            switch(subtype) {
               case 0xd:
                   // discriminator value 0xdL=0xdL for class OFBsnDebugCounterDescStatsReplyVer13
                   return OFBsnDebugCounterDescStatsReplyVer13.READER.readFrom(bb);
               case 0xc:
                   // discriminator value 0xcL=0xcL for class OFBsnDebugCounterStatsReplyVer13
                   return OFBsnDebugCounterStatsReplyVer13.READER.readFrom(bb);
               case 0xa:
                   // discriminator value 0xaL=0xaL for class OFBsnFlowChecksumBucketStatsReplyVer13
                   return OFBsnFlowChecksumBucketStatsReplyVer13.READER.readFrom(bb);
               case 0x10:
                   // discriminator value 0x10L=0x10L for class OFBsnGenericStatsReplyVer13
                   return OFBsnGenericStatsReplyVer13.READER.readFrom(bb);
               case 0x5:
                   // discriminator value 0x5L=0x5L for class OFBsnGentableBucketStatsReplyVer13
                   return OFBsnGentableBucketStatsReplyVer13.READER.readFrom(bb);
               case 0x4:
                   // discriminator value 0x4L=0x4L for class OFBsnGentableDescStatsReplyVer13
                   return OFBsnGentableDescStatsReplyVer13.READER.readFrom(bb);
               case 0x2:
                   // discriminator value 0x2L=0x2L for class OFBsnGentableEntryDescStatsReplyVer13
                   return OFBsnGentableEntryDescStatsReplyVer13.READER.readFrom(bb);
               case 0x3:
                   // discriminator value 0x3L=0x3L for class OFBsnGentableEntryStatsReplyVer13
                   return OFBsnGentableEntryStatsReplyVer13.READER.readFrom(bb);
               case 0x7:
                   // discriminator value 0x7L=0x7L for class OFBsnGentableStatsReplyVer13
                   return OFBsnGentableStatsReplyVer13.READER.readFrom(bb);
               case 0xe:
                   // discriminator value 0xeL=0xeL for class OFBsnImageDescStatsReplyVer13
                   return OFBsnImageDescStatsReplyVer13.READER.readFrom(bb);
               case 0x1:
                   // discriminator value 0x1L=0x1L for class OFBsnLacpStatsReplyVer13
                   return OFBsnLacpStatsReplyVer13.READER.readFrom(bb);
               case 0x8:
                   // discriminator value 0x8L=0x8L for class OFBsnPortCounterStatsReplyVer13
                   return OFBsnPortCounterStatsReplyVer13.READER.readFrom(bb);
               case 0x6:
                   // discriminator value 0x6L=0x6L for class OFBsnSwitchPipelineStatsReplyVer13
                   return OFBsnSwitchPipelineStatsReplyVer13.READER.readFrom(bb);
               case 0xb:
                   // discriminator value 0xbL=0xbL for class OFBsnTableChecksumStatsReplyVer13
                   return OFBsnTableChecksumStatsReplyVer13.READER.readFrom(bb);
               case 0x9:
                   // discriminator value 0x9L=0x9L for class OFBsnVlanCounterStatsReplyVer13
                   return OFBsnVlanCounterStatsReplyVer13.READER.readFrom(bb);
               case 0xf:
                   // discriminator value 0xfL=0xfL for class OFBsnVrfCounterStatsReplyVer13
                   return OFBsnVrfCounterStatsReplyVer13.READER.readFrom(bb);
               default:
                   throw new OFParseError("Unknown value for discriminator subtype of class OFBsnStatsReplyVer13: " + subtype);
            }
        }
    }
}
