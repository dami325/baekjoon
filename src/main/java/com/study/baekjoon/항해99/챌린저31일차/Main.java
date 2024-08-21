package com.study.baekjoon.항해99.챌린저31일차;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[][] computers) {
        int[] unionFind = new int[n];

        for (int i = 0; i < n; i++) {
            unionFind[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length - 1; j++) {

                if (i == j)
                    continue;

                if (computers[i][j] == 1) {
                    union(unionFind, Math.min(i, j), Math.max(i, j));
                }

            }
        }

        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < unionFind.length; i++) {
            resultSet.add(find(unionFind, i));
        }

        return resultSet.size();
    }

    private void union(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        if (a != b) {
            arr[b] = a;
        }
    }

    private int find(int[] arr, int a) {
        if (a == arr[a])
            return a;

        int findA = find(arr, arr[a]);
        arr[a] = findA;

        return findA;
    }
}

public class Main {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        int result = solution.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        });

        System.out.println(result);
    }
}
