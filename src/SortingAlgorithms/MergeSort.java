package SortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr){
        if (arr.length < 2)
            return;

        int middle = arr.length/2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }
        int[] right = new int[arr.length-middle];
        for (int i = middle; i < arr.length; i++) {
            right[i-middle]=arr[i];
        }
        sort(left);
        sort(right);

        merge(left,right,arr);
    }
    void merge(int[] left,int[] right,int[] result){
        int i=0,j=0,k=0;


        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
            result[k++] = left[i++];
        }   else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
