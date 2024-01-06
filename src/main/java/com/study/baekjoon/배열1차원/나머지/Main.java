package com.study.baekjoon.배열1차원.나머지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            list.add(solve(br.readLine()));
        }

        System.out.println(list.size());


    }

    public static int solve(String str) {
        return Integer.parseInt(str)%42;
    }
}
