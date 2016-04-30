package com.bpham.hackerrank.insertionsort;

public class BiggerIsGreater {

    public static String lexograph(String string) {
        String[] stringArr = string.split("");
        int hi = stringArr.length - 1;
        int i;
        int toSwap = hi;
        for (i = hi; i >= 0; i--) {
            // Find i's position in right sub array
            int partitionIndex = partition(stringArr, i);
            if (partitionIndex != hi) {
                if (!stringArr[partitionIndex+1].equals(stringArr[partitionIndex])) {
                    return "no answer";
                }
                // If i's position has greater elements after it, swap with the next greatest elem
                toSwap = partitionIndex+1;
                break;
            }
        }
        char[] c = string.toCharArray();
        swap(c, i, toSwap);
        return new String(c);
    }

    public static int partition(String[] stringArr, int lo) {
        if (lo >= stringArr.length-1) return stringArr.length-1;
        int partitionIndex = partition(stringArr, lo, stringArr.length-1);

        // Recursively sort subarrays to the right
        partition(stringArr, partitionIndex + 1);

        return partitionIndex;
    }

    public static int partition(String[] stringArr, int lo, int hi) {
        String partitionElem = stringArr[lo];
        int left = lo;
        int right = hi;
        while(true) {
            while (left <= hi) {
                if (stringArr[left].compareTo(partitionElem) > 0) {
                    break;
                }
                left++;
            }

            while (right > lo) {
                if (stringArr[right].compareTo(partitionElem) < 0) {
                    break;
                }
                right--;
            }

            if (left > right) {
                break;
            }

            swap(stringArr, left, right);
        }
        swap(stringArr, lo, right);
        return right;
    }

    private static void swap(String[] stringArr, int index1, int index2) {
        String temp = stringArr[index1];
        stringArr[index1] = stringArr[index2];
        stringArr[index2] = temp;
    }

    private static void swap(char[] stringArr, int index1, int index2) {
        char temp = stringArr[index1];
        stringArr[index1] = stringArr[index2];
        stringArr[index2] = temp;
    }
}
