package com.study.baekjoon.재귀.하노이탑이동순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int count = 1;
    private static StringBuilder sb = new StringBuilder();
    // 1, 3, 7, 15,
    // solve(5) = 31
    // solve(4) = 15
    // solve(3) = 7
    // A(2) = 3
    // solve(1) = solve(0) * 2 + 1 = 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, N) - 1).append('\n');

        solve(N,1,2,3);

        System.out.println(sb);

        br.close();
    }

    private static void solve(int N, int A, int B, int C) {

        if (N == 1) {
            sb.append(A+" "+C).append("\n");
            return;
        }

        solve(N-1,A,C,B);

        sb.append(A+" "+C).append("\n");

        solve(N-1,B,A,C);

    }
}
