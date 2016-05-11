package com.bpham.hackerrank.sorting;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndPairs {

    public static Map<Long, Long> createMapOfCounts(int[] array) {
        Map<Long, Long> map = new HashMap<>();
        for (long value : array) {
            if (!map.containsKey(value)) {
                map.put(value, 0l);
            }
            map.put(value, map.get(value)+1);
        }
        return map;
    }

    public static long calculatePairs(int[] array) {
        Map<Long, Long> mapOfCounts = createMapOfCounts(array);
        long count = 0;
        for (Map.Entry<Long, Long> entry : mapOfCounts.entrySet()) {
            Long val =  entry.getValue();
            if (val > 1) {
                count += (val * (val - 1));
            }
        }
        return count;
    }
}
