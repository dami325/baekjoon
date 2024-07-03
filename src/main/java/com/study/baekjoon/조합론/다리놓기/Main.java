package com.study.baekjoon.조합론.다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(br.readLine());

            StringTokenizer st = null;
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                sb.append(factorial(m).divide(factorial(n).multiply(factorial(m - n)))).append("\n");
            }

            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 검증
         * System.out.println(factorial(29).divide(factorial(13).multiply(factorial(29-13))));
         * 67863915
         *
         * n m = answer
         * 1 5 = 5
         * 2 5 = 10
         * 3 5 = 10
         * 4 5 = 5
         * 5 5 = 1
         *
         * 120 / 24 = 5
         * 2*2*2*2*2
         * 1*2*3*4
         */

    }

    static BigInteger factorial(int num) {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
