package com.bpham.sorts;

public class MergeSort extends AbstractSorter {

    public static void sort(Comparable[] array) {
        Comparable[] auxArray = new Comparable[array.length];
        sort(array, auxArray, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, Comparable[] auxArray, int low, int hi) {
        if (low == hi) {
            return;
        }

        int mid = (low + hi) / 2;
        sort(array, auxArray, low, mid);
        sort(array, auxArray, mid + 1, hi);
        merge(array, auxArray, low, hi);
    }

    public static void merge(Comparable[] array, Comparable[] auxArray, int low, int hi) {
        for (int x = low; x <= hi; x++) {
            auxArray[x] = array[x];
        }
        int mid = (low + hi) / 2;
        int rightPointer = mid + 1;
        int leftPointer = low;
        for (int x = low; x <= hi; x++) {
            if (rightPointer > hi) {
                array[x] = auxArray[leftPointer];
                leftPointer++;
            } else if (leftPointer > mid) {
                array[x] = auxArray[rightPointer];
                rightPointer++;
            } else if (less(auxArray[leftPointer], auxArray[rightPointer])) {
                array[x] = auxArray[leftPointer];
                leftPointer++;
            } else {
                array[x] = auxArray[rightPointer];
                rightPointer++;
            }
        }
    }
}
