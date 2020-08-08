package com.cbx.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
            int[] arr={25,34,1,5,3};
            insertSort(arr);
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            int insertVal=arr[i];
            int insertIndex=i-1;
           while (insertIndex>=0&&insertVal<arr[insertIndex]){
               arr[insertIndex+1]=arr[insertIndex];
               insertIndex--;
           }
           if(insertIndex+1!=i){
               //插到自己原来的位置，不需要
               arr[insertIndex+1]=insertVal;
           }
            System.out.println("第"+i+"次插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}



