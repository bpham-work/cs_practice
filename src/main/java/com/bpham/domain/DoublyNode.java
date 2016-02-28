package com.bpham.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoublyNode<T>{
    private T value;
    private DoublyNode<T> prevNode;
    private DoublyNode<T> nextNode;

    public DoublyNode(T value) {
        this.value = value;
    }

    public DoublyNode(T value, DoublyNode<T> prevNode) {
        this.value = value;
        this.prevNode = prevNode;
    }
}
