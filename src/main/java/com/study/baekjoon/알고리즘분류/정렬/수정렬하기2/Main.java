package com.study.baekjoon.알고리즘분류.정렬.수정렬하기2;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                bw.write(arr[i] + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
