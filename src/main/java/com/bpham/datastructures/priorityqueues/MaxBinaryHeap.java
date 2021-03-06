package com.bpham.datastructures.priorityqueues;

public class MaxBinaryHeap<T extends Comparable> extends AbstractHeap<T> {

    @Override
    protected int childIndexToSwap(int leftIndex, int rightIndex) {
        T leftValue = super.heap[leftIndex];
        T rightValue = super.heap[rightIndex];

        // Check if parent node has 2 children
        if (rightValue == null) {
            return leftIndex;
        }
        int compare = leftValue.compareTo(rightValue);
        if (compare == 1) {
            return leftIndex;
        } else {
            return rightIndex;
        }
    }

    @Override
    protected boolean shouldSwap(T parent, T child) {
        if (child == null) {
            // A parent with a null child node is still a valid heap
            return true;
        }
        int compareValue = parent.compareTo(child);
        return compareValue == 1 || compareValue == 0;
    }
}
