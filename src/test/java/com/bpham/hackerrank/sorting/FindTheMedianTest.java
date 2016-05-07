package com.bpham.hackerrank.sorting;

import com.bpham.hackerrank.sorting.FindTheMedian;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindTheMedianTest {

    @Test
    public void findMedianIndex() {
        int[] array = {3, 2, 5, 1, 4};

        int median = FindTheMedian.findMedianIndex(array);

        assertEquals(2, median);
    }

    @Test
    public void findMedianIndexFromSortedArray() {
        int[] array = {1, 2, 3, 4, 5};

        int median = FindTheMedian.findMedianIndex(array);

        assertEquals(2, median);
    }

    @Test
    public void findMedianIndexFromReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};

        int median = FindTheMedian.findMedianIndex(array);

        assertEquals(2, median);
    }

    @Test
    public void partitionTest() {
        int[] array = {3, 2, 5, 1, 4};

        int partitionIndex = FindTheMedian.partition(array, 0, 4);

        assertEquals(2, partitionIndex);
    }

    @Test
    public void partitionReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};

        int partitionIndex = FindTheMedian.partition(array, 0, 4);

        assertEquals(4, partitionIndex);
    }

    @Test
    public void partitionSortedArray() {
        int[] array = {1, 2, 3, 4, 5};

        int partitionIndex = FindTheMedian.partition(array, 0, 4);

        assertEquals(0, partitionIndex);
    }

    @Test
    public void findMedianValue() {
        int[] array = {0, 1, 2, 4, 6, 5, 3};

        int median = FindTheMedian.findMedianValue(array);

        assertEquals(3, median);
    }

    @Test
    public void findMedianValueFromSortedArray() {
        int[] array = {1, 2, 3, 4, 5};

        int median = FindTheMedian.findMedianValue(array);

        assertEquals(3, median);
    }

    @Test
    public void findMedianValueFromReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};

        int median = FindTheMedian.findMedianValue(array);

        assertEquals(3, median);
    }

    @Test
    public void findMedianValueFromArrayWithSameValues() {
        int[] array = {5, 5, 5, 5, 5};

        int median = FindTheMedian.findMedianValue(array);

        assertEquals(5, median);
    }
}
