package com.bpham.datastructures.domain;

public interface Heap<T extends Comparable> {
    T peek();
    T pop();
    void add(T value);
    int size();
}
