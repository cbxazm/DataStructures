package com.cbx.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //定义一个逆波兰表达式
        //(3+4)*5-6 =>34+5*6-
//        String suffixExpression="3 4 + 5 * 6 -";
//        List<String> string = getListString(suffixExpression);
//        System.out.println(string);
//        int calculate = calculate(string);
//        System.out.println(calculate);
        String expression="1+(20*3)-5";
        List<String> list = toInfixExpressionList(expression);
        List<String> list1 = parseSuffixExperssion(list);
        int calculate = calculate(list1);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(calculate);
    }
    /**
     * 将逆波兰表达式，数据和运算符 放入ArrayList中
     */
    public static List<String> getListString(String suffixExperssion){
        String[] split = suffixExperssion.split(" ");
        List<String> list=new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }
    /**
     * 完成后缀表达式的运算
     */
    public static int calculate(List<String> ls){
          //创建一个栈
        Stack<String> stack=new Stack<>();
        //遍历List
        for (String item : ls) {
            if (item.matches("\\d+")){
                //匹配多位数
                stack.push(item);
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if (item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("*")){
                     res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
    /**
     * 将中缀表达式转换成对应的list
     */
    public static List<String> toInfixExpressionList(String s){
          List<String> ls=new ArrayList<>();
          int i=0;//用来遍历中缀表达式字符串
          char c;
          while(i<s.length()){
              if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                  //如果是非数字，直接加入
                  ls.add(""+c);
                  i++; //后移
              }else {
                  //如果是数，考虑多位数的情况
                  String str=""; //用来拼接多位数
                  while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                      str+=s.charAt(i);
                      i++;
                  }
                  ls.add(str);
              }
          }
          return ls;
    }
    /**
     * 将中缀表达式对应的List转为后缀
     */
    public static List<String> parseSuffixExperssion(List<String> ls){
         //定义两个栈
        Stack<String> s1=new Stack<>();
        //s2只需要保存结果，还要逆序输出，这里就不用栈了
        List<String> s2=new ArrayList<>();
        for (String item : ls) {
             if(item.matches("\\d+")){
                 s2.add(item);
             }else if(item.equals("(")){
                 s1.push(item);
             }else if(item.equals(")")){
                 while (!s1.peek().equals("(")){
                     //一直弹出，直到出现左括号为止
                     s2.add(s1.pop());
                 }
                 //把左括号弹出，消除一对括号
                 s1.pop();
             }else {
               while (s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                   //如果当前操作符的优先级小于等于 栈顶操作符的优先级
                   s2.add(s1.pop());
               }
               s1.push(item); //将该操作符要入栈

             }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
}
//返回运算符优先级的类
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=1;
    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}