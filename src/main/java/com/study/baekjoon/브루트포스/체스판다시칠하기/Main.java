package com.study.baekjoon.브루트포스.체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        String[][] arr = new String[N][M];

        // 2차원배열에 값 세팅
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) + "";
            }
        }

        String white = "W";
        String black = "B";

        int length = N - 8 + 1; // 세로 경우의수 구하기
        int width = M - 8 + 1; // 가로 경우의수 구하기

        int numberOfCases = length * width; // 총 경우의수
        int result = 64; //
        int count = 0;

        // 1) 8x8 바둑판의 최대 바꿔야하는수 64;
        // 2) 최대 바꿔야하는수(64) - 블랙이나 화이트로 시작하는 바둑판의 바꿔야하는수(3) = 나머지 경우의 수 (61)

        String[] startBoard = {"B", "W"};

        for (int i = 0; i < length; i++) { // 세로의 경우의 수만큼 반복
            for (int j = 0; j < width; j++) { // 가로 경우의 수만큼 반복

                for (int n = i; n < i + 8; n++) { // 세로 배열 인덱스 n
                    String first = startBoard[n % 2];
                    for (int m = j; m < j + 8; m++) { // 가로 배열 인덱스 m
                        if (m % 2 == 0) { //짝수 칸은 first와 같아야함
                            if (!first.equals(arr[n][m]))
                                count++;
                        } else { // 홀수 칸은 first와 달라야함
                            if (first.equals(arr[n][m]))
                                count++;
                        }
                    }
                }
                result = Math.min(result, Math.min(count, 64 - count));
                count = 0;
            }
        }

        System.out.println(result);

    }
}
