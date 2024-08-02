package com.study.baekjoon.항해99.챌린저12일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static int n, result, count;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            n = Integer.parseInt(br.readLine());

            visited = new boolean[n];

            graph = new ArrayList[n];

            String[] arr = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < arr.length; i++) {
                int num = Integer.parseInt(arr[i]);
                graph[num].add(i);
                graph[i].add(num);
            }


            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    private static void dfs(int num) {
        if (num == -1) {
            result = Math.max(count, result);
            count = 0;
            return;
        }

        if (!visited[num]) {
            visited[num] = true;
            ArrayList<Integer> integers = graph[num];

            for (Integer integer : integers) {
                dfs(integer);
            }

            visited[num] = false;
        }

    }

}
