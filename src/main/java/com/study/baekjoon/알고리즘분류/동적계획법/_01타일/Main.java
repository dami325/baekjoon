package com.study.baekjoon.알고리즘분류.동적계획법._01타일;

import java.util.Scanner;

public class Main {

    private static int[] dp;
    private static String[] arr = {"00","1"};
    private static int n, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n];

        bfs(0);
    }

    private static void bfs(int depth) {
//        if(dp[])

        if (depth > n) {
            return;
        } else if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            String str = arr[i];

        }

    }
}
