package com.bpham.sorts;

public class InsertionSort extends AbstractSorter {

    public static void sort(Comparable[] array) {
        for (int x = 0; x < array.length; x++) {
            for (int i = x; i > 0; i--) {
                if (array[i].compareTo(array[i-1]) == -1) {
                    swap(array, i, i-1);
                } else {
                    break;
                }
            }
        }
    }
}
