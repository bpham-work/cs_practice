package com.bpham.hackerrank.sorting;

public class CountingSort1And2 {

    public static void increment(int[] arr, int value) {
        arr[value] = ++arr[value];
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printInOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i]; k++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void print(int[] arr) {
        int i = 0;
        int value = 0;
//        for (i = 0; i < arr.length; i++) {
//            value += arr[i];
//            System.out.print(value + " ");
//        }

        while (i <= arr.length-1) {
            value += arr[i];
            System.out.print(value + " ");
            i++;
        }

        while (i < 100) {
            System.out.print(value + " ");
            i++;
        }
    }
}
