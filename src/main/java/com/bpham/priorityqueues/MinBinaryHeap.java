package com.bpham.priorityqueues;

import com.bpham.domain.AbstractHeap;

public class MinBinaryHeap<T extends Comparable> extends AbstractHeap<T> {

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
            return rightIndex;
        } else {
            return leftIndex;
        }
    }

    @Override
    protected boolean shouldSwap(T parent, T child) {
        if (child == null) {
            // A parent with a null child node is still a valid heap
            return true;
        }
        int compareValue = parent.compareTo(child);
        return compareValue == -1 || compareValue == 0;
    }
}
