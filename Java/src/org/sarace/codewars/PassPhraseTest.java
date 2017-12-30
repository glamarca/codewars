package org.sarace.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class PassPhraseTest {

        @Test
        public void test1Char(){
            assertEquals(PassPhrase.passPhrase("a", 0),"A");
            assertEquals(PassPhrase.passPhrase("1", 0),"8");
            assertEquals(PassPhrase.passPhrase("+", 0),"+");
            assertEquals(PassPhrase.passPhrase("a", 1),"B");
            assertEquals(PassPhrase.passPhrase("a", 2),"C");
        }

        @Test
        public void testString(){
            assertEquals("!!!vPz fWpM J", PassPhrase.passPhrase("I LOVE YOU!!!", 1));
        }
}