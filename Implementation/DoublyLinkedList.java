package com.Implementation;
class Solution{
    NodeList head;
    NodeList tail;
    class NodeList{
        int val;
        NodeList prev;
        NodeList next;
        NodeList(int val ){
            this.val = val;
            prev = null;
            next= null;
        }
    }
    Solution(){
        head = null;
        tail = null;
    }
    public void add(int val){
        NodeList n = new NodeList(val);
        if(head == null){
            head = n;
            tail = n;
        }
        else{
            tail.next = n;
            tail = n;
        }
    }
    public void display(){
        NodeList n = head;
        while(n!=null){
            System.out.println(n.val+"   ");
            n = n.next;
        }
    }
    public void reverse(){
        NodeList n = tail;
        NodeList prev = n.prev;

//        NodeList prev = null;
//        NodeList next = null;
        while(n!=null){
            System.out.println(n.val+"  ");
            n = n.prev;
            prev = prev.prev;
        }
    }
}
public class DoublyLinkedList {
    public static void main(String args[]){
        Solution s = new Solution();
        s.add(4);
        s.add(10);
        s.add(4);
        s.add(5);
        s.display();
        s.reverse();

    }
}
