package com.study.baekjoon.항해99.챌린저40일차;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        int divide = 1_000_000_007;

        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) continue;

                if (dp[i - 1][j] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) % divide;
                }

                if (dp[i][j - 1] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1])% divide;
                }
            }
        }


        return dp[n][m];
    }
}

public class Main {

    private static final Solution solution = new Solution();
    public static void main(String[] args) {
        System.out.println(solution.solution(4,3,new int[][]{{2,2}}));
    }

}
