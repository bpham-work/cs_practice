package com.bpham.domain;

public interface MaxHeap<T extends Comparable> {
    T peek();
    T pop();
    void add(T value);
    int size();
}
