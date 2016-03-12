package com.bpham.lists;

import com.bpham.domain.BinarySearchTree;

import static java.lang.String.format;

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {
    public Node head;
    private int size = 0;

    public void add(T value) {
        head = add(head, value);
        size++;
    }

    private Node add(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }
        int compareResult = value.compareTo(node.value);
        if (compareResult < 0) {
            node.left = add(node.left, value);
        } else if (compareResult > 0) {
            node.right = add(node.right, value);
        }
        return node;
    }

    public T get(T value) {
        return get(head, value);
    }

    private T get(Node node, T value) {
        if (node == null) {
            throw new RuntimeException(format("Value %s not in tree", value));
        }
        int compareResult = value.compareTo(node.value);
        if (compareResult < 0) {
            return get(node.left, value);
        } else if (compareResult > 0) {
            return get(node.right, value);
        } else {
            return value;
        }
    }

    public void delete(T value) {
        head = delete(head, value);
        size--;
    }

    public Node delete(Node node, T value) {
        if (node == null) {
            throw new RuntimeException(format("Value %s not in tree", value));
        }

        int compareResult = value.compareTo(node.value);
        if (compareResult < 0) {
            node.left = delete(node.left, value);
        } else if (compareResult > 0) {
            node.right = delete(node.right, value);
        } else {
            // Found node to delete
            if (node.left != null && node.right != null) {
                // Node to delete has both right and left child
                // Find smallest node in right subtree to be successor
                Node minRight = findMin(node.right);

                delete(head, minRight.value);

                // Successor takes left subtree of original node
                minRight.left = node.left;

                // Successor takes right subtree of original node
                minRight.right = node.right;

                return minRight;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                node = null;
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public int size() {
        return size;
    }

    public class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }
    }
}
