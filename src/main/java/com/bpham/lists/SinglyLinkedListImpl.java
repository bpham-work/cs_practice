package com.bpham.lists;

import static java.lang.String.format;

public class SinglyLinkedListImpl<T> implements SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }  else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node<T> nodeToReturn = this.head;
        throwIndexOutOfBoundsExceptionIfNull(nodeToReturn, index);
        int counter = 0;
        while(counter < index) {
            throwIndexOutOfBoundsExceptionIfNull(nodeToReturn, index);
            nodeToReturn = nodeToReturn.nextNode;
            counter++;
        }
        return nodeToReturn.value;
    }

    public T first() {
        if (head != null) {
            return head.getValue();
        }
        return null;
    }

    public T last() {
        return tail != null ? tail.value : null;
    }

    private void throwIndexOutOfBoundsExceptionIfNull(Node<T> nodeToReturn, int index) {
        if (nodeToReturn == null) {
            throw new IndexOutOfBoundsException(format("No element at index %d", index));
        }
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        Node<T> nextNode;
        final T value;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() { return value; }
    }
}
