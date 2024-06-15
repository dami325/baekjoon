package com.study.baekjoon.약수배수와소수.베르트랑공준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder sb = new StringBuilder();
            while (true) {
                int N = Integer.parseInt(br.readLine());

                if (N == 0) break;

                sb.append(primeCount(N))
                        .append("\n");
            }

            System.out.println(sb);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int primeCount(int num) {
        int count = 0;

        for (int i = num + 1; i <= num * 2; i++) {
            if(isPrime(i))
                count++;

        }

        return count;
    }

    private static boolean isPrime(int num) {
        if(num <= 1) return false;

        if(num <= 3 ) return true;

        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
