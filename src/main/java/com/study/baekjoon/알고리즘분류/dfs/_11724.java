package com.study.baekjoon.알고리즘분류.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 * 3 초	512 MB	136526	61650	40482	42.030%
 * 문제
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
 * 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v)
 * 같은 간선은 한 번만 주어진다.
 * <p>
 * 출력
 * 첫째 줄에 연결 요소의 개수를 출력한다.
 * <p>
 * 예제 입력 1
 * 6 5
 * 1 2
 * 2 5
 * 5 1
 * 3 4
 * 4 6
 * 예제 출력 1
 * 2
 */
public class _11724 {

    private static boolean[] visit;
    private static ArrayList<Integer>[] arrays;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            visit = new boolean[n];
            arrays = new ArrayList[n];

            // 인접 리스트 초기값
            for (int i = 0; i < n; i++) {
                arrays[i] = new ArrayList<>();
            }

            // 엣지 정보
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
                arrays[start].add(end);
                arrays[end].add(start);
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    count++;
                    DFS(i);
                }
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void DFS(int n) {
        if (visit[n]) {
            return;
        }

        visit[n] = true;

        for (int i : arrays[n]) {
            if (!visit[i]) {
                DFS(i);
            }
        }



    }
}
