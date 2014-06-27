// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_factory_class.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver10;

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


public class OFInstructionIdsVer10 implements OFInstructionIds {
    public final static OFInstructionIdsVer10 INSTANCE = new OFInstructionIdsVer10();




    public OFInstructionIdApplyActions applyActions() {
        throw new UnsupportedOperationException("OFInstructionIdApplyActions not supported in version 1.0");
    }

    public OFInstructionIdBsnArpOffload bsnArpOffload() {
        throw new UnsupportedOperationException("OFInstructionIdBsnArpOffload not supported in version 1.0");
    }

    public OFInstructionIdBsnDeny bsnDeny() {
        throw new UnsupportedOperationException("OFInstructionIdBsnDeny not supported in version 1.0");
    }

    public OFInstructionIdBsnDhcpOffload bsnDhcpOffload() {
        throw new UnsupportedOperationException("OFInstructionIdBsnDhcpOffload not supported in version 1.0");
    }

    public OFInstructionIdBsnDisableSplitHorizonCheck bsnDisableSplitHorizonCheck() {
        throw new UnsupportedOperationException("OFInstructionIdBsnDisableSplitHorizonCheck not supported in version 1.0");
    }

    public OFInstructionIdBsnDisableSrcMacCheck bsnDisableSrcMacCheck() {
        throw new UnsupportedOperationException("OFInstructionIdBsnDisableSrcMacCheck not supported in version 1.0");
    }

    public OFInstructionIdBsnPacketOfDeath bsnPacketOfDeath() {
        throw new UnsupportedOperationException("OFInstructionIdBsnPacketOfDeath not supported in version 1.0");
    }

    public OFInstructionIdBsnPermit bsnPermit() {
        throw new UnsupportedOperationException("OFInstructionIdBsnPermit not supported in version 1.0");
    }

    public OFInstructionIdBsnPrioritizePdus bsnPrioritizePdus() {
        throw new UnsupportedOperationException("OFInstructionIdBsnPrioritizePdus not supported in version 1.0");
    }

    public OFInstructionIdBsnRequireVlanXlate bsnRequireVlanXlate() {
        throw new UnsupportedOperationException("OFInstructionIdBsnRequireVlanXlate not supported in version 1.0");
    }

    public OFInstructionIdClearActions clearActions() {
        throw new UnsupportedOperationException("OFInstructionIdClearActions not supported in version 1.0");
    }

    public OFInstructionIdGotoTable gotoTable() {
        throw new UnsupportedOperationException("OFInstructionIdGotoTable not supported in version 1.0");
    }

    public OFInstructionIdMeter meter() {
        throw new UnsupportedOperationException("OFInstructionIdMeter not supported in version 1.0");
    }

    public OFInstructionIdWriteActions writeActions() {
        throw new UnsupportedOperationException("OFInstructionIdWriteActions not supported in version 1.0");
    }

    public OFInstructionIdWriteMetadata writeMetadata() {
        throw new UnsupportedOperationException("OFInstructionIdWriteMetadata not supported in version 1.0");
    }

    public OFMessageReader<OFInstructionId> getReader() {
        throw new UnsupportedOperationException("Reader<OFInstructionId> not supported in version 1.0");
    }


    public OFVersion getVersion() {
            return OFVersion.OF_10;
    }
}
