package org.sarace.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class SurrealNumbersConstructionRuleTest {

    @Test
    public void simpleTest1() {
        assertEquals(true, SurrealNumbersConstructionRule.isSurreal("-1", "1"));
    }

    @Test
    public void simpleTest2() {
        assertEquals(false, SurrealNumbersConstructionRule.isSurreal("1", "-1"));
    }

}