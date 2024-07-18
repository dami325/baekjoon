package com.study.baekjoon.알고리즘분류.백트레킹.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 도시에 있는 모든 치킨거리 에지 중 가장 가중치가 적은 M개만 남기고 폐업
     *
     * 모든 가중치의 합을 출력
     *
     * 먼저 에지가 기준이니 에지 리스트로 해본다.
     *
     * 풀이
     *
     * N , M 초기화
     * 0(빈칸), 1(집), 2(치킨집) 을 가진 NXN 배열 초기화
     * M만큼 집합으로 합계를 구해둬야 할듯
     * 그중 가장 작은 집합 출력
     */
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }



        br.close();
    }
}
