package com.cbx.recursion;


public class Queue8 {
    int max=8; //皇后个数
    //可以使用一维数组，保存皇后放置位置的结果
    int[] array=new int[max];
    static int count=0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
         queue8.check(0);
        System.out.println("一共有"+count+"种解法");
    }
    /**
     * 放置第n个皇后
     */
    private void check(int n){
        if (n==max){
//            n=8 其实是放第9个了，前面已经放好
            print();
            return;
        }
        //依次放入皇后，并判读是否冲突
        for (int i = 0; i < max; i++) {
            //先把这个皇后n，放在该行的第一列
            array[n]=i;
            //判断是否冲突
            boolean judge = judge(n);
            if (judge){
              //如果不冲突
                check(n+1);
            }
            //如果冲突会回溯到该行的下一个位置
        }
    }

    /**
     * 放置第n个皇后时，就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n n=1表示第二个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //不需要判断是否放在同一行，因为一直在递增着放
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                //在同一列 同一个斜线(同一直线斜率相等永远45度 y2-y1=k(x2-x1) k=1)
                return false;
            }
        }
        return true;
    }
    //写一个方法，可以将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
