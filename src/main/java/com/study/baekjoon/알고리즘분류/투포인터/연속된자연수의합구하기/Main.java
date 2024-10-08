package com.study.baekjoon.알고리즘분류.투포인터.연속된자연수의합구하기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while (end != N) {
            if (sum == N) {
                count++;
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else if (sum < N) {
                end ++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
