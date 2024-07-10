package com.study.baekjoon.재귀.칸토어집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int start = 3;

        String str;
        while ((str = br.readLine()) != null){
            int n = Integer.parseInt(str);
            sb = new StringBuilder();
            int start = (int) Math.pow(3, n);

            for (int i = 0; i < start; i++) {
                sb.append("-");
            }

            solve(0, start);
            System.out.println(sb);

        }
    }

    private static void solve(int start, int size) {
        if (size == 1) {
            return;
        }
        int newSize = size / 3;

        for (int i = start + newSize; i < start + newSize * 2; i++) {
            sb.setCharAt(i,' ');
        }

        solve(start, newSize);
        solve(start+ newSize*2, newSize);
    }

}
