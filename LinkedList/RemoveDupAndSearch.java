package com.LinkedList;
class LinkedList{
    NodeList head;
    NodeList tail;
    class NodeList{
        int val;
        NodeList next;
        NodeList(int val){
            this.val = val;
            next =null;
        }
    }
    LinkedList(){
        head = null;
        tail = null;
    }
    public void add(int val){
        NodeList n = new NodeList(val);
        if(head==null){
            head = n;
            tail =n;
        }
        else{
            tail.next =n;
            tail = tail.next;
        }
    }
    public void removeDuplicate() {
        NodeList current = head;
        NodeList index = null;
        NodeList temp = null;
        if (head == null) {
            return;
        } else {
            while (current != null) {
                //Node temp will point to previous node to index.
                temp = current;
                //Index will point to node next to current
                index = current.next;

                while (index != null) {
                    //If current node's data is equal to index node's data
                    if (current.val == index.val) {
                        //Here, index node is pointing to the node which is duplicate of current node
                        //Skips the duplicate node by pointing to next node
                        temp.next = index.next;
                    } else {
                        //Temp will point to previous node of index.
                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
    public boolean searchValue(int val){
        NodeList n = head;
        if(head==null){
            return false;
        }
        while(n!=null){
            if(n.val==val){
                return true;
            }
            n = n.next;
        }
        return false;
    }
    public void display(){
        NodeList n = head;
        while(n!=null){
            System.out.print(n.val+"  ");
            n =n.next;
        }
        System.out.println();
    }
}

public class RemoveDupAndSearch {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.add(2);
        ll.add(10);
        ll.add(12);
        ll.add(3);
        ll.add(2);
        ll.add(8);
        ll.add(10);
        ll.add(9);
        System.out.print("print all elements :");
        ll.display();
        ll.removeDuplicate();
        System.out.print("After removing  :");
        ll.display();
        int val = 8;
        boolean a =ll.searchValue(val);
        System.out.println(val+" is "+a);
    }
}
