package com.study.baekjoon.항해99.챌린저17일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int nodeCount, edgeCount, teamA, teamB;
    private static boolean[] visited;
    private static int[] group;
    private static ArrayList<Integer>[] graph;
    private static boolean isNotBipartite;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            nodeCount = Integer.parseInt(st.nextToken());
            edgeCount = Integer.parseInt(st.nextToken());

            visited = new boolean[nodeCount + 1];
            group = new int[nodeCount + 1];
            graph = new ArrayList[nodeCount + 1];
            teamA = 1;

            // 인접 리스트 초기화
            for (int i = 1; i <= nodeCount; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < edgeCount; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            for (int i = 1; i <= nodeCount; i++) {
                if (isNotBipartite) {
                    System.out.println(0);
                    return;
                } else {
                    dfs(i);
                }
            }

            System.out.println(teamA * teamB * 2);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int index) {
        visited[index] = true;

        for (int num : graph[index]) {
            if (!visited[num]) {
                int team = (group[index] + 1) % 2;
                if (team == 0) {
                    teamA++;
                } else {
                    teamB++;
                }
                group[num] = team;
                dfs(num);
            } else {
                if (group[num] == group[index]) {
                    isNotBipartite = true;
                }
            }
        }

    }
}
