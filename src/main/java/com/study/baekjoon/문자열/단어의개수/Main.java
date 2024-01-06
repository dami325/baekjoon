package com.study.baekjoon.문자열.단어의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String trim = s.trim();

        if (trim.length() > 0) {

            String[] split = trim.split(" ");

            System.out.println(split.length);
        } else {
            System.out.println("0");
        }
    }
}
