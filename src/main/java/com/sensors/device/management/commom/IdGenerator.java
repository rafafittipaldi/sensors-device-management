package com.sensors.device.management.commom;

import io.hypersistence.tsid.TSID;
import java.util.Optional;

public class IdGenerator {

    private static final TSID.Factory tsdiFactory;

    static {
        Optional.ofNullable(System.getenv("tsid.node"))
                .ifPresent(tsidNode -> System.setProperty("tsid.node", tsidNode));

        Optional.ofNullable(System.getenv("tsid.node.count"))
                .ifPresent(tsidNodeCount -> System.setProperty("tsid.node.count", tsidNodeCount));

        tsdiFactory = TSID.Factory.builder().build();
    }

    private IdGenerator() {}

    public static TSID generateTSDI() {
        return tsdiFactory.generate();
    }
}
