package com.bpham.domain;

public interface DoublyLinkedList<T> {
    int size();
    void add(T value);
    T get(int index);
    DoublyNode<T> getNode(int index);
    T first();
    T last();
    void remove(int index);
}
