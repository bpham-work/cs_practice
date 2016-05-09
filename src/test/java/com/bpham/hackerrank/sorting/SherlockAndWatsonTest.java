package com.bpham.hackerrank.sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SherlockAndWatsonTest {

    @Test
    public void shiftArrayElementsRightFromIndexTest() {
        int[] array = {1, 2, 3, 4, 5};

        SherlockAndWatson.shiftRightFromIndex(array, new int[array.length], 0);

        assertArrayEquals(new int[]{1, 1, 2, 3, 4}, array);
    }

    @Test
    public void rotateTest() {
        int[] array = {1, 2, 3, 4, 5};

        SherlockAndWatson.rotate(array, new int[array.length]);

        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, array);
    }

    @Test
    public void rotateMultipleTimesTest() {
        int[] array = {1, 2, 3, 4, 5};

        SherlockAndWatson.rotate(array, new int[array.length], 2);

        assertArrayEquals(new int[]{4, 5, 1, 2, 3}, array);
    }

    @Test
    public void getPreRotationIndexWhenNumberOfRotationsIsWithinArrayLength() {
        int result = SherlockAndWatson.getPreRotationIndex(0, 2, 3);

        assertEquals(1, result);
    }

    @Test
    public void getPreRotationIndexWhenNumberOfRotationsIsGreaterThanArrayLength() {
        int result = SherlockAndWatson.getPreRotationIndex(0, 5, 3);

        assertEquals(1, result);
    }
}
