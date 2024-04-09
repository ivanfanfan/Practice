package com.ivan.datastructure.linkedlist;

public class SinglyLinkedList {

    private int capacity;
    private Node head;

    private int size;
    public SinglyLinkedList(int capacity) {

        this.capacity = capacity;
    }
    public Node findByIndex(int index) {
        if(head == null) {
            return null;
        }
        int i = 0;
        for(Node p = head; p!= null; p = p.next, i++){
            if(i == index)
                return p;
        }
        return null;
    }
    public boolean remove(int index){
        Node removed = findByIndex(index);
        if(removed == null){
            return false;
        }
        Node pre = findByIndex(index - 1);
        if(pre != null) {
            pre.next = pre.next.next;
        }
        return true;

    }
    public boolean add(int value) {
        if (isFull()){
            return false;
        }
        Node last = findLast();
        if(last == null){
            head = new Node(value, null);
        } else {
            last.next = new Node(value, null);
        }
        size++;
        return true;

    }

    private Node findLast() {
        Node p = head;
        if(p == null){
            return null;
        }
        while(p.next != null) {
            p = p.next;
        }
        return p;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
