package com.bpham.lists;

import com.bpham.domain.DoublyLinkedList;
import com.bpham.domain.Node;

import static java.lang.String.format;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    public Node<T> getNode(int index) {
        Node<T> nodeToReturn = this.head;
        throwIndexOutOfBoundsExceptionIfNull(nodeToReturn, index);
        int counter = 0;
        while (counter < index) {
            throwIndexOutOfBoundsExceptionIfNull(nodeToReturn, index);
            nodeToReturn = nodeToReturn.next();
            counter++;
        }
        return nodeToReturn;
    }

    private void throwIndexOutOfBoundsExceptionIfNull(Node<T> nodeToReturn, int index) {
        if (nodeToReturn == null) {
            throw new IndexOutOfBoundsException(format("No element at index %d", index));
        }
    }

    public T first() {
        return head != null ? head.getValue() : null;
    }

    public T last() {
        return tail != null ? tail.getValue() : null;
    }

    public void remove(int index) {
        Node<T> node = this.head;
        throwIndexOutOfBoundsExceptionIfNull(node, index);

        if (index == 0) {
            removeHead();
            return;
        }

        int counter = 0;
        while (counter < index) {
            throwIndexOutOfBoundsExceptionIfNull(node, index);
            if ((counter + 1) == index) {
                Node<T> nodeToRemove = node.next();
                node.setNext(nodeToRemove.next());
                size--;
                return;
            }
            node = node.next();
            counter++;
        }
    }

    private void removeHead() {
        if (head != null) {
            head = head.next();
            size--;
        }
    }
}
