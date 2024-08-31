package com.study.baekjoon.항해99.챌린저41일차;


class Solution {
    public int solution(int[] money) {
        int[] firstDp = new int[money.length];
        int[] secondDp = new int[money.length];

        if (money.length == 3) {
            int maxNum = 0;

            for (int amount : money) {
                maxNum = Math.max(amount, maxNum);
            }

            return maxNum;
        }

        for (int i = 0; i < money.length; i++) {
            firstDp[i] = money[i];
            secondDp[i] = money[i];
        }


        firstDp[1] = -1;
        firstDp[2] += firstDp[0];


        secondDp[0] = -1;

        // dp[i] = Math.max(money[i - 2], mony[i - 3])
        for (int i = 3; i < money.length; i++) {
            firstDp[i] += Math.max(firstDp[i - 2], firstDp[i - 3]);
            secondDp[i] += Math.max(secondDp[i - 2], secondDp[i - 3]);
        }

        int firstMax = Math.max(firstDp[firstDp.length - 2], firstDp[firstDp.length - 3]);
        int secondMax = Math.max(secondDp[secondDp.length - 1], secondDp[secondDp.length - 2]);

        return Math.max(firstMax,secondMax);
    }
}

public class Main {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.solution(new int[]{1, 2, 3}));
    }
}
