package com.ivan.datastructure.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@DisplayName("Dynamic Array")
class DynamicArrayTest {

    @Test
    @DisplayName("Test AddLast")
    void addLast() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);

//        assertIterableEquals(,dynamicArray ); TODO  build a array list
    }

    @Test
    @DisplayName("test add method")
    void add() {
    }

    @Test
    @DisplayName("Test foreach ")
    void foreach() {
    }

    @Test
    void stream() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.stream().forEach(item -> System.out.println(item));
        assertIterableEquals(List.of(1,2,3),dynamicArray);
    }

}