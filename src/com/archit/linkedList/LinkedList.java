package com.archit.linkedList;

/**
 * Created by Archit Saxena
 * Date: 08/07/25
 * Time: 1:45 am
 * Tekion Corp. © 2025
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public class Node {
        private int num;
        private Node next;

        public Node(int num) {
            this.num = num;
        }

        public Node(int num, Node next) {
            this.num = num;
            this.next = next;
        }
    }

    public void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            newNode.next = head;
            head = newNode;
            tail = head;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertIndex(int val, int index) {
        if (head == null) {
            insertFirst(val);
        }
        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public int deleteFirst() {
        if (head == null)
            return 0;
        int val = head.num;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return val;
    }

    public int deleteLast() {
        if (head == null)
            return 0;
        Node temp = head;
        int val = tail.num;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.num);
            temp = temp.next;
        }
    }
}
