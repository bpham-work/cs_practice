package com.bpham.domain;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    int size();
}
