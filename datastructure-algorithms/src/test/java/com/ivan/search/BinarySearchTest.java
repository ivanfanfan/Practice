package com.ivan.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void search() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, BinarySearch.search(a, 1));
        assertEquals(1, BinarySearch.search(a, 2));
        assertEquals(2, BinarySearch.search(a, 3));
        assertEquals(3, BinarySearch.search(a, 4));
        assertEquals(4, BinarySearch.search(a, 5));
        assertNotEquals(-2, BinarySearch.search(a, 11));
    }
}