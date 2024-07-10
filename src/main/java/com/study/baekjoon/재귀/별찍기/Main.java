package com.study.baekjoon.재귀.별찍기;

import java.util.Scanner;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static char[][] chars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        chars = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = ' ';
            }
        }

        solve(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(chars[i][j]);
            }
            sb.append("\n");
        }
//        System.out.println(sb);
    }

    private static void solve(int x, int y, int n){

        if (n == 1) {
            chars[x][y] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    System.out.println("x + i * (n/3) = " + (x + i * (n/3)) + ", y + j * (n/3) = " + (y + j * (n/3)) + ", n/3 = " + (n/3) );
                    solve(x + i * (n/3), y + j * (n/3), n / 3);
                }
            }
        }
    };
}
