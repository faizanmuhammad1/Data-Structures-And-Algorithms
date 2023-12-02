import SortingAlgorithms.*;
import Tree.*;
import Hashing.*;

import java.util.Arrays;

public class Main {
      public static void main(String[] args){
        int[] arr = {4,2,1,7,3,6,7};
        InsertionSort is = new InsertionSort();
        is.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

