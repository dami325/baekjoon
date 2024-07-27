package com.study.baekjoon.항해99.챌린저6일차;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[][] data, int col, int row_begin, int row_end) {
                int selectIndex = col - 1;

                Arrays.sort(data,(o1, o2) -> {
                    if (o1[selectIndex] == o2[selectIndex]) {
                        return o2[0] - o1[0];
                    }
                    return o1[selectIndex] - o2[selectIndex];
                });

                List<Integer> si = new ArrayList<>();

                for (int i = row_begin - 1; i <= row_end - 1; i++) {
                    int[] sortDatum = data[i];
                    int result = 0;
                    for (int j = 0; j < sortDatum.length; j++) {
                        result += sortDatum[j] % (i + 1);
                    }
                    si.add(result);
                }

                return si.stream().reduce(0, (integer, integer2) -> integer ^ integer2);
            }

        }

        int[][] data = new int[][]{
                {2, 2, 6},
                {1, 5, 10},
                {4, 2, 9},
                {3, 8, 3}
        };

        int col = 2;
        int row_begin=2;
        int row_end=3;

        int solution = new Solution().solution(data, col, row_begin, row_end);

    }
}
