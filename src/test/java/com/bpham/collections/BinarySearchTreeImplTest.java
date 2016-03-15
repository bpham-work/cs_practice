package com.bpham.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeImplTest {

    @Test
    public void addElementsToTree() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();

        tree.add(1);

        assertEquals(1, tree.size());
        assertEquals(1, (int) tree.head.value);
    }

    @Test
    public void addLowerElementToLeftOfHead() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();

        tree.add(5); // head
        tree.add(1);

        assertEquals(2, tree.size());
        assertEquals(5, (int) tree.head.value);
        assertEquals(1, (int) tree.head.left.value);
    }

    @Test
    public void addHigherElementToRightOfHead() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();

        tree.add(5); // head
        tree.add(6);

        assertEquals(2, tree.size());
        assertEquals(5, (int) tree.head.value);
        assertEquals(6, (int) tree.head.right.value);
    }

    @Test
    public void addHigherElementToRightOfRightSubtree() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();

        tree.add(5); // head
        tree.add(6); // right
        tree.add(7); // right.right

        assertEquals(3, tree.size());
        assertEquals(5, (int) tree.head.value);
        assertEquals(6, (int) tree.head.right.value);
        assertEquals(7, (int) tree.head.right.right.value);
    }

    @Test
    public void addLowerElementToLeftOfRightSubtree() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();

        tree.add(5);  // head
        tree.add(10); // right
        tree.add(7);  // right.left

        assertEquals(3, tree.size());
        assertEquals(5, (int) tree.head.value);
        assertEquals(10, (int) tree.head.right.value);
        assertEquals(7, (int) tree.head.right.left.value);
    }

    @Test
    public void addHigherElementToRightOfLeftSubtree() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();

        tree.add(10); // head
        tree.add(5);  // left
        tree.add(8);  // left.right

        assertEquals(3, tree.size());
        assertEquals(10, (int) tree.head.value);
        assertEquals(5, (int) tree.head.left.value);
        assertEquals(8, (int) tree.head.left.right.value);
    }

    @Test
    public void addLowerElementToLeftOfLeftSubtree() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();

        tree.add(10); // head
        tree.add(5);  // left
        tree.add(2);  // left.left

        assertEquals(3, tree.size());
        assertEquals(10, (int) tree.head.value);
        assertEquals(5, (int) tree.head.left.value);
        assertEquals(2, (int) tree.head.left.left.value);
    }

    @Test
    public void getValueInTree() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(5); // head
        tree.add(6); // subtree
        tree.add(7);

        int result = tree.get(6);

        assertEquals(6, result);
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionIfGettingValueNotInTree() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(5); // head
        tree.add(6); // subtree
        tree.add(7);

        int result = tree.get(1);
    }

    @Test
    public void deleteRightSubtreeNodeWithOneRightChild() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(5); // head
        tree.add(6); // right
        tree.add(7);

        tree.delete(6);

        assertEquals(5, (int) tree.head.value);
        assertEquals(7, (int) tree.head.right.value);
        assertEquals(2, tree.size());
    }

    @Test
    public void deleteRightSubtreeNodeWithOneLeftChild() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(5); // head
        tree.add(10); // right
        tree.add(9); // right.left

        tree.delete(10);

        assertEquals(5, (int) tree.head.value);
        assertEquals(9, (int) tree.head.right.value);
        assertEquals(2, tree.size());
    }

    @Test
    public void deleteLeftSubtreeNodeWithOneRightChild() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(5); // head
        tree.add(3); // left
        tree.add(4); // left.right

        tree.delete(3);

        assertEquals(5, (int) tree.head.value);
        assertEquals(4, (int) tree.head.left.value);
        assertEquals(2, tree.size());
    }

    @Test
    public void deleteLeftSubtreeNodeWithOneLeftChild() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(5); // head
        tree.add(3); // left
        tree.add(2); // left.left

        tree.delete(3);

        assertEquals(5, (int) tree.head.value);
        assertEquals(2, (int) tree.head.left.value);
        assertEquals(2, tree.size());
    }

    @Test
    public void deleteRightSubtreeNodeWithTwoChildrenAndItsChildrenHaveChildren() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(5);  // head
        tree.add(20); // right
        tree.add(10); // right.left
        tree.add(30); // right.right
        tree.add(29); // right.right.left smallest in right subtree of deleted node should be successor
        tree.add(31); // right.right.right

        tree.delete(20);

        assertEquals(5, (int) tree.head.value);
        assertEquals(29, (int) tree.head.right.value);
        assertEquals(10, (int) tree.head.right.left.value);
        assertEquals(30, (int) tree.head.right.right.value);
        assertEquals(31, (int) tree.head.right.right.right.value);
        assertEquals(null, tree.head.right.right.left);
        assertEquals(5, tree.size());
    }

    @Test
    public void deleteLeftSubtreeNodeWithTwoChildren() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(20); // head
        tree.add(15); // left
        tree.add(10); // left.left
        tree.add(18); // left.right

        tree.delete(15);

        assertEquals(20, (int) tree.head.value);
        assertEquals(18, (int) tree.head.left.value);
        assertEquals(10, (int) tree.head.left.left.value);
        assertEquals(3, tree.size());
    }

    @Test
    public void deleteLeftSubtreeNodeWithTwoChildrenAndItsChildrenHaveChildren() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();
        tree.add(20); // head
        tree.add(15); // left
        tree.add(10); // left.left
        tree.add(18); // left.right
        tree.add(17); // left.right.left
        tree.add(19); // left.right.right

        tree.delete(15); // 17 will be successor after deletion

        assertEquals(20, (int) tree.head.value);
        assertEquals(17, (int) tree.head.left.value);
        assertEquals(10, (int) tree.head.left.left.value);
        assertEquals(18, (int) tree.head.left.right.value);
        assertEquals(19, (int) tree.head.left.right.right.value);
        assertEquals(null, tree.head.left.right.left);
        assertEquals(5, tree.size());
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionIfDeletingValueNotInTree() {
        BinarySearchTreeImpl<Integer> tree = new BinarySearchTreeImpl<>();

        tree.delete(1);
    }
}
