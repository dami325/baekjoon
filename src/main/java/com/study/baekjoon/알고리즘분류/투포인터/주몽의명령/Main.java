package com.study.baekjoon.알고리즘분류.투포인터.주몽의명령;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 재료개수
        int M = sc.nextInt(); // 갑옷만드는데 필요한수


        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = N - 1;
        int count = 0;

        int[] array = Arrays.stream(arr).sorted().toArray();

        int sum = 0;
        while (start != end) {
            sum = array[start] + array[end];
            if (sum == M) {
                count++;
                if(start + 1 == end) break;
                start++;
                end--;
            } else if (sum > M) {
                end--;
            } else if (sum < M) {
                start++;
            }
        }
        System.out.println(count);

    }
}
