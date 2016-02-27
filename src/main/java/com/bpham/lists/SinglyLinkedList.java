package com.bpham.lists;

public interface SinglyLinkedList<T> {
    int size();
    void add(T value);
    T get(int index);
    T first();
    T last();
}
