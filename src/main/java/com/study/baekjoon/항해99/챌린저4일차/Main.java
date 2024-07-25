package com.study.baekjoon.항해99.챌린저4일차;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        class Solution {

            public int solution(String s) {
                int answer = 0;

                char[] charArray = s.toCharArray();

                List<Integer> result = new ArrayList<>();

                for (int i = 0; i < s.length(); i++) {

                    for (int j = 0; j < s.length(); j++) {
                        s.substring(j, j + 1);
                    }

                }

                return answer;
            }

        }

        System.out.println(new Solution().solution("aabbaccc"));
    }
}
