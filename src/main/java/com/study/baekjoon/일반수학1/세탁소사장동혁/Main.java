package com.study.baekjoon.일반수학1.세탁소사장동혁;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int q = 25;
        int d = 10;
        int n = 5;
        int p = 1;

        for (int i = 0; i < T; i++) {
            int result = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            int rq = result / q;
            result %= q;
            int rd = result / d;
            result %= d;
            int rn = result / n;
            result %= n;
            int rp = result / p;

            sb.append(rq);
            sb.append(" ");
            sb.append(rd);
            sb.append(" ");
            sb.append(rn);
            sb.append(" ");
            sb.append(rp);

            System.out.println(sb.toString());
        }

    }
}
