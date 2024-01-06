package com.study.baekjoon.반복문.코딩은체육과목입니다;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N/4; i++) {
            sb.append("long ");
        }

        sb.append("int");

        System.out.println(sb.toString());

    }
}
