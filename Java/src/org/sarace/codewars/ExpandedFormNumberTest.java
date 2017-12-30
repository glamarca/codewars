package org.sarace.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpandedFormNumberTest {

    @Test
    public void expandedForm() {
        assertEquals("10 + 2", ExpandedFormNumber.expandedForm(12));
        assertEquals("40 + 2", ExpandedFormNumber.expandedForm(42));
        assertEquals("70000 + 300 + 4", ExpandedFormNumber.expandedForm(70304));
        assertEquals("90000", ExpandedFormNumber.expandedForm(90000));
    }
}