package com.study.baekjoon.백트레킹.n과m2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static boolean[] visit;
    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[M];
            visit = new boolean[N];

            solve(0,0);

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int arrIndex,int startIndex){
        if (arrIndex == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = startIndex; i < N; i++) {

            if (visit[i]) {
                continue;
            }

            visit[i] = true;

            arr[arrIndex] = i + 1;

            solve(arrIndex + 1, i + 1);

            if (arrIndex != 0) {
                visit[i] = false;
            }
        }
    }
}
