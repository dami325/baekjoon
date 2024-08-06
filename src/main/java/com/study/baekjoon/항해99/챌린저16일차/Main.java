package com.study.baekjoon.항해99.챌린저16일차;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4));
    }
}


class Solution {

    private int answer, n;
    private int[] arr;
    public int solution(int n) {
        this.n = n;

        arr = new int[n];

        solve(0);

        return answer;
    }

    private void solve(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if (valid(depth)) {
                solve(depth + 1);
            }
        }
    }

    private boolean valid(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            } else if (Math.abs(i - depth) == Math.abs(arr[i] - arr[depth])) {
                return false;
            }
        }

        return true;
    }
}