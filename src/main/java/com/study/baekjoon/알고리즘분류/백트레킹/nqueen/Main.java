package com.study.baekjoon.알고리즘분류.백트레킹.nqueen;

import java.util.Scanner;

public class Main {

    private static int[] arr;
    private static int N;

    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N];

        solve(0);

        System.out.println(count);

        sc.close();
    }

    private static void solve(int depth) {

        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if(valid(depth)){
                solve(depth + 1);
            }
        }
    }

    private static boolean valid(int depth) {
        for (int i = 0; i < depth; i++) {

            // 이전 depth 들중 현재 뎁스값이 같은 행인지
            if (arr[i] == arr[depth]) {
                return false;
            }
            //대각선방향에 존재하는지
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
