package Hashing;

import java.util.Arrays;

public class HashTables {
    private int[] arr;
    private int capacity;
    HashTables(int size){
        arr = new int[size];
        Arrays.fill(arr, -1);
    }

    public int hashCode(int val){
        return ((val)%(arr.length));
    }

    public void insert(int val)
    {
        if(capacity==arr.length){
            System.out.println("Table is full");
            return;
        }
        int i=hashCode(val);
        while(arr[i]!=-1){
            i=((i+1)%(arr.length));
        }
        arr[i]=val;
        capacity++;
    }

    public boolean search(int val){
        int counter=0;
        int i=hashCode(val);
        while(counter<=arr.length){
            if(arr[i]==val){
                return true;
            }
            i=((i+1)%(arr.length));
            counter++;
        }
        return false;
    }

    public void printHashTable(){
        for (int i:
             arr) {
            System.out.println(i+" ");
        }
    }
    public static void main(String[] args){
            HashTables ht = new HashTables(4);
            ht.insert(43);
            ht.insert(23);
            ht.insert(88);
            ht.insert(76);
            ht.printHashTable();
        System.out.println(ht.search(54));

    }
}
