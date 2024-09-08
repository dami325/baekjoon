package com.study.baekjoon.알고리즘분류.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신나는함수실행 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        while (!line.equals("-1 -1 -1")) {

            String[] strArr = line.split(" ");

            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            int c = Integer.parseInt(strArr[2]);

            sb.append(String.format("",w(a, b, c)));

            line = br.readLine();
        }

        System.out.println(sb.toString());

    }

    static int w(int a, int b, int c) {

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if(a < b && b < c) {
            return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
