package org.sarace.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneNCycleTest {
    private static void dotest(int n, int expected) {
        int actual = OneNCycle.cycle(n);
        assertEquals(expected, actual);
    }
    @Test
    public void test1() {
        dotest(33, 2);
        dotest(18118, -1);
        dotest(69, 22);
        dotest(197, 98);
        dotest(65, -1);
    }
}