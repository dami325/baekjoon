package com.study.baekjoon.알고리즘분류.dfs.이분그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int testCase, node, edge;
    private static ArrayList<Integer>[] list;
    private static int[] group;
    private static boolean[] visited;
    private static boolean isBipartiteGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());

            list = new ArrayList[node + 1];
            group = new int[node + 1];
            visited = new boolean[node + 1];
            isBipartiteGraph = true;

            // 그래프 탐색용 인접 리스트 초기화
            for (int i = 1; i <= node; i++) {
                list[i] = new ArrayList<>();
            }

            // 방향이 없는 노드라 서로  -> <- 이어주는 코드
            for (int i = 1; i <= edge; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                list[end].add(start);
            }

            // 노드 길이만큼 탐색
            for (int i = 1; i <= node; i++) {

                if(isBipartiteGraph){
                    dfs(i);
                } else {
                    break;
                }
            }

            if (isBipartiteGraph) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }


        }

        br.close();
    }

    private static void dfs(int nodeIndex) {
        visited[nodeIndex] = true;

        for (int i : list[nodeIndex]) {

            if (!visited[i]) {
                group[i] = (group[nodeIndex] + 1) % 2; // 0, 1, 0, 1로 해주는 코드
                dfs(i);
            } else {
                if (group[i] == group[nodeIndex]) {
                    isBipartiteGraph = false;
                }
            }
        }
    }
}
