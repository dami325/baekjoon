package com.study.baekjoon.step3.별찍기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String result = "";
            for (int j = 0; j <= i; j++) {
                result += "*";
                if (j == i) {
                    System.out.println(result);
                }
            }
        }
    }
}
