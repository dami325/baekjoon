package com.study.baekjoon.항해99.챌린저27일차;

public class Main {

    public static void main(String[] args) {
        long solution = new Solution().solution(2, 2, 0, 0, new int[][]{
                {2, 1},
                {0, 1},
                {1, 1},
                {0, 1},
                {2, 1}
        });
        System.out.println(solution);
    }

}

class Solution {

    public long solution(int n, int m, int x, int y, int[][] queries) {
        long startRow = x, endRow = x;
        long startCol = y, endCol = y;

        // 쿼리를 역순으로 실행
        for (int i = queries.length - 1; i >= 0; i--) {
            int direction = queries[i][0];
            int range = queries[i][1];

            switch (direction) {
                case 0:
                    if (startCol != 0) startCol += range;
                    endCol = Math.min(m - 1, endCol + range);
                    break;
                case 1:
                    if (endCol != m - 1) endCol -= range;
                    startCol = Math.max(0, startCol - range);
                    break;
                case 2:
                    if (startRow != 0) startRow += range;
                    endRow = Math.min(n - 1, endRow + range);
                    break;
                case 3:
                    if (endRow != n - 1) endRow -= range;
                    startRow = Math.max(0, startRow - range);
                    break;
            }

            // 유효한 범위가 없어지면 바로 종료
            if (startRow > endRow || startCol > endCol) {
                return 0;
            }
        }

        // 가능한 시작점의 개수
        return (endRow - startRow + 1) * (endCol - startCol + 1);
    }
}

