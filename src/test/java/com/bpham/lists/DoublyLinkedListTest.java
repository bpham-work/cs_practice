package com.bpham.lists;

import com.bpham.domain.DoublyLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DoublyLinkedListTest {

    @Test
    public void addingOneNodeShouldIncrementSize() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        list.add(1);

        assertEquals(1, list.size());
        assertEquals(1, (int) list.get(0));
    }

    @Test
    public void addingMultipleNodeShouldIncrementSize() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }

    @Test
    public void returnSizeOfList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(1);

        int result = list.size();

        assertEquals(1, result);
    }

    @Test
    public void returnSize0WhenNothingInList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        int result = list.size();

        assertEquals(0, result);
    }

    @Test
    public void getValueAtIndex0() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(5);

        int result = list.get(0);

        assertEquals(5, result);
    }

    @Test
    public void getValueAtIndex1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);

        int result = list.get(1);

        assertEquals(4, result);
    }

    @Test
    public void getValueAtIndex2() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        int result = list.get(2);

        assertEquals(3, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsExceptionWhenGetByInvalidIndex1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsExceptionWhenGetByInvalidIndex0() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        list.get(0);
    }

    @Test
    public void getFirstValueIfListHasElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        int result = list.first();

        assertEquals(5, result);
    }

    @Test
    public void getNullFirstValueIfListHasNoElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        Integer result = list.first();

        assertNull(result);
    }

    @Test
    public void getLastValueIfListHasElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        int result = list.last();

        assertEquals(3, result);
    }

    @Test
    public void getNullLastValueIfListHasNoElements() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        Integer result = list.last();

        assertNull(result);
    }

    @Test
    public void removeElementAtIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        list.remove(1);

        assertEquals(5, (int) list.get(0));
        assertEquals(3, (int) list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void removeHeadElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        list.remove(0);

        assertEquals(4, (int) list.get(0));
        assertEquals(3, (int) list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void removeTailElement() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);

        list.remove(2);

        assertEquals(5, (int) list.get(0));
        assertEquals(4, (int) list.get(1));
        assertEquals(2, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsExceptionWhenRemoveInvalidIndex0() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        list.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsExceptionWhenRemoveInvalidIndex1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<Integer>();

        list.remove(1);
    }
}
