package com.bpham.hackerrank.warmup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaircaseTest {

    @Test
    public void shouldCreateStringWith6Hashes() {
        String result = Staircase.createString(6, 6);

        assertEquals("######", result);
    }

    @Test
    public void shouldCreateStringWith1HashRightJustify() {
        String result = Staircase.createString(1, 6);

        assertEquals("     #", result);
    }
}
