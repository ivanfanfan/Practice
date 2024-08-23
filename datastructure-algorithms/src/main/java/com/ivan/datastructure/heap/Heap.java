package com.ivan.datastructure.heap;

public interface Heap {

    int peek();

    boolean isEmpty();

    boolean isFull();
    int size();

    void down(int index);

    void up(int index);

    void insert(int value);

    int remove(int index);

    void clear();

}
