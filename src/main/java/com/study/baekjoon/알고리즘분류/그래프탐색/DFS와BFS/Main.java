package com.study.baekjoon.알고리즘분류.그래프탐색.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] visited;
    private static boolean[] bfsVisited;
    private static ArrayList<Integer>[] graph;
    private static int N, M, V;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            graph[i].sort((o1, o2) -> o1 - o2);
        }

        dfs(V, 0);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
        br.close();
    }

    private static void bfs(int start) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();

        bfsVisited[start] = true;

        queue.offer(graph[start]);

        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            ArrayList<Integer> node = queue.poll();
            for (int value : node) {
                if (!bfsVisited[value]) {
                    bfsVisited[value] = true;
                    sb.append(value).append(" ");
                    queue.offer(graph[value]);
                }
            }
        }
    }
    private static void dfs(int index, int depth) {
        if (depth == N) {
            return;
        }
        if (!visited[index]) {
            visited[index] = true;
            sb.append(index).append(" ");
            for (int value : graph[index]) {
                dfs(value, depth + 1);
            }
        }
    }
}
