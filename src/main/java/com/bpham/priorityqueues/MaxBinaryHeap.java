package com.bpham.priorityqueues;

import com.bpham.domain.MaxHeap;

import java.util.Arrays;

public class MaxBinaryHeap<T extends Comparable> implements MaxHeap<T> {
    private int MAX_SIZE = 10;

    public T[] heap = (T[]) new Comparable[MAX_SIZE];
    private int size = 0;

    @Override
    public T peek() {
        return heap[1];
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public void add(T value) {
        size++;
        heap[size] = value;
        swim();
        if (size == MAX_SIZE-1) {
            increaseArraySize();
        }
    }

    private void increaseArraySize() {
        MAX_SIZE *= MAX_SIZE;
        heap = Arrays.copyOf(heap, MAX_SIZE);
    }

    /**
     * Method used to move last node upward to its appropriate position in the heap
     */
    private void swim() {
        // size is also the index of the last child
        swim(size);
    }

    private void swim(int childIndex) {
        if (childIndex < 2) {
            return;
        }

        int parentIndex = childIndex/2;
        T parentValue = heap[childIndex/2];
        T value = heap[childIndex];
        if (!isChildLTEToParent(parentValue, value)) {
            swap(parentIndex, childIndex);
        }
        swim(parentIndex);
    }

    private void swap(int index1, int index2) {
        T value1 = heap[index1];
        T value2 = heap[index2];
        heap[index1] = value2;
        heap[index2] = value1;
    }

    public boolean isValidHeap() {
        for (int i = 1; i <= size/2; i++) {
            int leftChildIndex = i*2;
            int rightChildIndex = (i*2+1);
            T parentValue = heap[i];
            T leftValue = heap[leftChildIndex];
            T rightValue = heap[rightChildIndex];

            if (!isChildLTEToParent(parentValue, leftValue) ||
                    !isChildLTEToParent(parentValue, rightValue)) {
                return false;
            }
        }
        return true;
    }

    private boolean isChildLTEToParent(T parent, T child) {
        if (child == null) {
            // A parent with a null child node is still a valid heap
            return true;
        }
        int compareValue = parent.compareTo(child);
        return compareValue == 1 || compareValue == 0;
    }

    @Override
    public void delete() {

    }

    @Override
    public int size() {
        return size;
    }
}
