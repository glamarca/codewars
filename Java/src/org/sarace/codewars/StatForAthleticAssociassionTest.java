package org.sarace.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatForAthleticAssociassionTest {

    @Test
    public void testStringIsNull(){
        assertNull(StatForAthleticAssociassion.computeStat(null));
    }

    @Test
    public void testStringIsEmpty() {
        assertTrue(StatForAthleticAssociassion.computeStat("").equals(""));
    }

    @Test
    public void testCompute() {
        assertEquals(StatForAthleticAssociassion.computeStat("01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"), "Range: 01|47|18 Average: 01|35|15 Median: 01|32|34");
    }

}