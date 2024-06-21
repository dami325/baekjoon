package com.study.baekjoon.약수배수와소수.가로수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }

            int gcd = list.get(0);

            for (int i = 1; i < n; i++) {
                gcd = gcd(gcd, list.get(i));
            }
            System.out.println(gcd);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
