package com.study.baekjoon.재귀.별찍기.풀이2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static char[][] starArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        starArr = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(starArr[i], ' ');
        }

        solve(0,0,N);

        StringBuilder sb = new StringBuilder();
        for (char[] chars : starArr) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void solve(int x, int y, int blockLength) {


        if (blockLength == 1) {
            starArr[x][y] = '*';
            return;
        }

        int size = blockLength / 3;

        int count = 0;
        for (int i = x; i < x + blockLength; i+=size) {
            for (int j = y; j < y + blockLength; j+=size) {
                System.out.println(String.format("i = %d, j = %d, blocklength = %d, size = %d", i, j, blockLength, size));
                count++;
                if (!(count == 5)) {
                    solve(i, j, size);
                }
            }
        }

    }
}
