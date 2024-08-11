package com.study.baekjoon.항해99.챌린저21일차;

class Solution {

    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if(j ==  triangle[i].length - 1){
                    triangle[i][j] += triangle[i - 1][j - 1];
                }else {
                    int left = triangle[i - 1][j - 1];
                    int right = triangle[i - 1][j];

                    triangle[i][j] += Math.max(left, right);
                }
            }
        }

        int answer = 0;
        int lastIndex = triangle.length - 1;
        for (int cost : triangle[lastIndex]) {
            answer = Math.max(answer, cost);
        }

        return answer;
    }

}
public class Main {
    public static void main(String[] args) {

        int solution = new Solution().solution(new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        });

        System.out.println(solution);
    }
}


