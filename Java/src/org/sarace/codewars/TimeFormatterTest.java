package org.sarace.codewars;

import static org.junit.Assert.*;

public class TimeFormatterTest {

    @org.junit.Test
    public void formatZero() {
        assertEquals("now", TimeFormatter.formatDuration(0));
        assertEquals("1 heures, 2 secondes", TimeFormatter.formatDuration(62));
    }
}