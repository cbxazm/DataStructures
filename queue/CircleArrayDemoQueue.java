package com.cbx.queue;

import java.util.Scanner;

public class CircleArrayDemoQueue {
    public static void main(String[] args) {
        CircleArray queue=new CircleArray(3);
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
class CircleArray{
    private int maxSize; //数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //数据用于存放数据，模拟队列
    public CircleArray(int arrMaxSize){
//        front 和rear默认就是0
        maxSize=arrMaxSize;
        arr=new int[maxSize];
    }
    //    判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
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
//      直接将数据加入
        arr[rear]=n;
//        将rear后移
        rear=(rear+1)%maxSize;
    }

    //    获取队列数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
       int temp=arr[front];
        front=(front+1)%maxSize;
        return temp;
    }
    //    显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
//        从front开始遍历 ，遍历(rear-front+maxSize)%maxSize个
       for(int i=front;i<front+(rear-front+maxSize)%maxSize;i++){
//            会越界，自己带个图分析
           System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
       }
    }
    //    显示队列的头数据，不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front]; //只是显示，不需要移动指针
    }
}