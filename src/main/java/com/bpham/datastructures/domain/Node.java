package com.bpham.datastructures.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> next() {
        return right;
    }

    public void setNext(Node<T> next) {
        right = next;
    }

    public void setPrev(Node<T> prev) {
        left = prev;
    }
}