package com.cbx.sort;

import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
         selectSort(new int[]{3,5,1,2,4});
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex=i; //最小值的索引
            int min=arr[i]; //最小值
            for (int j=i+1;j<arr.length;j++){
                if (min>arr[j]){
                    min=arr[j]; //重置Min
                    minIndex=j; //重置minIndex
                }
            }
            if (minIndex!=i){
                //交换
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
            System.out.println("第"+(i+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));
        }
    }
}
