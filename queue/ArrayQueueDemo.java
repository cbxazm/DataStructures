package com.cbx.queue;

import java.util.Scanner;

/**
 * 用数组模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
     ArrayQueue queue=new ArrayQueue(10);
     char key=' ';//接收用户输入
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):查看队列头元素");
            key=scanner.next().charAt(0); //接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value=scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        System.out.println("取出的数据是"+queue.getQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.headQueue();
                        System.out.println("队列头数据"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                    default:
                        break;

            }
        }
        System.out.println("程序退出了");

    }
}

class ArrayQueue{
    private int maxSize; //数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //数据用于存放数据，模拟队列

//    初始化队列
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        //front 指向队头的前一个位置，rear只向队列的尾部(要么就是front指向对头，rear指向队尾的后一个位置)
        front=rear=-1;

    }
//    判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
//    判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }
//    添加数据到队列
    public void addQueue(int n ){
//        判断队列是否满
        if (isFull()){
            System.out.println("队列已经满了");
            return;
        }
        rear++;  //rear后移
        arr[rear]=n;
    }
//    获取队列数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
       front++; //front指向元素前一个位置，所以先移动指针
        return arr[front];
    }
//    显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
//    显示队列的头数据，不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front+1]; //只是显示，不需要移动指针
    }
}