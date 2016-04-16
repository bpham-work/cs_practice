package com.bpham.sorts;

public class QuickSort extends AbstractSorter {

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(Comparable[] array, int low, int hi) {
        if (low >= hi) {
            return;
        }
        int partitionIndex = partition(array, low, hi);
        sort(array, low, partitionIndex - 1);
        sort(array, partitionIndex + 1, hi);
    }

    public static int partition(Comparable[] array, int low, int hi) {
        Comparable partitionElem = array[low];

        int leftPointer = low;
        int rightPointer = hi;

        while (true) {
            // Find left elem greater than partition elem
            while (leftPointer <= hi) {
                if (lessThanOrEqual(array[leftPointer], partitionElem)) {
                    leftPointer++;
                } else {
                    break;
                }
            }
            // Find right elem lesser than partition elem
            while (rightPointer > low) {
                if (lessThanOrEqual(partitionElem, array[rightPointer])) {
                    rightPointer--;
                } else {
                    break;
                }
            }

            // End if pointers cross
            if (leftPointer >= rightPointer) {
                break;
            }

            // Swap
            swap(array, leftPointer, rightPointer);
        }

        // Move partition index into position where greater elems are to the right
        // and lesser elems are to left
        swap(array, low, rightPointer);

        // Return ending position of partition elem
        return rightPointer;
    }
}
