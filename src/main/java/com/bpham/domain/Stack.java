package com.bpham.domain;

public interface Stack<T> {
    void push(T value);
    T pop();
    int size();
}
