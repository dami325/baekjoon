package com.study.baekjoon.항해99.챌린저42일차;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;

        // 문제들 중 가장 높은 알고력과 코딩력을 구함
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            for (int j = 0; j <= maxCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                if (i + 1 <= maxAlp) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                if (j + 1 <= maxCop) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int nextAlp = Math.min(maxAlp, i + problem[2]);
                        int nextCop = Math.min(maxCop, j + problem[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}

public class Main {

    private static final Solution solution = new Solution();
    public static void main(String[] args) {
        System.out.println(solution.solution(10,10,new int[][]{
                {10,15,2,1,2},
                {20,20,3,3,4}
        }));
    }
}
