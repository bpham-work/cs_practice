package com.bpham.datastructures.lists;

import com.bpham.datastructures.domain.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedStackTest {

    @Test
    public void pushAndPopValue() {
        Stack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2); // head

        assertEquals(2, stack.size());

        int poppedValue = stack.pop();

        assertEquals(1, stack.size());
        assertEquals(2, poppedValue);
    }
}
