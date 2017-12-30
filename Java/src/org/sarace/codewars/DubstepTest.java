package org.sarace.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class DubstepTest {
    @Test
    public void Test1() {
        assertEquals("ABC", new Dubstep().SongDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
        assertEquals("R L", new Dubstep().SongDecoder("RWUBWUBWUBLWUB"));
    }
    @Test
    public void Test3()
    {
        assertEquals("", new Dubstep().SongDecoder("WUBWUBWUBWUB"));
    }
}