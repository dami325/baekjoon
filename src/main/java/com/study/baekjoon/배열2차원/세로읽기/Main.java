package com.study.baekjoon.배열2차원.세로읽기;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[][] arr = new String[5][15];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }
        String result = "";
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                result += arr[i][j] == null ? "" : arr[i][j];
            }
        }
        System.out.println(result);
    }
}
