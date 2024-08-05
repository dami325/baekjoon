package com.study.baekjoon.항해99.챌린저15일차;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        class Solution {

            private boolean[] visited;
            private String n;
            private int depth = 1;
            private Set<Integer> set = new HashSet<>();

            public int solution(String numbers) {

                n = numbers;

                visited = new boolean[n.length()];

                for (int i = 0; i < n.length(); i++) {

                    dfs(0, "");

                    depth++;

                    if (depth > n.length()) {
                        break;
                    }

                }

                return set.size();
            }

            private void dfs(int depth, String str) {
                if (depth == this.depth) {
                    int number = Integer.parseInt(str);
                    isDecimal(number);
                    return;
                }

                for (int i = 0; i < n.length(); i++) {
                    if (!visited[i]) {
                        visited[i] = true;
                        dfs(depth + 1, str + n.charAt(i));
                        visited[i] = false;
                    }
                }


            }

            private void isDecimal(int number) {
                if (number <= 1) {
                    return;
                }

                if (number <= 3) {
                    set.add(number);
                    return;
                }

                if (number % 2 == 0 || number % 3 == 0) {
                    return;
                }

                for (int i = 5; i * i <= number; i += 6) {
                    if (number % i == 0 || number % (i + 2) == 0) {
                        return;
                    }
                }

                set.add(number);

            }

        }

        System.out.println(new Solution().solution("1231"));
    }
}
