package com.bpham.lists;

import lombok.Getter;

@Getter
public class SinglyNode<T> {
    private SinglyNode<T> nextNode;
    private final T data;

    public SinglyNode(SinglyNode<T> nextNode, T data) {
        this.nextNode = nextNode;
        this.data = data;
    }
}
