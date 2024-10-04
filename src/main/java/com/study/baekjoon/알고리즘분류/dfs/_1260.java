package com.study.baekjoon.알고리즘분류.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1260 {

    private static boolean[] visited1;
    private static boolean[] visited2;
    private static ArrayList<Integer>[] graphs;
    private static int n,m,v;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited1 = new boolean[n + 1];
        visited2 = new boolean[n + 1];
        graphs = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graphs[start].add(end);
            graphs[end].add(start);
        }

        dfs(v,0);
        sb.append("\n");
        bfs();

        System.out.println(sb.toString());
    }

    private static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        ArrayList<Integer> graph = graphs[v];
        sb.append(v).append(" ");
        visited2[v] = true;

        graph.sort((node1, node2) -> node1 - node2);

        for (Integer n : graph) {
            queue.add(n);
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (visited2[node]) {
                continue;
            }
            visited2[node] = true;
            sb.append(node).append(" ");

            ArrayList<Integer> next = graphs[node];

            next.sort((node1, node2) -> node1 - node2);

            for (Integer nextN : next) {
                queue.add(nextN);
            }
        }

    }

    private static void dfs(int node,int depth) {
        if (depth == n) {
            return;
        }
        visited1[node] = true;

        sb.append(node).append(" ");

        ArrayList<Integer> graph = graphs[node];
        graph.sort((node1, node2) -> node1 - node2);

        for (Integer n : graph) {
            if (visited1[n]) {
                continue;
            }
            dfs(n, depth + 1);
        }

    }
}
