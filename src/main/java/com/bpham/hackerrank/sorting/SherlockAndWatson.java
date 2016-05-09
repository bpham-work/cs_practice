package com.bpham.hackerrank.sorting;

public class SherlockAndWatson {

    public static void rotate(int[] array, int[] auxArray, int numberOfRotations) {
        for (int i = 0; i < numberOfRotations; i++) {
            rotate(array, auxArray);
        }
    }

    public static void rotate(int[] array, int[] auxArray) {
        int lastElement = array[array.length-1];
        shiftRightFromIndex(array, auxArray, 0);
        array[0] = lastElement;
    }

    public static void shiftRightFromIndex(int[] array, int[] auxArray, int indexToShiftFrom) {
        copyIntoAuxArray(array, auxArray);
        for (int i = indexToShiftFrom + 1; i < array.length; i++) {
            array[i] = auxArray[i-1];
        }
    }

    public static void copyIntoAuxArray(int[] mainArray, int[] auxArray) {
        for (int i = 0; i < mainArray.length; i++) {
            auxArray[i] = mainArray[i];
        }
    }

    public static int getPreRotationIndex(int endingIndex, int rotations, int arrayLength) {
        if (rotations > arrayLength) {
            rotations = rotations % arrayLength;
        }
        int difference = endingIndex - rotations;
        return difference < 0 ? difference + arrayLength : difference;
    }
}
