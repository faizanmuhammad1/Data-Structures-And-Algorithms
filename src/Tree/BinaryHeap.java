package Tree;

public class BinaryHeap {
    private int[] arr;
    private int capacity;
    BinaryHeap(int capacity){
        arr = new int[capacity+1];
        this.capacity=0;
        arr[0]=Integer.MAX_VALUE;
    }

    public void insert(int val){
        if(capacity==arr.length-1){
            System.out.println("Stack Overflow");
            return;
        }
        arr[++capacity]=val;
        int index=capacity;
        while(index > 1){
            int parent = index/2;
             if(arr[index]>arr[parent]){
                    int temp = arr[index];
                    arr[index] = arr[parent];
                    arr[parent] = temp;
                    index=parent;
             }
        }
    }

}