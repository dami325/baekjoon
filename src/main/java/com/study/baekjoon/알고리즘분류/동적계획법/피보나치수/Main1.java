package com.study.baekjoon.알고리즘분류.동적계획법.피보나치수;

import java.util.Scanner;

public class Main1 {

    private static int zero, one;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i ++){
            zero = 0; one = 0;

            int n = sc.nextInt();

            fibonacci(n);

            System.out.println(zero + " " + one);

        }
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            zero++;
            return 0;
        }

        if (n == 1) {
            one++;
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);

    }
}
