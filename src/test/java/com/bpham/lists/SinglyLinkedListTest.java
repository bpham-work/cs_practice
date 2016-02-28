package com.bpham.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SinglyLinkedListTest {

    @Test
    public void returnSizeOfList() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();
        list.add(1);

        int result = list.size();

        assertEquals(1, result);
    }

    @Test
    public void returnSize0WhenNothingInList() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();

        int result = list.size();

        assertEquals(0, result);
    }

    @Test
    public void getValueAtIndex0() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();
        list.add(5);

        int result = list.get(0);

        assertEquals(5, result);
    }

    @Test
    public void getValueAtIndex1() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);

        int result = list.get(1);

        assertEquals(4, result);
    }

    @Test
    public void getValueAtIndex2() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        int result = list.get(2);

        assertEquals(3, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsExceptionWhenGetByInvalidIndex1() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();

        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsExceptionWhenGetByInvalidIndex0() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();

        list.get(0);
    }

    @Test
    public void getFirstValueIfListHasElements() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        int result = list.first();

        assertEquals(5, result);
    }

    @Test
    public void getNullFirstValueIfListHasNoElements() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();

        Integer result = list.first();

        assertNull(result);
    }

    @Test
    public void getLastValueIfListHasElements() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        int result = list.last();

        assertEquals(3, result);
    }

    @Test
    public void getNullLastValueIfListHasNoElements() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();

        Integer result = list.last();

        assertNull(result);
    }

    @Test
    public void removeElementAtIndex() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        list.remove(1);

        assertEquals(5, (int) list.get(0));
        assertEquals(3, (int) list.get(1));
    }

    @Test
    public void removeHeadElement() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        list.remove(0);

        assertEquals(4, (int) list.get(0));
        assertEquals(3, (int) list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsExceptionWhenRemoveInvalidIndex0() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();

        list.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsExceptionWhenRemoveInvalidIndex1() {
        SinglyLinkedList<Integer> list = new SinglyLinkedListImpl<Integer>();

        list.remove(1);
    }
}
