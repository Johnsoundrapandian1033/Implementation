package com.LinkedList;

public class basicLinkedList
{
    NodeList head;
    static class NodeList {
        int val;
        NodeList next;

        NodeList(int value) {
            val = value;
            next = null;
        }
    }
    public void display(){
        NodeList n = head;
        while(n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }
        public static void main(String args[])
        {
            basicLinkedList li = new basicLinkedList();
            li.head       = new NodeList(100);
            NodeList li2      = new NodeList(200);
            NodeList li3      = new NodeList(300);

            li.head.next = li2; // Link first node with the second node
            li2.next = li3; // Link first node with the second node
            li.display();
        }
}
