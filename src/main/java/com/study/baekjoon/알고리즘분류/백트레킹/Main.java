package com.study.baekjoon.알고리즘분류.백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static int[] arr;
    private static boolean[] visit;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 재귀 호출 시 방문한 인덱스 추적용
            visit = new boolean[N];

            // 배열 범위가 꽉차면 다음 재귀 호출
            arr = new int[M];

            // 초기 시작 인덱스 0 설정
            append(0);

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void append(int index) {

        if (index == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

            if (visit[i] == false) {

                visit[i] = true;

                arr[index] = i + 1;

                append(index + 1);

                visit[i] = false;
            }
        }
    }
}
