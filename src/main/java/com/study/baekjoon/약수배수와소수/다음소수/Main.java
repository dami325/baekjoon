package com.study.baekjoon.약수배수와소수.다음소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                long num = Long.parseLong(br.readLine());
                sb.append(findNextPrime(num)).append("\n");
            }

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long findNextPrime(long num) {
        if (num <= 2) {
            return 2;
        }
        long candidate = num;
        while (!isPrime(candidate)) {
            candidate++;
        }
        return candidate;
    }

    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
