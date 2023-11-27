package Tree;

public class BinaryHeap {
    private int[] arr;
    private int capacity;
    public BinaryHeap(int capacity){
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
             else{
                 return;
             }
        }
    }

    public void delete(){
          if(capacity==0){
              System.out.println("Empty Heap");
              return;
          }
          arr[1]=arr[capacity];

          capacity--;

          int i=1;

          while(i<capacity){
              int leftChild = 2*i;
              int rightChild = 2*i+1;
              if(leftChild < capacity && arr[leftChild] > arr[i]){
                  int temp = arr[leftChild];
                  arr[leftChild] = arr[i];
                  arr[i] = temp;
                  i = leftChild;
              } else if (rightChild < capacity && arr[rightChild] > arr[i]) {
                  int temp = arr[rightChild];
                  arr[rightChild] = arr[i];
                  arr[i] = temp;
                  i = rightChild;
              } else{
                  return;
              }
          }

    }
    


    public void print(){
        for (int i = 1; i <= capacity ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}