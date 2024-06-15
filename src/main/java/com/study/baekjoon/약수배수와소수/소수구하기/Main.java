package com.study.baekjoon.약수배수와소수.소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            for (int i = M; i <= N; i++) {
                if(isPrimeNumber(i)){
                    sb.append(i).append("\n");
                };
            }
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 소수 판별 메서드
    public static boolean isPrimeNumber(int num) {
        if(num <= 1){
            return false;
        }

        if(num <= 3){
            return true;
        }

        if(num%2 == 0 || num%3 == 0){
            return false;
        }

        for(int i = 5; i*i <= num; i+=6){
            if(num%i == 0 || num%(i+2) == 0){
                return false;
            }
        }

        return true;
    }

}
