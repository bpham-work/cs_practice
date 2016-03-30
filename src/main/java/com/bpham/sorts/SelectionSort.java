package com.bpham.sorts;

public class SelectionSort extends AbstractSorter {

    public static void sort(Comparable[] array) {
        for (int x = 0; x < array.length; x++) {
            int smallestIndex = x;
            for (int i = x; i < array.length; i++) {
                if (array[smallestIndex].compareTo(array[i]) == 1) {
                    smallestIndex = i;
                }
            }
            swap(array, x, smallestIndex);
        }
    }
}
