package com.study.baekjoon.약수배수와소수.창문닫기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            boolean[] window = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < window.length; j++) {
                    if (j % i == 0) {
                        window[j] = !window[j];
                    }
                }
            }

            int result =0;
            for (boolean w : window) {
                if (w) {
                    result++;
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
