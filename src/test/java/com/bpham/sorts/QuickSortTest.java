package com.bpham.sorts;

import org.junit.Test;

import static com.bpham.sorts.SortTestHelper.createRandomArray;
import static com.bpham.sorts.SortTestHelper.isSorted;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class QuickSortTest {

    @Test
    public void quickSortTest() {
        Integer[] array = {4, 2, 5, 7, 1};

        QuickSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void quickSortArrayOfSameElements() {
        Integer[] array = {1, 1, 1, 1, 1};

        QuickSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void partitionTestOnArrayOfUniqueElements() {
        Integer[] array = {4, 2, 5, 7, 1};

        int endingPartitionIndex = QuickSort.partition(array, 0, 4);

        assertEquals(2, endingPartitionIndex);
        assertTrue(array[endingPartitionIndex] > array[0]);
        assertTrue(array[endingPartitionIndex] > array[1]);
        assertTrue(array[endingPartitionIndex] < array[3]);
        assertTrue(array[endingPartitionIndex] < array[4]);
    }

    @Test
    public void partitionArrayOfElementsSameAsPartitionElement() {
        Integer[] array = {4, 4, 4};

        int endingPartitionIndex = QuickSort.partition(array, 0, 2);

        assertEquals(0, endingPartitionIndex);
        assertTrue(array[endingPartitionIndex] >= array[0]);
        assertTrue(array[endingPartitionIndex] <= array[2]);
    }

    @Test
    public void partitionArrayWithAFewSameElements() {
        Integer[] array = {4, 7, 7, 1, 1};

        int endingPartitionIndex = QuickSort.partition(array, 0, 4);

        assertEquals(2, endingPartitionIndex);
        assertTrue(array[endingPartitionIndex] > array[0]);
        assertTrue(array[endingPartitionIndex] > array[1]);
        assertTrue(array[endingPartitionIndex] < array[3]);
        assertTrue(array[endingPartitionIndex] < array[4]);
    }

    @Test
    public void partitionReversePartitionedArray() {
        Integer[] array = {4, 7, 1};

        int endingPartitionIndex = QuickSort.partition(array, 0, 2);

        assertEquals(1, endingPartitionIndex);
        assertTrue(array[endingPartitionIndex] > array[0]);
        assertTrue(array[endingPartitionIndex] < array[2]);
    }

    @Test
    public void partitionAlreadyPartitionedArray() {
        Integer[] array = {4, 1, 7};

        int endingPartitionIndex = QuickSort.partition(array, 0, 2);

        assertEquals(1, endingPartitionIndex);
        assertTrue(array[endingPartitionIndex] > array[0]);
        assertTrue(array[endingPartitionIndex] < array[2]);
    }
}
