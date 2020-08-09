package com.cbx.sort;

import java.util.Arrays;

/**
 * 简单插入排序的高效版本
 * 交换法
 */
public class ShellSort {
    public static void main(String[] args) {
         int[] arr={8,9,1,7,2,3,5,4,6,0};
//         shellSort(arr);
         shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


        /**
         * 交换法
         * @param arr
         */
        public static void shellSort(int[] arr){
            int temp=0;
            for(int gap=arr.length/2;gap>0;gap/=2){
                //共gap组，步长gap
                for(int i=gap;i<arr.length;i++){
                    for (int j=i-gap;j>=0;j-=gap){
                        if (arr[j]>arr[j+gap]){
                            temp=arr[j];
                            arr[j]=arr[j+gap];
                            arr[j+gap]=temp;
                        }
                    }
                }
                System.out.println("步长"+gap+ Arrays.toString(arr));
            }
        }

        /**
         * 移位法（是进一步的优化）
         * @param arr
         */
        public static void shellSort2(int[] arr){
            for(int gap=arr.length/2;gap>0;gap/=2) {
                     for(int i=gap;i<arr.length;i++){
                         int j=i;
                         int temp=arr[j];
                     if (arr[j]<arr[j-gap]){
                         while(j-gap>=0&&temp<arr[j-gap]){
                             //只是进行移位没有交换，退出while循环才插入进去
                            arr[j]=arr[j-gap];
                            j-=gap;
                         }
                            arr[j]=temp;
                     }
                 }
            }
        }
}
