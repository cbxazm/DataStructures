package com.cbx.recursion;

public class RecursionTest {
    public static void main(String[] args) {
         test(3);
        int factorial = factorial(3);
        System.out.println(factorial);
    }
    public static void test(int n){
        if (n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }
    public static int factorial(int n){
        if (n==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }

}
