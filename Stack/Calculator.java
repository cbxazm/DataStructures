package com.cbx.Stack;

import java.util.OptionalInt;

/**
 * 实现式的计算
 */
public class Calculator {
    public static void main(String[] args) {
        String expression="10-3-6-2-5";
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index=0; //用于扫描
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';
        String keepNum="";
         while (true){
             //遍历每一个字符
             ch=expression.substring(index,index+1).charAt(0);
             if (operStack.isOper(ch)){
                //是运算符 ,判断当前的符号栈是否为空
                    if(!operStack.isEmpty()){
                        //符号栈不为空  (与栈顶元素比较一下)
                        if (operStack.priority(ch)<=operStack.priority(operStack.peek())){
                            num1=numStack.pop();
                            num2=numStack.pop();
                            oper=operStack.pop();
                            res=numStack.cal(num1,num2,oper);
                            numStack.push(res);
                            //把当前操作符入符号栈
                            operStack.push(ch);
                        }else {
                            //当前操作符的优先级大于栈顶的操作符优先级，直接入栈
                            operStack.push(ch);
                        }
                      }else {
                        //符号栈为空 ，直接入符号栈
                        operStack.push(ch);
                    }
                  } else {
                    //如果是数字  //'1'==>49 减去48就是原本的
//                          numStack.push(ch-48);
                         //处理多位数的问题
                         keepNum+=ch;
                    if(index==expression.length()-1){
                        //到达最后一位直接入栈
                        numStack.push(Integer.parseInt(keepNum));
                    }else {
                        //是操作符就不扫描，直接入栈
                        if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                            numStack.push(Integer.parseInt(keepNum));
                            //一定要注意清空
                            keepNum="";
                        }
                        }
                    }
                         //index后移一位
                         index++;
                         if (index>=expression.length()){
                             break;
                         }
                  }
                while (true){
                    //如果符号栈为空，则得到最后的结果，不然就计算
                    if (operStack.isEmpty()){
                        break;
                    }
                    num1=numStack.pop();
                    num2=numStack.pop();
                    oper=operStack.pop();
                    res=numStack.cal(num1,num2,oper);
                    numStack.push(res);
                }
                System.out.printf("表达式%s=%d",expression,numStack.pop());

         }

    }

/**
 * 对之前的栈进一步加强
 */
class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top=-1;
    public ArrayStack2(int maxSize){
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
    /**
     * 返回运算符的优先级
     */
    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;//暂定只有=-*/
        }
    }
    /**
     * 判断是不是一个运算符
     */
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    /**
     * 计算方法
     */
    public int cal(int num1,int num2,int oper){
           int res=0;
           switch (oper){
               case '+':
                   res=num1+num2;
                   break;
               case '-':
                   //注意顺序
                   res=num2-num1;
                   break;
               case '*':
                   res=num1*num2;
                   break;
               case '/':
                   res=num2/num1;
                   break;
               default:
                   break;
           }
           return res;
    }
    /**
     * 增加一个方法，可以返回栈顶的值，但不是真正的pop
     */
    public int peek(){
        return stack[top];
    }

}
