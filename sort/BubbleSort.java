package com.cbx.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
//        int arr[]={3,9,-1,-10,20};
        int arr[]={1,2,3,4,5,6};
        bubbleSort(arr);

    }
    public static void bubbleSort(int[] arr){
        int temp=0; //临时变量
        boolean flag=false;//标记，表示是否进行交换
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length-1-j; i++) {
                if (arr[i]>arr[i+1]){
                    flag=true;
                    temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
            System.out.println("第"+(j+1)+"排序后的数组"+ Arrays.toString(arr));
            if (!flag){
                //没交换过
                break;
            }

        }
    }
}
