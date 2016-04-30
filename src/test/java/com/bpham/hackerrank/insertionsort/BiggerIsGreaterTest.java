package com.bpham.hackerrank.insertionsort;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiggerIsGreaterTest {

    @Test
    public void lexographTest1() {
        String string = "hefg";

        String lexographString = BiggerIsGreater.lexograph(string);

        assertEquals("hegf", lexographString);
    }

    @Test
    public void lexographTest2() {
        String string = "ab";

        String lexographString = BiggerIsGreater.lexograph(string);

        assertEquals("ba", lexographString);
    }

    @Test
    public void lexographTestNoAnswer() {
        String string = "bb";

        String lexographString = BiggerIsGreater.lexograph(string);

        assertEquals("no answer", lexographString);
    }

    @Test
    public void lexographTest4() {
        String string = "dhck";

        String lexographString = BiggerIsGreater.lexograph(string);

        assertEquals("dhkc", lexographString);
    }

    @Test
    public void lexographTest5() {
        String string = "dkhc";

        String lexographString = BiggerIsGreater.lexograph(string);

        assertEquals("hcdk", lexographString);
    }

    @Test
    public void partitionTestReverseSorted() {
        String string = "dcba";
        String[] stringArr = string.split("");

        int partitionIndex = BiggerIsGreater.partition(stringArr, 0, string.length()-1);

        assertEquals(3, partitionIndex);
    }

    @Test
    public void partitionTestSorted() {
        String string = "abcd";
        String[] stringArr = string.split("");

        int partitionIndex = BiggerIsGreater.partition(stringArr, 0, string.length()-1);

        assertEquals(0, partitionIndex);
    }

    @Test
    public void partitionTest() {
        String string = "bacd";
        String[] stringArr = string.split("");

        int partitionIndex = BiggerIsGreater.partition(stringArr, 0, string.length()-1);

        assertEquals(1, partitionIndex);
    }
}
