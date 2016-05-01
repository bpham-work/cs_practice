package com.bpham.hackerrank.warmup;

public class Staircase {
    public static String createString(int numberOfHashes, int maxNumberOfHashes) {
        StringBuffer buffer = new StringBuffer();
        int numberOfSpacesToAppend = maxNumberOfHashes - numberOfHashes;

        for (int x = 0; x < numberOfSpacesToAppend; x++) {
            buffer.append(" ");
        }

        for (int x = 0; x < numberOfHashes; x++) {
            buffer.append("#");
        }
        return buffer.toString();
    }
}
