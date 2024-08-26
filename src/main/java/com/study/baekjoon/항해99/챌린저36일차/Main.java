package com.study.baekjoon.항해99.챌린저36일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean[] visitedCol;
    private static int minValue = Integer.MAX_VALUE;
    private static int maxValue = Integer.MIN_VALUE;
    private static int n;
    private static int[][] dominoBoard;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            n = Integer.parseInt(br.readLine());
            dominoBoard = new int[n][n];
            visitedCol = new boolean[n];

            for (int i = 0; i < n; i++) {

                String line = br.readLine();

                for (int j = 0; j < n; j++) {
                    char dominoValue = line.charAt(j);
                    if ('A' <= dominoValue && dominoValue <= 'I') {
                        dominoBoard[i][j] = '@' - dominoValue; // @ = 64 ,A = 65
                    } else {
                        dominoBoard[i][j] = dominoValue - '0';
                    }
                }
            }


            // 0행에서 뽑는 도미노의 행을 1씩 증가시키면서 조합을 구한다.
            for (int i = 0; i < n; i++) {
                dfs(new int[n], 0, i);
            }

            System.out.println(minValue);
            System.out.println(maxValue);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int[] result, int r, int c) {
        result[r] = c;
        visitedCol[c] = true;

        if (r == n - 1) {
            // 모든 도미노를 선택한 경우, 점수 계산
            int score = (countCycle(result) % 2 == 0 ? -1 : 1) * getScore(result);
            minValue = Math.min(minValue, score);
            maxValue = Math.max(maxValue, score);
        } else {
            // 다음 행에서 선택할 도미노 찾기
            for (int i = 0; i < n; i++) {
                if (visitedCol[i]) continue;
                dfs(result, r + 1, i);
            }
        }

        // 백트래킹을 위해 현재 상태 복원
        result[r] = 0;
        visitedCol[c] = false;
    }

    private static int countCycle(int[] arr) {
        boolean[] visit = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            count++;
            int cur = i;
            while (!visit[cur]) {
                visit[cur] = true;
                cur = arr[cur];
            }
        }
        return count;
    }

    private static int getScore(int[] arr) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= dominoBoard[i][arr[i]];
        }
        return result;
    }

}
