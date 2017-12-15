package org.sarace.codewars;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by sarace on 15/12/17.
 */
public class OnesAndZerosTest extends TestCase {

    @Test
    public void testConvertBinaryArrayToInt() throws Exception {
        assertEquals(1, OnesAndZeros.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0, 0, 0, 1))));
        assertEquals(15, OnesAndZeros.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1, 1, 1, 1))));
        assertEquals(6, OnesAndZeros.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0, 1, 1, 0))));
        assertEquals(9, OnesAndZeros.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1, 0, 0, 1))));
    }

    @Test
    public void testConvertRecursive() throws Exception {
        assertEquals(1, OnesAndZeros.convertRecursive(new LinkedList<>(Arrays.asList(0, 0, 0, 1)),0,3,0,3));
        assertEquals(15, OnesAndZeros.convertRecursive(new LinkedList<>(Arrays.asList(1, 1, 1, 1)),0,3,0,3));
        assertEquals(6, OnesAndZeros.convertRecursive(new LinkedList<>(Arrays.asList(0, 1, 1, 0)),0,3,0,3));
        assertEquals(9, OnesAndZeros.convertRecursive(new LinkedList<>(Arrays.asList(1, 0, 0, 1)),0,3,0,3));
    }
}