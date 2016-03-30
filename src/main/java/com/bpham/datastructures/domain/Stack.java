package com.bpham.datastructures.domain;

public interface Stack<T> {
    void push(T value);
    T pop();
    int size();
}
