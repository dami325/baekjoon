package com.study.baekjoon.재귀.피보나치;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static HashMap<Integer, Long> memo = new HashMap<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibonacciSequence(n));

    }

    private static long fibonacciSequence(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result = fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
        memo.put(n, result);

        return result;

    }
}
