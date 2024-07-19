package com.study.baekjoon.알고리즘분류.백트레킹.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int N,M;
    private static boolean[] visited;
    private static ArrayList<House> houseArrayList = new ArrayList();
    private static ArrayList<Chicken> chickenArrayList = new ArrayList();
    private static int[][] arr;
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 1) {
                    houseArrayList.add(new House(i, j));
                } else if (num == 2) {
                    chickenArrayList.add(new Chicken(i, j));
                }
            }
        }

        visited = new boolean[chickenArrayList.size()];

        dfs(0,0);

        System.out.println(result);

    }

    /**
     * 치킨집 그룹 경우의수 만큼 모두 탐색해두기
     *
     * 치킨집 1
     * 치킨집 2
     * 치킨집 3
     * 치킨집 4 가 있을경우 M == 2일때
     *
     * (1,2) (1,3) (1,4) (2,3) (2,4) (3,4)
     *
     * 그룹 중 최단거리 가장 짧은 그룹
     *
     */
    private static void dfs(int chickenIndex, int depth) {
        if (depth == M) {
            /**
             * M만큼의 집합 치킨집이 모였을 경우 여기 도착
             * 여기에 왔다는건 visited = true 가 무조건 3개일 테니 true인 치킨 거리를 구해서 결과값에 넣으면될듯
             */
            int totalStreetCount = 0; // 해당 그룹 도시의 치킨 거리
            for (int i = 0; i < houseArrayList.size(); i++) {
                int chickenStreet = Integer.MAX_VALUE;

                House house = houseArrayList.get(i);

                for (int j = 0; j < chickenArrayList.size(); j++) {
                    if (visited[j]) { // 집합에 속한 치킨집일 경우
                        Chicken chicken = chickenArrayList.get(j);

                        // 이 집의 치킨 거리 구하기 모든 치킨집을 돌며 가장 짧은 거리 저장
                        chickenStreet = Math.min(chickenStreet, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
                    }
                }
                // 결과 저장
                totalStreetCount += chickenStreet;
            }

            // 전체 결과에 더 작은그룹 거리를 저장
            result = Math.min(result, totalStreetCount);
            return ;
        }

        for (int i = chickenIndex; i < chickenArrayList.size(); i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }

    }

    private static class House {
        private int x;
        private int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Chicken {
        private int x;
        private int y;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
