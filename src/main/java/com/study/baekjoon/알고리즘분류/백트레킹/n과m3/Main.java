package com.study.baekjoon.알고리즘분류.백트레킹.n과m3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[M];

            solve(0);

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int index){
        if (index == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {

            arr[index] = i;

            solve(index + 1);
        }

    };
}
