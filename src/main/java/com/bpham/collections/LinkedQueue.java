package com.bpham.collections;

import com.bpham.domain.Node;
import com.bpham.domain.Queue;

public class LinkedQueue<T> implements Queue<T> {
    public Node<T> head;
    public Node<T> tail;
    private int size;

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node<T> temp = tail;
            temp.setRight(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        T valueToReturn = head.getValue();
        size--;
        head = head.next();
        nullOutTailIfDequeueLastNode();
        return valueToReturn;
    }

    private void nullOutTailIfDequeueLastNode() {
        if (size == 0) {
            tail = null;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
