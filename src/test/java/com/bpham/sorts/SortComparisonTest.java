package com.bpham.sorts;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.bpham.sorts.SortTestHelper.*;
import static org.junit.Assert.assertTrue;

public class SortComparisonTest {
    int ARRAY_SIZE = 100000;
    Integer[] randomArray = createRandomArray(ARRAY_SIZE);
    StopWatch stopWatch = new StopWatch();

    Integer[] array;

    @Before
    public void setUp() {
        array = Arrays.copyOf(randomArray, ARRAY_SIZE);
    }

    @After
    public void destroy() {
        stopWatch.reset();
    }

    @Test
    public void selectionSortTest() {
        stopWatch.start();

        SelectionSort.sort(array);

        stopWatch.stop();
        System.out.println("Selection sort time: " + stopWatch.getTime());

        assertTrue(isSorted(array));
    }

    @Test
    public void insertionSortTest() {
        stopWatch.start();

        InsertionSort.sort(array);

        stopWatch.stop();
        System.out.println("Insertion sort time: " + stopWatch.getTime());

        assertTrue(isSorted(array));
    }

    @Test
    public void mergeSortTest() {
        stopWatch.start();

        MergeSort.sort(array);

        stopWatch.stop();
        System.out.println("Merge sort time: " + stopWatch.getTime());

        assertTrue(isSorted(array));
    }

    @Test
    public void insertionSortOnReverseSortedArray() {
        Integer[] array = createReverseSortedArray(100000);

        stopWatch.start();

        InsertionSort.sort(array);

        stopWatch.stop();
        System.out.println("Insertion sort on reverse array sort time: " + stopWatch.getTime());

        assertTrue(isSorted(array));
    }

    @Test
    public void insertionSortOnSortedArray() {
        Integer[] array = createSortedArray(100000);

        stopWatch.start();

        InsertionSort.sort(array);

        stopWatch.stop();
        System.out.println("Insertion sort on sorted array sort time: " + stopWatch.getTime());

        assertTrue(isSorted(array));
    }
}
