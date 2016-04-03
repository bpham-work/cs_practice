package com.bpham.sorts;

import java.util.Random;

public class SortTestHelper {
    private static final Random random = new Random();

    public static boolean isSorted(Integer[] array) {
        Integer prev = 0;
        for (Integer value : array) {
            if (value.compareTo(prev) == -1) {
                return false;
            }
            prev = value;
        }
        return true;
    }

    public static Integer[] createRandomArray(int size) {
        Integer[] array = new Integer[size];
        for (int x = 0; x < size; x++) {
            array[x] = random.nextInt(100);
        }
        return array;
    }

    public static Integer[] createReverseSortedArray(int size) {
        Integer[] array = new Integer[size];
        for (int x = size; x > 0; x--) {
            array[size - x] = x;
        }
        return array;
    }

    public static Integer[] createSortedArray(int size) {
        Integer[] array = new Integer[size];
        for (int x = 0; x < size; x++) {
            array[x] = x;
        }
        return array;
    }
}
