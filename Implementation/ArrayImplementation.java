package com.Implementation;
import java.util.Scanner;
import java.util.Iterator;
import java.util.*;
class Dynamic<T> implements Iterable<T>{
   static final int capacity = 3;
    private int size;
    private int initialcapcity;
    private T[] a ;
    Dynamic(){
        size = 0;
        initialcapcity = capacity;
        a =  (T[]) new Object[initialcapcity];
    }
    public void add(T value){
        if(size==initialcapcity) {
            expendsArraySize();
        }
        a[size++] = value;
    }
    public void delete(T value ){
        for(int i =0 ; i < a.length ;i++){
            if(a[i]==value) {
                for (int j = i + 1; j < a.length; j++) {
                    a[i] = a[j];
                }
                size--;
            }
        }
        if(initialcapcity > capacity && initialcapcity>3*size){
            shrinkageArraySize();
        }

    }
    public void deleteBegin(){
        for(int i =0 ; i < a.length-1; i++){
            a[i] =a[i+1];
        }
        if(initialcapcity > capacity && initialcapcity>3*size){
            shrinkageArraySize();
        }
        size--;
    }
    public void deleteEnd(){
        if(initialcapcity > capacity && initialcapcity>3*size){
            shrinkageArraySize();
        }
        for(int i =0 ; i < a.length;i++){
            if(i == size-1){
                a[i] = a[i+1];
                size--;
            }
        }

    }
    public void insertValue(int pos , T value){
        if(size == initialcapcity) expendsArraySize();
        for(int i = size-1 ; i >= pos-1;i--){
            a[i+1] =a[i];
        }
        a[pos-1] =value;
        size++;
    }
    public void insertBeginValue(T value){
        if(size == initialcapcity){
            expendsArraySize();
        }
        for(int i = size-1; i>= 0; i--){
            a[i+1] =a[i];
        }
        a[0] = value;
        size++;
    }
    public void insertEndValue(T value){
        if(size == initialcapcity){
            expendsArraySize();
        }
        a[size] = value;
        size++;
    }
    public void printArray(){
        for(T i: a){
            System.out.println(i);
        }
    }
    public void updateValue(int pos,T value){
        if(pos!=1) a[pos-1] = value;
    }
    public void SearchIndex(T value){
        for(int i =0 ; i < a.length;i++){
            if(a[i]==value) System.out.println(value +"  Index "+i);
        }
    }
    public void expendsArraySize(){
        initialcapcity  *= 2;
        a = java.util.Arrays.copyOf(a,initialcapcity);
    }
    public void getValue(int pos){
        for(int i=0;i<a.length;i++) {
            if (pos != 0) System.out.println("value is "+a[pos-1]);
        }
    }
    public void clear(){

        for(int i = 0 ;i< a.length;i++){
            if(size !=0) {
                size--;
            }
        }

    }
    public void shrinkageArraySize(){
        initialcapcity /= 2;
        a =java.util.Arrays.copyOf(a,initialcapcity);
    }

    @Override
    public Iterator<T>iterator(){
        return new Iterator<T>(){
            int index = 0;

            public T next() {
                return a[index++];
            }
             public boolean hasNext(){
                return index<size;
             }
        };
    }
}
//public class ArrayImplementation {
//    public static void main(String argsp[]){
//        Scanner scanner = new Scanner(System.in);
//        Dynamic dy=  new Dynamic();
//        int val,pos;
//
//        while(true){
//            System.out.println("1) Add Array value ");
//            System.out.println("2) Delete Array value ");
//            System.out.println("3) Delete from begining ");
//            System.out.println("4) Delete from end ");
//            System.out.println("5) Insert Array Value ");
//            System.out.println("6) Insert from begining ");
//            System.out.println("7) Insert from end ");
//            System.out.println("8) get Value ");
//            System.out.println("9) Update Index Value ");
//            System.out.println("10) Search value ");
//            System.out.println("11) Array Clear ");
//            System.out.print("Enter your option :");
//            int option  = scanner.nextInt();
//            switch(option){
//                case 1:
//                    System.out.print("Enter the value :");
//                    val = scanner.nextInt();
//                    dy.add(val);
//                    dy.printArray();
//                   break;
//                case 2:
//                    System.out.print("Enter the value :");
//                    val = scanner.nextInt();
//                     dy.delete(val);
//                     dy.printArray();
//                     break;
//                case 3:
//                    dy.deleteBegin();
//                    dy.printArray();
//                    break;
//                case 4:
//                    dy.deleteEnd();
//                    dy.printArray();
//                    break;
//                case 5:
//                    System.out.print("Enter the value :");
//                    val = scanner.nextInt();
//                    System.out.print("Enter the position :");
//                    pos = scanner.nextInt();
//                    dy.insertValue(pos,val);
//                    dy.printArray();
//                    break;
//                case 6 :
//                    System.out.print("Enter the value :");
//                    val = scanner.nextInt();
//                    dy.insertBeginValue(val);
//                    dy.printArray();
//                    break;
//                case 7:
//                    System.out.print("Enter the value :");
//                    val = scanner.nextInt();
//                    dy.insertEndValue(val);
//                    dy.printArray();
//                    break;
//                case 8:
//                    System.out.print("Enter the position :");
//                    pos = scanner.nextInt();
//                    dy.getValue(pos);
//                    break;
//                case 9 :
//                    System.out.print("Enter the update position :");
//                    pos = scanner.nextInt();
//                    System.out.print("Enter the update value :");
//                    val = scanner.nextInt();
//                    dy.updateValue(pos,val);
//                    dy.printArray();
//                    break;
//                case 10:
//                    System.out.print("Enter the position :");
//                    pos = scanner.nextInt();
//                    dy.SearchIndex(pos);
//                    break;
//                case 11:
//
//                    dy.clear();
//                    dy.printArray();
//                    break;
//                default:
//                    System.out.println("invalid option ");
//            }
//
//        }
//
//    }
//}
