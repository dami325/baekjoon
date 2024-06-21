package com.study.baekjoon.스택큐덱.괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String VPS = "()";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(vps(str))
                sb.append("YES").append("\n");

            else
                sb.append("NO").append("\n");
        }

        System.out.println(sb);

    }

    private static boolean vps(String str) {
        int beforeLength = str.length();

        if (beforeLength % 2 != 0) {
            return false;
        }

        String replace = str.replace(VPS, "");

        int newStrLength = replace.length();

        if (newStrLength == beforeLength) {
            return false;
        }

        if (newStrLength == 0) {
            return true;
        }

        return vps(replace);
    }
}
