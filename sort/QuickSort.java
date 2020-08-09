package com.cbx.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1,2,5,0,9,-1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int low,int high){
            if (low<high){
                int pivotpos=Partition(arr,low,high);
                quickSort(arr,low,pivotpos-1);
                quickSort(arr,pivotpos+1,high);
            }
    }

    public  static int Partition(int[] arr,int low,int high){
          int pivot=arr[low];
          while(low<high){
              while (low<high&&arr[high]>=pivot) --high;
              arr[low]=arr[high];  //小的移动到左端

              while(low<high&&arr[low]<=pivot) ++low;
              arr[high]=arr[low]; //大的移动到右端
          }
          arr[low]=pivot;
          return low;

    }
}
