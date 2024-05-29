package com.study.baekjoon.집합과맵.문자열집함;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        Set<String> arr = new HashSet<>();

        for (int i = 0; i < N ; i++) {
            arr.add(br.readLine());
        }

        for (int i = 0; i < M ; i++) {
            if(arr.contains(br.readLine())) count++;
        }

        System.out.println(count);

    }
}
