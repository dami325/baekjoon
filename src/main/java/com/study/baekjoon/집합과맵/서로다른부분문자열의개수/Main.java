package com.study.baekjoon.집합과맵.서로다른부분문자열의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String str = br.readLine();

            solve(str);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(String str) {
        Set<String> set = new HashSet<>();

        int length = str.length();

        for (int i = 0; i < length; i++) {

            for (int j = i + 1; j <= length; j++) {

                set.add(str.substring(i, j));

            }

        }
        System.out.println(set.size());
    }
}
