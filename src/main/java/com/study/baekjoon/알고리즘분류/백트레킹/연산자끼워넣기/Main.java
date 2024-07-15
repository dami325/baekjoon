package com.study.baekjoon.알고리즘분류.백트레킹.연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int max = -1000000000;
    private static int min = 1000000000;
    private static int n;
    private static int[] arr, operator;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int operatorIndex = 4;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        operator = new int[operatorIndex];
        visited = new boolean[operatorIndex];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < operatorIndex; i++) {
            int opCount = Integer.parseInt(st.nextToken());
            operator[i] = opCount;
        }

        dfs(0, arr[0]);

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    private static void dfs(int depth, int sum) {
        if (depth == n - 1) {
            if (sum < min) {
                min = sum;
            }
            if (sum > max) {
                max = sum;
            }
            return;
        }

        for (int oper = 0; oper < 4; oper++) {
            if (!(operator[oper] == 0)) {
                operator[oper]--;
                if (oper == 0) {
                    dfs( depth + 1, sum + arr[depth+1]);
                } else if (oper == 1) {
                    dfs( depth + 1, sum - arr[depth+1]);
                } else if (oper == 2) {
                    dfs( depth + 1, sum * arr[depth+1]);
                } else if (oper == 3) {
                    dfs( depth + 1, sum / arr[depth+1]);
                }
                operator[oper]++;
            }
        }

    }


}
