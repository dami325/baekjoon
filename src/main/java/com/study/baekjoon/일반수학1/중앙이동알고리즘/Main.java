package com.study.baekjoon.일반수학1.중앙이동알고리즘;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 4;
        int start = 5;
        int square = 1;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < square; j++) {
                result += start;
                start += 2;
            }
            if (square == 1) {
                square = 2;
            }else {
                square *= 2;
            }
        }

        System.out.println(result);

    }
}
