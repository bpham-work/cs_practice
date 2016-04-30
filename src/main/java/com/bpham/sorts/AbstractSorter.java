package com.bpham.sorts;

public abstract class AbstractSorter {
    protected static void swap(Comparable[] array, int index1, int index2) {
        Comparable temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    protected static boolean less(Comparable value1, Comparable value2) {
        return value1.compareTo(value2) == -1;
    }

    protected static boolean lessThanOrEqual(Comparable value1, Comparable value2) {
        int compareValue = value1.compareTo(value2);
        return compareValue < 0 || compareValue == 0;
    }
}
