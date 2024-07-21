package com.study.baekjoon.알고리즘분류.백트레킹.n과m5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static boolean[] visited;
    private static int[] arr, tmp, result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arr = new int[N + 1];
        tmp = new int[N + 1];
        result = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, N);

        dfs(0);

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            mergeSort(start, middle);
            mergeSort(middle + 1, end);
            merge(start, middle, middle + 1, end);

        }
    }

    private static void merge(int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int start = leftStart;
        int tepIndex = leftStart;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] <= arr[rightStart]) {
                tmp[tepIndex++] = arr[leftStart++];
            } else {
                tmp[tepIndex++] = arr[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            tmp[tepIndex++] = arr[leftStart++];
        }

        while (rightStart <= rightEnd) {
            tmp[tepIndex++] = arr[rightStart++];
        }

        for (int i = start; i <= rightEnd; i++) {
            arr[i] = tmp[i];
        }

    }
}
