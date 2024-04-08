package com.ivan.datastructure.queue;


import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

//    final Object[] items;
    /**
     * Items indexs for next take, poll, peek or remove
     */
    int takeIndex;

    int putIndex;

    int count;
    List<String> linkedList = new LinkedList<>();

    


}
