package com.study.baekjoon.항해99.챌린저4일차;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        class Solution {

            public int solution(String s) {

                int length = s.length();


                for (int size = 1; size <= s.length(); size++) {
                    Queue<String> q = new ArrayDeque<>();
                    for (int j = 0; j <= s.length() - size; j += size) {
                        String substring = s.substring(j, j + size);
                        q.offer(substring);
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

                    length = length > result.length() ? result.length() : length;

                }
                return length;
            }

        }

        System.out.println(new Solution().solution("abcabcabcabcdededededede"));
    }
}
