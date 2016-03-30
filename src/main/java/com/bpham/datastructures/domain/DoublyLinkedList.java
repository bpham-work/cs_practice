package com.bpham.datastructures.domain;

public interface DoublyLinkedList<T> {
    int size();
    void add(T value);
    T get(int index);
    Node<T> getNode(int index);
    T first();
    T last();
    void remove(int index);
}
