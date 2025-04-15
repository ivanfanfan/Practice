package com.ivan.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectSortTest {

    @Test
    void select() {
        int[] arr = {1, 3, 2, 5, 4};
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, SelectSort.select(arr));
    }
}