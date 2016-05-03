package com.bpham.hackerrank.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountingSort4 {

    public static void addToMap(Map<Integer, List<String>> map, int key, String value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    public static void print(Map<Integer, List<String>> map) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<Integer, List<String>>> sortedList = getSortedEntrySet(map);
        for (Map.Entry<Integer, List<String>> entry : sortedList) {
            for (String stringFragment : entry.getValue()) {
                stringBuilder
                        .append(stringFragment)
                        .append(" ");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static List<Map.Entry<Integer, List<String>>> getSortedEntrySet(Map<Integer, List<String>> map) {
        Set<Map.Entry<Integer, List<String>>> entrySet = map.entrySet();
        List<Map.Entry<Integer, List<String>>> list = new ArrayList<>(entrySet);
        insertionSort(list);
        return list;
    }

    public static void insertionSort(List<Map.Entry<Integer, List<String>>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int k = i; k > 0; k--) {
                if (list.get(k).getKey() < list.get(k-1).getKey()) {
                    swap(list, k, k-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(List<Map.Entry<Integer, List<String>>> list, int index1, int index2) {
        Map.Entry<Integer, List<String>> temp1 = list.remove(index1);
        Map.Entry<Integer, List<String>> temp2 = list.remove(index2);
        list.add(index1, temp2);
        list.add(index2, temp1);
    }
}
