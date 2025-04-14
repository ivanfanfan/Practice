package com.ivan.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {

    @Test
    void insert() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual = {4, 2, 10, 1, 6, 8, 3, 7, 9, 5};
        System.out.println("排序前：" + Arrays.toString(actual));
        System.out.println("排序后：" + Arrays.toString(InsertSort.insert(actual)));
        Assertions.assertArrayEquals(expected, InsertSort.insert(actual));
        Assertions.assertArrayEquals(expected,InsertSort.insertionRecursive(actual,1));
    }
}