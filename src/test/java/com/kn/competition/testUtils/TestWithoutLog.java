package com.kn.competition.testUtils;

import java.util.logging.LogManager;

/**
 * Test Without Log
 * Created by raindream on 03.05.19.
 */
public abstract class TestWithoutLog {

    public TestWithoutLog() {
        LogManager.getLogManager().reset();
    }
}
