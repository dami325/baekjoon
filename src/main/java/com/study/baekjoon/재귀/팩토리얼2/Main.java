package com.study.baekjoon.재귀.팩토리얼2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long factorial = nFactorial(n);

        System.out.println(factorial);
    }


    private static long nFactorial(int n) {

        if (n < 2) {
            return 1l;
        }

        return n * nFactorial(n - 1);

    }
}
