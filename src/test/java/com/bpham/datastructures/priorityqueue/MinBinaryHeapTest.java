package com.bpham.datastructures.priorityqueue;

import com.bpham.datastructures.priorityqueues.MinBinaryHeap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MinBinaryHeapTest {
    private MinBinaryHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MinBinaryHeap<>();
    }

    @Test
    public void addFirstElementToHead() {
        heap.add(1);

        int result = heap.peek();

        assertEquals(1, heap.size());
        assertEquals(1, result);
        assertTrue(heap.isValidHeap());
    }

    @Test
    public void addElementToMakeNodeWithOneLeafAndMaintainMinHeap() {
        heap.add(2);
        heap.add(1);

        int result = heap.peek();

        assertEquals(2, heap.size());
        assertEquals(1, result);
        assertTrue(heap.isValidHeap());
    }

    @Test
    public void addElementToMakeNodeWithTwoLeavesAndMaintainMinHeap() {
        heap.add(2);
        heap.add(3);
        heap.add(1);

        int result = heap.peek();

        assertEquals(3, heap.size());
        assertEquals(1, result);
        assertTrue(heap.isValidHeap());
    }

    @Test
    public void addExistingElementOfSameValueToMakeNodeWithOneLeafAndMaintainMaxHeap() {
        heap.add(1);
        heap.add(1);

        int result = heap.peek();

        assertEquals(2, heap.size());
        assertEquals(1, result);
        assertTrue(heap.isValidHeap());
    }

    @Test
    public void addElementOfSameValueToMakeNodeWithTwoLeavesAndMaintainMaxHeap() {
        heap.add(1);
        heap.add(1);
        heap.add(1);

        int result = heap.peek();

        assertEquals(3, heap.size());
        assertEquals(1, result);
        assertTrue(heap.isValidHeap());
    }

    @Test
    public void addingOver10ElementsShouldResizeArrayAndNotThrowIndexOutOfBoundsException() {
        heap.add(2);
        heap.add(1);
        heap.add(2);
        heap.add(10);
        heap.add(5);
        heap.add(4);
        heap.add(2);
        heap.add(3);
        heap.add(3);
        heap.add(3);
        heap.add(3);

        int result = heap.peek();

        assertTrue(heap.isValidHeap());
        assertEquals(11, heap.size());
        assertEquals(1, result);
    }

    @Test
    public void popMaxElementWhenHeapOnlyContainsHead() {
        heap.add(2);

        int result = heap.pop();

        assertTrue(heap.isValidHeap());
        assertEquals(0, heap.size());
        assertEquals(2, result);
        assertTrue(heap.isHeapNullAtIndex(1));
    }

    @Test
    public void popMaxElementWhenHeapHasBranchNodeWithOneChildAndMaintainMinHeap() {
        heap.add(6);
        heap.add(2);

        int result = heap.pop();

        assertTrue(heap.isValidHeap());
        assertEquals(1, heap.size());
        assertEquals(2, result);
        assertTrue(heap.isHeapNullAtIndex(2));
    }

    @Test
    public void popMaxElementWhenHeapHasBranchNodeWithTwoChildrenAndMaintainMinHeap() {
        heap.add(6);
        heap.add(7);
        heap.add(2);

        int result = heap.pop();

        assertTrue(heap.isValidHeap());
        assertEquals(2, heap.size());
        assertEquals(2, result);
        assertTrue(heap.isHeapNullAtIndex(3));
    }
}
