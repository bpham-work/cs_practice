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
    public void highestElementShouldBeAtHead() {
        heap.add(2);
        heap.add(1);

        int result = heap.peek();

        assertEquals(2, heap.size());
        assertEquals(2, result);
        assertTrue(heap.isValidHeap());
    }

    @Test
    public void highestElementShouldBeAtHead2() {
        heap.add(2);
        heap.add(1);
        heap.add(2);
        heap.add(10);
        heap.add(5);
        heap.add(4);
        heap.add(2);
        heap.add(3);

        int result = heap.peek();

        assertTrue(heap.isValidHeap());
        assertEquals(8, heap.size());
        assertEquals(10, result);
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
}
