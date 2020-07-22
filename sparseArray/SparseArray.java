package com.cbx.sparseArray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) throws IOException {
//        创建一个原始的二维数组 11*11
        int checkArr1[][]=new int[11][11];
        checkArr1[1][2]=1;
        checkArr1[2][3]=2;
//        输出原始的数组
        System.out.println("原始的二维数组");
        for (int[] row : checkArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println("\n");
        }
        /**
         * 将二维数组 转换成稀疏数组
         * 1.先遍历二维数组得到非0的值
         */
        int sum=0;
        for (int i=0;i<checkArr1.length;i++){
            for (int j = 0; j < checkArr1.length; j++) {
                if(checkArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        /**
         * 创建对应的稀疏数组
         */
        int sparseArr[][]=new int[sum+1][3];
//        给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
//        遍历二维数组，将非0的值存放在sparseArr中
        int count=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(checkArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=checkArr1[i][j];
                }
            }
        }
        /**
         * 输出稀疏数组
         */
        System.out.println("输出稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t",sparseArr[i][j]);
            }
            System.out.println("\n");
        }
        /**
         * 稀疏数组恢复成二维数组
         * 1、先读取稀疏数组的第一行，根据第一行数据，创建原始的二维数组
         */
        int checkArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
//        恢复后的二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            checkArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组");
        for (int[] ints : checkArr2) {
            for (int data:ints){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        /**
         * 存储到磁盘
         */
        File file=new File("d:\\data.txt");
        OutputStream outputStream=new FileOutputStream(file,true);
        for (int[] ints : sparseArr) {
            for (int data:ints){
//                System.out.printf("%d\t",data);
                outputStream.write(String.valueOf(data).getBytes());
                outputStream.write("\t".getBytes());
            }
            String huanhang = System.getProperty("line.separator");
            outputStream.write(huanhang.getBytes());
//            System.out.println();
        }
        outputStream.flush();
        outputStream.close();
/**
 * 读出数组
 */
        System.out.println("开始读出数组++++++++++");
int[][] sparseArr2=new int[sparseArr[0][0]][sparseArr[0][1]];
BufferedReader reader=new BufferedReader(new FileReader(file));
String line;
int row=0;
while ((line=reader.readLine())!=null){
    String[] temp=line.split("\t");
    for (int i = 0; i < temp.length; i++) {
         sparseArr2[row][i]=Integer.parseInt(temp[i]);
    }
    row++;

}
reader.close();

    }




}
