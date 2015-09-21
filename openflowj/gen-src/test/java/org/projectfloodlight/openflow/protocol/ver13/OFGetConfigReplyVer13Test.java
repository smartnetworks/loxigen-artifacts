// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template unit_test.java
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
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.EnumSet;
import java.util.Set;
import com.google.common.collect.Sets;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.hamcrest.CoreMatchers;



public class OFGetConfigReplyVer13Test {
    OFFactory factory;

    final static byte[] GET_CONFIG_REPLY_SERIALIZED =
        new byte[] { 0x4, 0x8, 0x0, 0xc, 0x12, 0x34, 0x56, 0x78, 0x0, 0x2, (byte) 0xff, (byte) 0xff };

    @Before
    public void setup() {
        factory = OFFactoryVer13.INSTANCE;
    }

    @Test
    public void testWrite() {
        OFGetConfigReply.Builder builder = factory.buildGetConfigReply();
        builder.setXid(0x12345678)
    .setFlags(Sets.immutableEnumSet(OFConfigFlags.FRAG_REASM))
    .setMissSendLen(0xffff)
    .build();
        OFGetConfigReply getConfigReply = builder.build();
        ByteBuf bb = Unpooled.buffer();
        getConfigReply.writeTo(bb);
        byte[] written = new byte[bb.readableBytes()];
        bb.readBytes(written);

        assertThat(written, CoreMatchers.equalTo(GET_CONFIG_REPLY_SERIALIZED));
    }

    @Test
    public void testRead() throws Exception {
        OFGetConfigReply.Builder builder = factory.buildGetConfigReply();
        builder.setXid(0x12345678)
    .setFlags(Sets.immutableEnumSet(OFConfigFlags.FRAG_REASM))
    .setMissSendLen(0xffff)
    .build();
        OFGetConfigReply getConfigReplyBuilt = builder.build();

        ByteBuf input = Unpooled.copiedBuffer(GET_CONFIG_REPLY_SERIALIZED);

        // FIXME should invoke the overall reader once implemented
        OFGetConfigReply getConfigReplyRead = OFGetConfigReplyVer13.READER.readFrom(input);
        assertEquals(GET_CONFIG_REPLY_SERIALIZED.length, input.readerIndex());

        assertEquals(getConfigReplyBuilt, getConfigReplyRead);
   }

   @Test
   public void testReadWrite() throws Exception {
       ByteBuf input = Unpooled.copiedBuffer(GET_CONFIG_REPLY_SERIALIZED);

       // FIXME should invoke the overall reader once implemented
       OFGetConfigReply getConfigReply = OFGetConfigReplyVer13.READER.readFrom(input);
       assertEquals(GET_CONFIG_REPLY_SERIALIZED.length, input.readerIndex());

       // write message again
       ByteBuf bb = Unpooled.buffer();
       getConfigReply.writeTo(bb);
       byte[] written = new byte[bb.readableBytes()];
       bb.readBytes(written);

       assertThat(written, CoreMatchers.equalTo(GET_CONFIG_REPLY_SERIALIZED));
   }

}
