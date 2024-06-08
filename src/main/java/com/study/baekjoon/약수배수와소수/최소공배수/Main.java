package com.study.baekjoon.약수배수와소수.최소공배수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num1 = sc.nextLong();
        long num2 = sc.nextLong();

        long a = Math.max(num1, num2);
        long b = Math.min(num1, num2);

        while(b > 0) {
            long tmp = a;
            a = b;
            b = tmp%b;
        }

        System.out.println((num1*num2)/a);
    }
}
