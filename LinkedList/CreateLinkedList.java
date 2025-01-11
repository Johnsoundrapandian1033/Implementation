package com.LinkedList;
 class NodeList {
    // NodeList head ;
    NodeList() {
    }

    NodeList head = null;
    NodeList tail = null;
    int value;
    NodeList next;
    NodeList(int value) {
        this.value = value;
        next = null;
    }
    public void add(int value) {
        NodeList nk = new NodeList(value);
        if (head == null) {
            head = nk;
            tail = nk;
        } else {
            tail.next = nk;
            tail = nk;
        }
    }

    // NodeList head;
    public void display() {
        NodeList n = head;
        if (head == null) {
            System.out.println("List is empty :");
        }
        System.out.println("Its a Singly LinkedList ....");
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }
}

public class CreateLinkedList {

            public static void main(String args[]) {
                CreateLinkedList cli = new CreateLinkedList();
                 NodeList nl = new NodeList();
                nl.add(2);
                nl.add(3);
                nl.add(4);
                nl.add(5);
                nl.add(6);
                nl.display();
            }
}
