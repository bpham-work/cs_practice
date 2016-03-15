package com.bpham.collections;

import com.bpham.domain.Node;
import com.bpham.domain.Stack;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> head;
    private int size = 0;

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> tempHead = head;
            head = newNode;
            newNode.setNext(tempHead);
        }
        size++;
    }

    @Override
    public T pop() {
        T valueToPop = head.getValue();
        Node<T> temp = head;
        head = head.next();
        temp = null;
        size--;
        return valueToPop;
    }

    @Override
    public int size() {
        return size;
    }
}
