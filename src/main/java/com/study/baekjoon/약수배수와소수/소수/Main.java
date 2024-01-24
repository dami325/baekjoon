package com.study.baekjoon.약수배수와소수.소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                list.add(i);
                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
