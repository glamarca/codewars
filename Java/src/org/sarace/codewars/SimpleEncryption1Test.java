package org.sarace.codewars;

import junit.framework.TestCase;

/**
 * Created by sarace on 15/12/17.
 */
public class SimpleEncryption1Test extends TestCase {

    public void testEncrypt() throws Exception {
        assertNull(SimpleEncryption1.encrypt(null, 1));
        assertEquals(SimpleEncryption1.encrypt("",1),"");
        assertEquals(SimpleEncryption1.encrypt("This test",0), "This test");
        assertEquals(SimpleEncryption1.encrypt("This test",-1), "This test");
        assertEquals("hsi  etTi sats!", SimpleEncryption1.encrypt("This is a test!", 1));
        assertEquals("hsi  etTi sats!", SimpleEncryption1.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", SimpleEncryption1.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", SimpleEncryption1.encrypt("This is a test!", 3));
        assertEquals("This is a test!", SimpleEncryption1.encrypt("This is a test!", 4));
        assertEquals("This is a test!", SimpleEncryption1.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", SimpleEncryption1.encrypt("This kata is very interesting!", 1));
    }

    public void testDecrypt() throws Exception {
        assertEquals("This is a test!", SimpleEncryption1.decrypt("This is a test!", 0));
        assertEquals("", SimpleEncryption1.decrypt("", 1));
        assertNull(SimpleEncryption1.decrypt(null, 1));
        assertEquals("This is a test!", SimpleEncryption1.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", SimpleEncryption1.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", SimpleEncryption1.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", SimpleEncryption1.decrypt("This is a test!", 4));
        assertEquals("This is a test!", SimpleEncryption1.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", SimpleEncryption1.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }
}