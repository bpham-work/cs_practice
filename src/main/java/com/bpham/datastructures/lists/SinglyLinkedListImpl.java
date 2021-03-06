package com.bpham.datastructures.lists;

import com.bpham.datastructures.domain.Node;
import com.bpham.datastructures.domain.SinglyLinkedList;

import static java.lang.String.format;

public class SinglyLinkedListImpl<T> implements SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }  else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node<T> nodeToReturn = this.head;
        throwIndexOutOfBoundsExceptionIfNull(nodeToReturn, index);
        int counter = 0;
        while (counter < index) {
            throwIndexOutOfBoundsExceptionIfNull(nodeToReturn, index);
            nodeToReturn = nodeToReturn.next();
            counter++;
        }
        return nodeToReturn.getValue();
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

    private void throwIndexOutOfBoundsExceptionIfNull(Node<T> nodeToReturn, int index) {
        if (nodeToReturn == null) {
            throw new IndexOutOfBoundsException(format("No element at index %d", index));
        }
    }

    public int size() {
        return size;
    }
}
