package com.Implementation;
import java.util.Iterator;
class LinkedList<T> implements Iterable<T> {
    NodeList head;
    NodeList tail;
    class NodeList {
        T val;
        NodeList next;

        NodeList(T val) {
            this.val = val;
        }

    }

    LinkedList() {
        head = null;
    }

    public void add(T value) {
        NodeList n = new NodeList(value);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void delete(int index) {
        NodeList n = head;
        NodeList pre = null;
        if (head == null) {
            throw new NullPointerException("List is Empty");
        }
        if (index == 0) {
            n = n.next;
            return;
        }
        for (int i = 0; i < index; i++) {
            pre = n;
            n = n.next;
        }
        pre.next = n.next;
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
    public void deleteEnd() {
        NodeList n = head;
        if (head == null) {
            return;
        } else {
            if (head != tail) {
                while (n.next != tail) {
                    n = n.next;
                }
                tail = n;
                tail.next = null;
            } else {
                head = tail = null;
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

    public void insertBegin(T value) {
        NodeList n = new NodeList(value);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;

        }
    }

    public void insertEndAndInter(int Index, T value) {
        NodeList n = new NodeList(value);
        NodeList temp = head;
        if (temp == null) {
            throw new NullPointerException("null pointer Exception ...");
        }
        if (Index == 0) {
            insertBegin(value);
            return;
        } else if (Index < 0) {
            throw new IndexOutOfBoundsException("invalid index ...");
        }
        for (int i = 0; i < Index - 1; i++) {
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
    }
    public void removeDuplicate() {
        NodeList current = head;
        NodeList index = null;
        NodeList temp = null;
        if (head == null) {
            return;
        } else {
            while (current != null) {
                temp = current;
                index = current.next;
                while (index != null) {
                    if (current.val == index.val) {
                        temp.next = index.next;
                    } else {
                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
    public boolean searchValue(T val){
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

    public void reverse() {
        NodeList n = head;
        NodeList prev = null;
        NodeList temp = head.next;
        while (n != null) {
            temp = n.next;
            n.next = prev;
            prev = n;
            n = temp;
        }
        head = prev;
    }

    public T get(int index) {
        NodeList n = head;
        for (int i = 0; i <= index; i++) {

            if (n == null) {
                throw new IndexOutOfBoundsException("null pointer Exception ...");
            } else if (index == i) {
                return n.val;
            }
            n = n.next;
        }
        return n.val;
    }

    public int minimum() {
        NodeList n = head;
        int min = 0;
        if (head == null || head == tail) {
            return 0;
        } else {
            min = (int) n.val;
            while (n != null) {
                if (min > (int) n.val) {
                    min = (int) n.val;
                }
                n = n.next;
            }
            return min;
        }
    }
        public int maximum () {
            NodeList n = head;
            int max = 0;
            if (head == null || head == tail) {
                return max;
            } else {
                while (n != null) {
                    if (max < (int)n.val) {
                        max = (int)n.val;
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

    public void display(){
        NodeList n = head;
        while(n!=null){
            System.out.print(n.val +"  ");
            n =n.next;
        }
        System.out.println();
    }
    @Override
    public Iterator <T> iterator(){
        return new Iterator<T>(){
            NodeList n = head;
            public boolean hasNext(){
                return n!=null;
            }
            public T next(){
                T val = head.val;
                n = n.next;
                return val;
            }
        };

    }

}
//public class LinkedListImplementation {
//    public static void main(String args[]){
//        LinkedList ll = new LinkedList();
//        ll.add(4);
//        ll.add(5);
//        ll.add(6);
//        ll.add(7);
//        ll.add(8);
//        ll.display();
//        ll.delete(1);
//        ll.display();
//        ll.insertBegin(1);
//        ll.display();
//        ll.insertEndAndInter(3,12);
//        ll.display();
//        int a =ll.get(3);
//        System.out.println(a);
//        ll.reverse();
//        ll.display();
//
//
//    }
//}

