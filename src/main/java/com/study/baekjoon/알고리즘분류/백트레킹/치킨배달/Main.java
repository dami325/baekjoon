package com.study.baekjoon.알고리즘분류.백트레킹.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    /**
     * 도시에 있는 모든 치킨거리 에지 중 가장 가중치가 적은 M개만 남기고 폐업
     * <p>
     * 모든 가중치의 합을 출력
     * <p>
     * 먼저 에지가 기준이니 에지 리스트로 해본다.
     * <p>
     * 풀이
     * <p>
     * N , M 초기화
     * 0(빈칸), 1(집), 2(치킨집) 을 가진 NXN 배열 초기화
     * M만큼 집합으로 합계를 구해둬야 할듯
     * 그중 가장 작은 집합 출력
     * <p>
     * 하나의 집 [1,4]의 좌표가 있을 경우 나머지 치킨집 좌표가 모두 있으면[1,2],[4,1],[5,1],[5,2],[5,5]
     * 가장 가까운 치킨집 구하는 공식 = for(집[i]인접 리스트) min = Math.min(abs(집x -치킨x) +abs(집y - 치킨y))
     * <p>
     * 각 집에대해 가장 가까운 치킨거리 구할 수 있음
     * <p>
     * <p>
     * 1. 단순히 M을 가장 많은 가까운 집을 보유한 치킨집만 나두고 폐업한다면 그게 최적화일까?
     * 2. 치킨집의 모든 집에대한 거리의 합을 저장해두고 그게 가장 낮은 치킨집만 살아남으면 그게 최선인가?
     * 3. 치킨집의 M 그룹 조합을 해서 조합별 치킨거리를 구하고 그게 가장 낮은게 최선인가?
     */
    private static int N,M;
    private static boolean[] visited;
    private static ArrayList<ChickenNode> chickenList = new ArrayList<>();
    private static ArrayList<HomeNode> homeList = new ArrayList<>();
    private static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chickenList = new ArrayList<>();
        homeList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    chickenList.add(new ChickenNode(i, j));
                } else if (num == 1) {
                    homeList.add(new HomeNode(i, j));
                }
            }
        }


        visited = new boolean[chickenList.size()];

        sum = new int[M];

        dfs(0,0);


        br.close();
    }

    private static void dfs(int depth,int sum) {
        if (depth == M) {
            return;
        }

        for (int i = depth; i < chickenList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                ChickenNode chickenNode = chickenList.get(i);
                int chickenNodeX = chickenNode.getX();
                int chickenNodeY = chickenNode.getY();
                for (int j = 0; j < homeList.size(); j++) {
                    HomeNode homeNode = homeList.get(j);
                    int homeNodeX = homeNode.getX();
                    int homeNodeY = homeNode.getY();
                    int totalValue = Math.abs(homeNodeX - chickenNodeX) + Math.abs(homeNodeY - chickenNodeY);
                    if(totalValue < homeNode.getTotalValue()){
                        homeNode.setChickenX(chickenNodeX);
                        homeNode.setChickenY(chickenNodeY);
                        homeNode.setTotalValue(totalValue);
                    }
                    chickenNode.addTotal(totalValue);
                }
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static class ChickenNode {
        private int x;
        private int y;
        private int totalValue;

        public ChickenNode(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getTotalValue() {
            return totalValue;
        }

        public void addTotal(int totalValue) {
            this.totalValue += totalValue;
        }
    }

    private static class HomeNode {
        private int x;
        private int y;
        private int chickenX;
        private int chickenY;
        private int totalValue = 2500;

        public int getTotalValue() {
            return totalValue;
        }

        public void setTotalValue(int totalValue) {
            this.totalValue = totalValue;
        }

        public HomeNode(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getChickenX() {
            return chickenX;
        }

        public void setChickenX(int chickenX) {
            this.chickenX = chickenX;
        }

        public int getChickenY() {
            return chickenY;
        }

        public void setChickenY(int chickenY) {
            this.chickenY = chickenY;
        }
    }
}
