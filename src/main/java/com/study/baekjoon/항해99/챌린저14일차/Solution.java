package com.study.baekjoon.항해99.챌린저14일차;

import java.util.*;

class Solution {

    public int solution(int distance, int[] rocks, int n) {

        if (rocks.length == n) return distance;

        Arrays.sort(rocks);

        int[] d = new int[rocks.length + 1];
        d[0] = rocks[0];
        d[d.length - 1] = distance - rocks[rocks.length - 1];

        for (int i = 1; i < rocks.length; i++) {
            d[i] = rocks[i] - rocks[i - 1];
        }


        int left = 0;
        int right = distance;

        while (left < right) {


            int mid = (left + right) / 2;

            int removedStone = 0;
            int cur = 0;
            for (int i = 0; i < d.length; i++) {

                cur += d[i];

                if (cur < mid) {
                    removedStone++;
                } else {
                    cur = 0;
                }

            }

            if (removedStone < n) {
                left = mid + 1;
            } else if (removedStone > n) {
                right = mid;
            } else {
                left = mid + 1;
            }


        }

        return left - 1;

    }
}