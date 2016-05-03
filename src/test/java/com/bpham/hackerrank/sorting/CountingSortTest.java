package com.bpham.hackerrank.sorting;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CountingSortTest {
    int[] arr = new int[100];

    @Test
    public void testOccurrences() {
        CountingSort1And2.increment(arr, 10);
        CountingSort1And2.increment(arr, 10);

        assertEquals(2, arr[10]);

        CountingSort1And2.printArray(arr);
    }

    @Test
    public void testPrintInOrder() {
        CountingSort1And2.increment(arr, 1);
        CountingSort1And2.increment(arr, 5);
        CountingSort1And2.increment(arr, 10);
        CountingSort1And2.increment(arr, 10);

        CountingSort1And2.printInOrder(arr);

    }

    @Test
    public void countingSort3() {
        CountingSort1And2.increment(arr, 0);
        CountingSort1And2.increment(arr, 1);
        CountingSort1And2.increment(arr, 1);
        CountingSort1And2.increment(arr, 2);
        CountingSort1And2.increment(arr, 2);

        CountingSort1And2.print(arr);
    }

    @Test
    public void countingSort4AddToMapTest() {
        Map<Integer, List<String>> map = new HashMap<>();

        CountingSort4.addToMap(map, 0, "ab");
        CountingSort4.addToMap(map, 0, "ef");

        assertEquals("ab", map.get(0).get(0));
        assertEquals("ef", map.get(0).get(1));
    }

    @Test
    public void countingSort4InsertionSortTest() {
        Map<Integer, List<String>> map = new HashMap<>();
        CountingSort4.addToMap(map, 2, "ab");
        CountingSort4.addToMap(map, 1, "ef");

        List<Map.Entry<Integer, List<String>>> list = CountingSort4.getSortedEntrySet(map);

        assertEquals(1, (int) list.get(0).getKey());
        assertEquals(2, (int) list.get(1).getKey());
    }

    @Test
    public void countingSort4printTest() {
        Map<Integer, List<String>> map = new HashMap<>();
        CountingSort4.addToMap(map, 2, "ab");
        CountingSort4.addToMap(map, 1, "ef");

        CountingSort4.print(map);
    }
}
