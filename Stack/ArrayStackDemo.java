package com.cbx.Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
          ArrayStack stack=new ArrayStack(4);
          String key="";
          boolean loop=true;
        Scanner scanner=new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res=stack.pop();
                        System.out.println("取出的值是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "loop":
                    scanner.close();
                    loop=false;
                    break;
                    default:
                        break;
            }
        }
        System.out.println("程序退出了 ");
    }
}

/**|
 * 模拟一个栈
 */
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;
    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }
    /**
     * 栈满
     */
    public boolean isFull(){
        return top==maxSize-1;
    }
    /**
     * 栈空
     */
    public boolean isEmpty(){
        return top==-1;
    }
    /**
     * 入栈
     */
    public void push(int value){
      if (isFull()){
          System.out.println("栈满");
          return;
      }
      top++;
      stack[top]=value;
    }
    /**
     * 出栈
     * 将栈顶的数据返回
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value=stack[top];
        top--;
        return value;
    }
    /**
     * 遍历栈，从栈顶往下遍历
     */
     public void list(){
         if (isEmpty()){
             System.out.println("没有数据");
             return;
         }
         for (int i=top;i>=0;i--){
             System.out.println("数据"+stack[i]);
         }

     }

}
