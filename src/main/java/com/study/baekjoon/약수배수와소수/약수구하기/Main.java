package com.study.baekjoon.약수배수와소수.약수구하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                list.add(i);
            }
        }

        if (list.size() < K) {
            System.out.println(0);
        }else {
            System.out.println(list.get(K-1));
        }
    }
}
