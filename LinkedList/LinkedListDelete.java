package com.LinkedList;

class Delete{
    NodeList head;
    NodeList tail;
    class NodeList{
        int value;
        NodeList next;
        NodeList(int value){
            this.value = value;
            next = null ;
        }
    }
    Delete(){
        head = null;
        tail = null;
    }
    public void add(int value){
        NodeList n = new NodeList(value);
        if(head ==null){
            head = n;
            tail = n;
        }
        else{
            tail.next =n;
            tail = n;
        }
    }
    public void deleteBegin(){
        if(head == null){
            return;
        }
        else{
            if(head != tail) head = head.next;
        }

    }
    public int size(){
        NodeList n = head;
        int count = 0;
        while(n!=null){
            count++;
            n =n.next;
        }
        return count;
    }
    public void deleteCenter(){
        NodeList n = head;
        NodeList pre = null;
        if(head == null){
            return;
        }
        else{
            if(head!=tail) {
                int mid = size() / 2;
                int i = 0;
                while (i <= mid-1) {
                    pre = n;
                    n = n.next;
                    i++;
                }
                pre.next = n.next;
            }
            else head=tail=null;
        }
    }
    public void deleteEnd(){
        NodeList n = head;
        if(head == null){
            return;
        }
        else{
            if(head!=tail) {
                while (n.next != tail) {
                    n = n.next;
                }
                tail = n;
                tail.next = null;
            }
            else{
                head=tail=null;
            }
        }
    }
    public void deleteIndex(int index){
        NodeList n = head;
        NodeList pre = null;
        if(head == null){
            return;
        }
        else{
            int size = size();
            if(head != tail){
                if(size-1 == index){
                   int j=0;
                   while(j!=index-1){
                       n = n.next;
                       j++;
                   }
                   tail =n;
                   tail.next =null;
                }
                else if(index < size) {
                    int i = 0;
                    while (i <= index-1) {
                         pre = n;
                        n = n.next;
                        i++;
                    }
                    pre.next = n.next;
                }
            }
        }
    }
    public void display(){
        NodeList n =head;
        while(n!=null){
            System.out.print(n.value+" ");
            n = n.next;
        }
        System.out.println();
    }
}
public class LinkedListDelete {
    public static void main(String args[]){
        Delete dl = new Delete();
        dl.add(2);
        dl.add(3);
        dl.add(6);
        dl.add(8);
        System.out.print("print all elements :");
        dl.display();
        dl.deleteBegin();
        System.out.print("first element  delete after :");
        dl.display();
        dl.deleteCenter();
        System.out.print("Mid element  delete after  :");
        dl.display();
        dl.deleteEnd();
        System.out.print("Last element  delete after  :");
        dl.display();
        dl.add(2);
        dl.add(3);
        dl.add(6);
        dl.add(8);
        System.out.print("extra elements added after  :");
        dl.display();
        System.out.print("provide Index delete after :");
        dl.deleteIndex(3);
        dl.display();
    }
}
