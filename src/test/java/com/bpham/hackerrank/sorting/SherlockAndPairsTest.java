package com.bpham.hackerrank.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SherlockAndPairsTest {

    @Test
    public void findingMatchReturnsCorrectCount1() {
        int[] array = {1, 1, 2};

        long result = SherlockAndPairs.calculatePairs(array);

        assertEquals(2, result);
    }

    @Test
    public void findingMatchReturnsCorrectCount2() {
        int[] array = {1, 2, 3};

        long result = SherlockAndPairs.calculatePairs(array);

        assertEquals(0, result);
    }

    @Test
    public void findingMatchReturnsCorrectCount3() {
        int[] array = {1, 1, 1};

        long result = SherlockAndPairs.calculatePairs(array);

        assertEquals(6, result);
    }
}
