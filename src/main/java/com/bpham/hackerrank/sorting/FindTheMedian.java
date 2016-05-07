package com.bpham.hackerrank.sorting;

public class FindTheMedian {

    public static int findMedianValue(int[] array) {
        int medianIndex = findMedianIndex(array);
        return array[medianIndex];
    }

    public static int findMedianIndex(int[] array) {
        return findMedianIndex(array, 0, array.length-1);
    }

    public static int findMedianIndex(int[] array, int lo, int hi) {
        if (lo >= hi) return lo;
        int medianIndex = array.length/2;
        int partitionIndex = partition(array, lo, hi);
        if (partitionIndex == medianIndex) {
            // Return index if array has been partitioned around median element
            return partitionIndex;
        }
        int leftPartitionIndex = findMedianIndex(array, lo, partitionIndex-1);
        if (leftPartitionIndex == medianIndex) {
            // Return if left partition index is found to be median index
            return leftPartitionIndex;
        }
        int rightPartitionIndex = findMedianIndex(array, partitionIndex+1, hi);
        if (rightPartitionIndex == medianIndex) {
            // Return if right partition index is found to be median index
            return rightPartitionIndex;
        }
        return lo;
    }

    public static int partition(int[] array, int lo, int hi) {
        int left = lo;
        int right = hi;
        int partitionElem = array[lo];
        while (true) {
            while (array[left] <= partitionElem && left < hi) {
                left++;
            }

            while (array[right] > partitionElem) {
                right--;
            }

            if (left >= right) {
                break;
            }
            swap(array, left, right);
        }
        swap(array, lo, right);
        return right;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
