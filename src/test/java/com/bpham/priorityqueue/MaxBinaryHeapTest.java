package com.bpham.priorityqueue;

import com.bpham.priorityqueues.MaxBinaryHeap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxBinaryHeapTest {
    private MaxBinaryHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MaxBinaryHeap<>();
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
    public void addElementToMakeNodeWithOneLeafAndMaintainMaxHeap() {
        heap.add(1);
        heap.add(2);

        int result = heap.peek();

        assertEquals(2, heap.size());
        assertEquals(2, result);
        assertTrue(heap.isValidHeap());
    }

    @Test
    public void addElementToMakeNodeWithTwoLeavesAndMaintainMaxHeap() {
        heap.add(1);
        heap.add(2);
        heap.add(3);

        int result = heap.peek();

        assertEquals(3, heap.size());
        assertEquals(3, result);
        assertTrue(heap.isValidHeap());
    }

    @Test
    public void addElementOfSameValueToMakeNodeWithOneLeafAndMaintainMaxHeap() {
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
        assertEquals(10, result);
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
    public void popMaxElementWhenHeapHasBranchNodeWithOneChildAndMaintainMaxHeap() {
        heap.add(2);
        heap.add(6);

        int result = heap.pop();

        assertTrue(heap.isValidHeap());
        assertEquals(1, heap.size());
        assertEquals(6, result);
        assertTrue(heap.isHeapNullAtIndex(2));
    }

    @Test
    public void popMaxElementWhenHeapHasBranchNodeWithTwoChildrenAndMaintainMaxHeap() {
        heap.add(2);
        heap.add(6);
        heap.add(7);

        int result = heap.pop();

        assertTrue(heap.isValidHeap());
        assertEquals(2, heap.size());
        assertEquals(7, result);
        assertTrue(heap.isHeapNullAtIndex(3));
    }

    @Test
    public void popMaxElementWhenHeapHasBranchNodeWithOneChildOfSameValueAndMaintainMaxHeap() {
        heap.add(1);
        heap.add(1);

        int result = heap.pop();

        assertTrue(heap.isValidHeap());
        assertEquals(1, heap.size());
        assertEquals(1, result);
        assertTrue(heap.isHeapNullAtIndex(2));
    }

    @Test
    public void popMaxElementWhenHeapHasBranchNodeWithTwoChildrenOfSameValueAndMaintainMaxHeap() {
        heap.add(1);
        heap.add(1);
        heap.add(1);

        int result = heap.pop();

        assertTrue(heap.isValidHeap());
        assertEquals(2, heap.size());
        assertEquals(1, result);
        assertTrue(heap.isHeapNullAtIndex(3));
    }
}
