package com.ivan.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void bubble() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] arr = {3, 2, 4, 1, 5};
        Assertions.assertArrayEquals(expected, BubbleSort.bubble(arr));
        Assertions.assertArrayEquals(expected, BubbleSort.bubbleRecursive(arr,arr.length-1));

    }

    @Test
    void bubbleRecursive() {
    }
}