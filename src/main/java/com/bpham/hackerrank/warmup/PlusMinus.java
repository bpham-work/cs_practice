package com.bpham.hackerrank.warmup;

import java.util.Scanner;

public class PlusMinus {
    static Scanner in = new Scanner(System.in);
    static int total;
    static float posTotal = 0;
    static float negTotal = 0;
    static float zeroTotal = 0;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        total = Integer.parseInt(in.next());

        while (in.hasNext()) {
            int integer = Integer.parseInt(in.next());
            incrementCounters(integer);
        }

        printFraction(posTotal);
        printFraction(negTotal);
        printFraction(zeroTotal);
    }

    private static void incrementCounters(int integer) {
        if (isZero(integer)) {
            zeroTotal++;
        } else if (isPositive(integer)) {
            posTotal++;
        } else {
            negTotal++;
        }
    }

    private static boolean isPositive(int value) {
        return value > 0;
    }

    private static boolean isZero(int value) {
        return value == 0;
    }

    private static void printFraction(float value) {
        System.out.println(value / total);
    }
}
