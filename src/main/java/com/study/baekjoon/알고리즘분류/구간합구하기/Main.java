package com.study.baekjoon.알고리즘분류.구간합구하기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] sumArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1 ] + sc.nextInt();
        }

        for (int i = 1; i <= M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sumArr[end] - sumArr[start - 1]);
        }

    }
}
