package com.bpham.sorts;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import static com.bpham.sorts.SortTestHelper.createArray;
import static com.bpham.sorts.SortTestHelper.isSorted;
import static org.junit.Assert.assertTrue;

public class SortingTest {

    @Test
    public void selectionSortTest() {
        Integer[] array = createArray(100000);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        SelectionSort.sort(array);

        stopWatch.stop();
        System.out.println("Selection sort time: " + stopWatch.getTime());

        assertTrue(isSorted(array));
    }

    @Test
    public void insertionSortTest() {
        Integer[] array = createArray(100000);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        InsertionSort.sort(array);

        stopWatch.stop();
        System.out.println("Insertion sort time: " + stopWatch.getTime());

        assertTrue(isSorted(array));
    }
}
