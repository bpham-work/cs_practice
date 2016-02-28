package com.bpham.lists;

import com.bpham.domain.DoublyLinkedList;
import com.bpham.domain.DoublyNode;

import static java.lang.String.format;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(T value) {
        DoublyNode<T> newNode = new DoublyNode<T>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            newNode.setPrevNode(tail);
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    public DoublyNode<T> getNode(int index) {
        DoublyNode<T> nodeToReturn = this.head;
        throwIndexOutOfBoundsExceptionIfNull(nodeToReturn, index);
        int counter = 0;
        while (counter < index) {
            throwIndexOutOfBoundsExceptionIfNull(nodeToReturn, index);
            nodeToReturn = nodeToReturn.getNextNode();
            counter++;
        }
        return nodeToReturn;
    }

    private void throwIndexOutOfBoundsExceptionIfNull(DoublyNode<T> nodeToReturn, int index) {
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
        DoublyNode<T> node = this.head;
        throwIndexOutOfBoundsExceptionIfNull(node, index);

        if (index == 0) {
            removeHead();
            return;
        }

        int counter = 0;
        while (counter < index) {
            throwIndexOutOfBoundsExceptionIfNull(node, index);
            if ((counter + 1) == index) {
                DoublyNode<T> nodeToRemove = node.getNextNode();
                node.setNextNode(nodeToRemove.getNextNode());
                nullOutNode(node);
                size--;
                return;
            }
            node = node.getNextNode();
            counter++;
        }
    }

    private void removeHead() {
        if (head != null) {
            DoublyNode<T> headNode = head;
            head = head.getNextNode();
            nullOutNode(headNode);
            size--;
        }
    }

    private void nullOutNode(DoublyNode<T> node) {
        node = null;
    }

}
