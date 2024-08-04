package com.study.baekjoon.항해99.챌린저12일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static int n;
    private static int[] dp;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            n = Integer.parseInt(br.readLine());

            graph = new ArrayList[n];

            dp = new int[n];

            String[] arr = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i < arr.length; i++) {
                graph[Integer.parseInt(arr[i])].add(i);
            }

            System.out.println(dfs(0));



        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    private static int dfs(int cur) {
        int cnt = 0, max = 0;
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (Integer next : graph[cur]) {
            dp[next] = dfs(next);
            q.add(dp[next]);
        }

        while (!q.isEmpty()) {
            int count = q.poll();
            cnt++;
            max = Math.max(max, count + cnt);
        }

        return max;
    }

}
