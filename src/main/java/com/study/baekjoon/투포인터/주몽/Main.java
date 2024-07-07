package com.study.baekjoon.투포인터.주몽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int leftIndex = 0;
        int rightIndex = n - 1;
        int count = 0;
        int sum = 0;

        while (rightIndex > 0) {

            if (leftIndex == rightIndex) {
                leftIndex = 0;
                rightIndex--;
                continue;
            }

            sum = arr[leftIndex] + arr[rightIndex];

            if (sum == m) {
                count++;
            }

            leftIndex++;
        }

        System.out.println(count);

    }
}
