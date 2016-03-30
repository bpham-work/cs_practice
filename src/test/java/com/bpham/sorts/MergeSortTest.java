package com.bpham.sorts;

import org.junit.Test;

import static com.bpham.sorts.SortTestHelper.createArray;
import static com.bpham.sorts.SortTestHelper.isSorted;
import static org.junit.Assert.assertTrue;

public class MergeSortTest {

    @Test
    public void test() {
        Integer[] array = createArray(100);

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }
}
