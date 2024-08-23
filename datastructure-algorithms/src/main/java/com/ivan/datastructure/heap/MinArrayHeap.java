package com.ivan.datastructure.heap;

import java.util.Arrays;

public class MinArrayHeap implements Heap {

    private final int[] array;
    private int size;
    private int capacity;

    public MinArrayHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public MinArrayHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapfiy();
    }

    private void heapfiy() {
        int lastNoLeafIndex = (size - 1) / 2;
        for (int i = lastNoLeafIndex; i >= 0; i--) {
            down(i);
        }
    }

    @Override
    public int peek() {
        if (!isEmpty()) {
            return array[0];
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public void down(int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = leftIndex + 1;
        int minIndex = index;
        if (leftIndex < size) {
            if (array[index] > array[leftIndex]) {
                minIndex = leftIndex;
            }
            if (rightIndex < size && array[index] > array[rightIndex]) {
                minIndex = rightIndex;
            }
        }
        if (minIndex != index) {
            swap(minIndex, index);
            down(minIndex);
        }
    }

    @Override
    public void up(int index) {
        int parentIndex = (index - 1) / 2;
        if (parentIndex > 0 && array[parentIndex] > array[index]) {
            swap(parentIndex, index);
            up(parentIndex);
        }
    }

    void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void insert(int value) {
        array[size] = value;
        size++;
        up(size - 1);
    }

    @Override
    public int remove(int index) {
        if(index != size-1){
            swap(index, size-1);
        }
        int remove = array[size -1];
        size--;
        down(index);
        return remove;
    }

    @Override
    public void clear() {

    }



    public static void main(String[] args) {
        int[] array = {11, 23, 23, 54, 25, 16, 17, 48, 59, 10};
        MinArrayHeap heap = new MinArrayHeap(array);
        System.out.println(Arrays.toString(heap.array));
    }
}
