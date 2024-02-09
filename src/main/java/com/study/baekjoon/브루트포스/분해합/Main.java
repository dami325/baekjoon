package com.study.baekjoon.브루트포스.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = Integer.parseInt(br.readLine());

        for (int i = 0; i < result; i++) {
            int 분해합 = 분해합(i);
            if (분해합 == result) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }

    public static int 분해합(int num){
        String str = String.valueOf(num);
        int sum = num;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return sum;
    }
}
