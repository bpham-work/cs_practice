package com.bpham.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedQueueTest {

    @Test
    public void enqueueValueAsHead() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(1);

        assertEquals(1, queue.size());
        assertEquals(1, (int) queue.head.getValue());
    }

    @Test
    public void enqueueValueMoreThanOneValue() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.size());
        assertEquals(1, (int) queue.head.getValue());
        assertEquals(2, (int) queue.head.next().getValue());
    }

    @Test
    public void dequeueValue() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        int result = queue.dequeue();

        assertEquals(1, queue.size());
        assertEquals(1, result);

        int result2 = queue.dequeue();

        assertEquals(0, queue.size());
        assertEquals(2, result2);
        assertNull(queue.head);
        assertNull(queue.tail);
    }
}
