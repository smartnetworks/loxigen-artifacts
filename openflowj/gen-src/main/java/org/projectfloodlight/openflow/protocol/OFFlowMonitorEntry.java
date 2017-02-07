// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_interface.java
// Do not modify

package org.projectfloodlight.openflow.protocol;

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
import java.util.Set;
import io.netty.buffer.ByteBuf;

public interface OFFlowMonitorEntry extends OFObject {
    long getMonitorId();
    long getOutPort();
    long getOutGroup();
    Set<OFFlowMonitorFlags> getFlags();
    TableId getTableId();
    OFFlowMonitorCommand getCommand();
    Match getMatch();
    OFVersion getVersion();

    void writeTo(ByteBuf channelBuffer);

    Builder createBuilder();
    public interface Builder  {
        OFFlowMonitorEntry build();
        long getMonitorId();
        Builder setMonitorId(long monitorId);
        long getOutPort();
        Builder setOutPort(long outPort);
        long getOutGroup();
        Builder setOutGroup(long outGroup);
        Set<OFFlowMonitorFlags> getFlags();
        Builder setFlags(Set<OFFlowMonitorFlags> flags);
        TableId getTableId();
        Builder setTableId(TableId tableId);
        OFFlowMonitorCommand getCommand();
        Builder setCommand(OFFlowMonitorCommand command);
        Match getMatch();
        Builder setMatch(Match match);
        OFVersion getVersion();
    }
}
