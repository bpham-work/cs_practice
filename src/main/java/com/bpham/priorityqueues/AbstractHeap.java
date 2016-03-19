package com.bpham.priorityqueues;

import com.bpham.domain.Heap;

import java.util.Arrays;

public abstract class AbstractHeap<T extends Comparable> implements Heap<T> {
    private int MAX_SIZE = 10;

    protected T[] heap = (T[]) new Comparable[MAX_SIZE];
    protected int size = 0;

    @Override
    public T peek() {
        return heap[1];
    }

    @Override
    public T pop() {
        T valueToReturn = heap[1];
        deleteHead();
        return valueToReturn;
    }

    private void deleteHead() {
        T lastChild = heap[size];
        heap[size] = null;
        size--;
        if (size != 0) {
            heap[1] = lastChild;
            sink();
        }
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
     * Method used to move last child node upward to its
     * appropriate position in the heap
     */
    private void swim() {
        // size is also the index of the last child
        swim(size);
    }

    protected void swim(int childIndex) {
        if (childIndex < 2) {
            return;
        }

        int parentIndex = childIndex/2;
        T parentValue = heap[parentIndex];
        T value = heap[childIndex];
        if (!shouldSwap(parentValue, value)) {
            swap(parentIndex, childIndex);
        }
        swim(parentIndex);
    }

    /**
     * Method used to move head node downward to its
     * appropriate position in the heap
     */
    private void sink() {
        sink(1);
    }

    protected void sink(int index) {
        int leftChildIndex = index*2;
        int rightChildIndex = (index*2+1);
        T parentValue = heap[index];
        int childIndexToSwap = childIndexToSwap(leftChildIndex, rightChildIndex);
        if (!shouldSwap(parentValue, heap[childIndexToSwap])) {
            swap(index, childIndexToSwap);
            sink(childIndexToSwap);
        }
    }

    protected abstract int childIndexToSwap(int leftIndex, int rightIndex);

    protected abstract boolean shouldSwap(T parent, T child);

    protected void swap(int index1, int index2) {
        T value1 = heap[index1];
        T value2 = heap[index2];
        heap[index1] = value2;
        heap[index2] = value1;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Test helper methods
     *
     * These helper methods were created to make assertions on
     * the private this.heap possible
     */
    public boolean isValidHeap() {
        for (int i = 1; i <= size/2; i++) {
            int leftChildIndex = i*2;
            int rightChildIndex = (i*2+1);
            T parentValue = heap[i];
            T leftValue = heap[leftChildIndex];
            T rightValue = heap[rightChildIndex];

            if (!shouldSwap(parentValue, leftValue) ||
                    !shouldSwap(parentValue, rightValue)) {
                return false;
            }
        }
        return true;
    }

    public boolean isHeapNullAtIndex(int index) {
        return heap[index] == null;
    }
}
