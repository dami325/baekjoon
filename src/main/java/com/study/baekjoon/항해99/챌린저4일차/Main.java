package com.study.baekjoon.항해99.챌린저4일차;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        class Solution {

            public int solution(String s) {

                int length = s.length();


                for (int size = 1; size <= s.length() / 2; size++) {
                    Queue<String> q = new ArrayDeque<>();
                    for (int j = 0; j <= s.length() - size; j += size) {
                        q.offer(s.substring(j, j + size));
                    }

                    String result = s;
                    while (!q.isEmpty()) {
                        int count = 1;
                        String left = q.poll();
                        while (left.equals(q.peek())) {
                            left = q.poll();
                            count++;
                        }
                        if (count > 1) {
                            String replace = "";
                            for (int i = 0; i < count; i++) {
                                replace += left;
                            }
                            result = result.replaceFirst(replace, count + left);
                        }
                    }

                    length = Math.min(length, result.length());

                }
                return length;
            }
        }

        System.out.println(new Solution().solution("abcabcabcabcdededededede"));
    }
}
