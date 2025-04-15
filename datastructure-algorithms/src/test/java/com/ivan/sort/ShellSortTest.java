package com.ivan.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    @Test
    void shell() {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        ShellSort.shell(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }
}