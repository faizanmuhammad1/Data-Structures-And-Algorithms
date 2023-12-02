package SortingAlgorithms;

public class BubbleSort {
    public void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean isSorted = true;
            for (int j = 1; j < arr.length; j++) {
                 if (arr[j] < arr[j-1]){
                     swap(arr,j,j-1);
                     isSorted=false;
                 }
            }
            if(isSorted) return;
        }
    }
    void swap(int[] arr,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
