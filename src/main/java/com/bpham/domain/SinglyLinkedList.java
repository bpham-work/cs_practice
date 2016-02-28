package com.bpham.domain;

public interface SinglyLinkedList<T> {
    int size();
    void add(T value);
    T get(int index);
    T first();
    T last();
    void remove(int index);
}
