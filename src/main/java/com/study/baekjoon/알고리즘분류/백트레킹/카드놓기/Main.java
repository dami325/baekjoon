package com.study.baekjoon.알고리즘분류.백트레킹.카드놓기;

import ch.qos.logback.core.util.SystemInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    private static int n, k;
    private static boolean[] visited;
    private static int[] arr;
    private static HashSet<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0,"");

        System.out.println(result.size());
        br.close();
    }

    private static void dfs(int depth,String sum) {
        if (depth == k) {
            result.add(sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1,sum + "" + arr[i]);
                visited[i] = false;
            }
        }
    }
}
