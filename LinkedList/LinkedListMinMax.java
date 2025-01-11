package com.LinkedList;
 class MinMax {
    NodeList head;
    NodeList tail;

    class NodeList {
        int val;
        NodeList next;

        NodeList(int val) {
            this.val = val;
            next = null;
        }
    }

    MinMax() {
        head = null;
        tail = null;
    }

    public void add(int val) {
        NodeList a = new NodeList(val);
        if (head == null) {
            head = a;
            tail = a;
        }
        else {
            tail.next = a;
            tail = a;
        }
    }

    public int minimum() {
        NodeList n = head;
        int min  =0;
        if (head == null || head == tail) {
            return min;
        }
        else {
            min = n.val;
            while (n != null) {
                if (min > n.val) {
                    min = n.val;
                }
                n = n.next;
            }
            return min;
        }
    }

    public void display() {
        NodeList n = head;
        while (n != null) {
            System.out.print(n.val + "  ");
            n = n.next;
        }
    }

    public int maximum() {
        NodeList n = head;
        int max = 0;
        if (head == null || head == tail) {
            return max;
        } else {
            while (n != null) {
                if (max < n.val) {
                    max = n.val;
                }
                n = n.next;
            }
            return max;
        }
    }

    public int size() {
        NodeList n = head;
        int count = 0;
        while (n != null) {
            count++;
            n  = n.next;
        }
        return count;
    }
}
public class LinkedListMinMax{
        public static void main(String args[]){
        MinMax mm = new MinMax();
        mm.add(5);
        mm.add(2);
        mm.add(9);
        mm.add(4);
        mm.display();
        int c = mm.minimum();
        System.out.println("min is :"+c);
        int d = mm.maximum();
        System.out.println("max is :"+d);
        int f = mm.size();
        System.out.println("Size is :"+ f);
        }
}