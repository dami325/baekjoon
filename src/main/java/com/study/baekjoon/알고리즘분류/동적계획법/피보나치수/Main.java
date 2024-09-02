package com.study.baekjoon.알고리즘분류.동적계획법.피보나치수;

import java.util.Scanner;

public class Main {

    private static int fib1Count;
    private static int fib2Count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fib1(n);
        fib2(n);

        System.out.println(fib1Count + " " + fib2Count);
    }

    private static int fib1(int n) {
        if (n == 1 || n == 2) {
            fib1Count++;
            return 1;
        }

        return (fib1(n - 1) + fib1(n - 2));
    }

    private static int fib2(int n) {
        int[] arr = new int[n + 1];

        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            fib2Count++;
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
