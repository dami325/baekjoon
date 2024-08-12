package com.study.baekjoon.항해99.챌린저22일차;

public class Main {
    public static void main(String[] args) {
        int solution = new Solution().maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }
        });

        System.out.println(solution);

    }
}
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int answer = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        int[] heights = new int[col];

        for (int y = 0; y < row; y++) {
            for (int c = 0; c < col; c++) {
                heights[c] = matrix[y][c] == '1' ? heights[c] + 1 : 0;
            }

            for (int x = 0; x < col; x++) {
                int h = Integer.MAX_VALUE;
                int w = 0;
                for(int t = x; t < col;t++){
                    h = Math.min(h, heights[t]);
                    w = t - x + 1;

                    answer = Math.max(answer, w * h);
                }

            }
        }
        return answer;
    }
}
