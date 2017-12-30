package org.sarace.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleColaTest {

    @Test
    public void test1() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 1;
        assertEquals("Sheldon", DoubleCola.WhoIsNext(names, n));
    }

    @Test
    public void test2() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 6;
        assertEquals("Sheldon", DoubleCola.WhoIsNext(names, n));
    }

    @Test
    public void testN() {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        assertEquals("Penny", DoubleCola.WhoIsNext(names, 52));
        assertEquals("Rajesh", DoubleCola.WhoIsNext(names, 63));
    }
}