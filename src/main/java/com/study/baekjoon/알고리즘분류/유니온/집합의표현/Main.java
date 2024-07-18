package com.study.baekjoon.알고리즘분류.유니온.집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (operator == 0) {
                union(a,b);
            }else {
                int nodeA = find(a);
                int nodeB = find(b);
                if (nodeA == nodeB) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        br.close();
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA != findB) {
            arr[findB] = findA;
        }
    }

    private static int find(int num) {
        if(num == arr[num]){
            return num;
        }else {
            int i = find(arr[num]);
            arr[num] = i;
            return i;
        }
    }
}
