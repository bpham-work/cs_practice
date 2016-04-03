package com.bpham.sorts;

import org.junit.Test;

import static com.bpham.sorts.SortTestHelper.createRandomArray;
import static com.bpham.sorts.SortTestHelper.isSorted;
import static org.junit.Assert.assertTrue;

public class MergeSortTest {

    @Test
    public void sortTest() {
        Integer[] array = createRandomArray(100000);

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void sortWhereLeftPointerRunsOffIntoRightSubarray() {
        Integer[] array = {67, 54, 47, 77, 41, 18};

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void sortWhereRightPointerRunsOff() {
        Integer[] array = {1, 6, 10, 2, 3};

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }


    @Test
    public void sortAlreadySortedArray() {
        Integer[] array = {1, 2, 3, 4, 5};

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void sortAlreadySortedArrayOfEvenElements() {
        Integer[] array = {1, 2, 3, 4, 5, 6};

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void sortReverseSortedArray() {
        Integer[] array = {5, 4, 3, 2, 1};

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void sortReverseSortedArrayOfEvenElements() {
        Integer[] array = {6, 5, 4, 3, 2, 1};

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void sortArrayOfSameElements() {
        Integer[] array = {5, 5, 5, 5, 5};

        MergeSort.sort(array);

        assertTrue(isSorted(array));
    }

    @Test
    public void mergeTwoSortedSubarraysWhereRightPointerRunsOff() {
        Integer[] array = {1, 6, 10, 2, 3};

        MergeSort.merge(array, new Integer[5], 0, 4);

        assertTrue(isSorted(array));
    }

    @Test
    public void mergeTwoSortedSubarraysWhereLeftPointerRunsOffIntoRightSubarray() {
        Integer[] array = {47, 54, 67, 18, 41, 77};

        MergeSort.merge(array, new Integer[6], 0, 5);

        assertTrue(isSorted(array));
    }

    @Test
    public void mergeTwoSortedSubarraysWithCommonElements() {
        Integer[] array = {1, 3, 7, 3, 3};

        MergeSort.merge(array, new Integer[5], 0, 4);

        assertTrue(isSorted(array));
    }
}
