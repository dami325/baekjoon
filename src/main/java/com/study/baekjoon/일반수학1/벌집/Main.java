package com.study.baekjoon.일반수학1.벌집;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int start = 1;

        for (int i = 1; i <= N; i++) {

            if (N <= start) {
                System.out.println(i);
                break;
            }

            start += 6 * i;

        }

    }
}
