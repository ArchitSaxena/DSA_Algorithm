package com.archit.linkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList obj= new LinkedList();
        obj.insertFirst(10);
        obj.insertLast(20);
        obj.insertLast(30);
        obj.insertLast(40);
        obj.insertLast(50);
        obj.insertLast(60);
        obj.insertIndex(70,2);
        System.out.println(obj.deleteFirst());
        System.out.println(obj.deleteLast());
        //obj.deleteIndex(2);
       // obj.findNode(40);
        obj.display();
    }
}
