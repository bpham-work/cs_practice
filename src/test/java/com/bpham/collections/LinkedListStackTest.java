package com.bpham.collections;

import com.bpham.domain.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListStackTest {

    @Test
    public void pushAndPopValue() {
        Stack<Integer> stack = new LinkedListStack<>();

        stack.push(1);
        stack.push(2); // head

        assertEquals(2, stack.size());

        int poppedValue = stack.pop();

        assertEquals(1, stack.size());
        assertEquals(2, poppedValue);
    }
}
