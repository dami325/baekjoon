package com.study.baekjoon.일반.저항;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            StringBuilder sb = new StringBuilder();

            int t = Integer.parseInt(br.readLine());
            // 소수 구하기 = 소수 false
            boolean[] num = new boolean[1000001];

            for (int i = 2; i <= 1000000; i++) {
                num[i] = isPrime(i);
            }

            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int count = 0;
                for (int j = 2; j <= n / 2; j++) {
                    if (num[j] && num[n - j]) {
                        count++;
                    }
                }
                sb.append(count).append("\n");
            }


            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
