// Created manually, following the template for OFActionIdNiciraDecTtl.java

package org.projectfloodlight.openflow.protocol.actionid;

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

public interface OFActionIdNiciraPushL2 extends OFObject, OFActionIdNicira {
    OFActionType getType();
    long getExperimenter();
    int getSubtype();
    OFVersion getVersion();


    void writeTo(ByteBuf channelBuffer);

    Builder createBuilder();
    public interface Builder extends OFActionIdNicira.Builder {
        OFActionIdNiciraPushL2 build();
        OFActionType getType();
        long getExperimenter();
        int getSubtype();
        OFVersion getVersion();
    }
}
