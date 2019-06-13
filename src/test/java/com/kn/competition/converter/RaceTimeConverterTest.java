package com.kn.competition.converter;

import com.kn.competition.testUtils.TestWithoutLog;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * RaceTimeConverterTest
 * Created by raindream on 02.05.19.
 */
public class RaceTimeConverterTest extends TestWithoutLog {

    @Test
    public void testConvertTimeStringToSeconds() {
        assertNull(RaceTimeConverter.convertTimeStringToSeconds(null));
        assertNull(RaceTimeConverter.convertTimeStringToSeconds(""));
        assertNull(RaceTimeConverter.convertTimeStringToSeconds("11.11"));
        assertNull(RaceTimeConverter.convertTimeStringToSeconds("11,11,11"));

        Double actual = RaceTimeConverter.convertTimeStringToSeconds("1.59.12");
        assertEquals(new Double(1*60D + 59D + 12D/1000).doubleValue(), actual.doubleValue());
    }

}
