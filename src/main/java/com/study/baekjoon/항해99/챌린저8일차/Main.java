package com.study.baekjoon.항해99.챌린저8일차;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {

        class Solution {
            public int solution(int[] queue1, int[] queue2) {
                int answer = -1;
                
                ArrayDeque<Integer> q1 = new ArrayDeque<>(queue1.length);
                ArrayDeque<Integer> q2 = new ArrayDeque<>(queue1.length);
                
                long q1Sum = 0;
                long q2Sum = 0;
                for (int i = 0; i < queue1.length; i++) {
                    int e1 = queue1[i];
                    int e2 = queue2[i];
                    
                    q1Sum += e1;
                    q2Sum += e2;
                    
                    q1.offer(e1);
                    q2.offer(e2);
                }

                if ((q1Sum + q2Sum) % 2 != 0) {
                    return answer;
                }

                long target = (q1Sum + q2Sum) / 2;

                int count = 0;
                while (true) {
                    if (q1Sum == target || q2Sum == target) {
                        break;
                    } else if (count > (q1.size() + q2.size()) *2) {
                        return -1;
                    }
                    if (q1.isEmpty() || q2.isEmpty()) {
                        return -1;
                    } else if (q1Sum > target) {
                        Integer pop = q1.pop();
                        q2.offer(pop);
                        q1Sum -= pop;
                        q2Sum += pop;
                    } else if (q2Sum > target) {
                        Integer pop = q2.pop();
                        q1.offer(pop);
                        q2Sum -= pop;
                        q1Sum += pop;
                    }
                    count++;
                }
                
                return count;
            }
        }

        Solution solution = new Solution();
        solution.solution(new int[]{1, 1}, new int[]{1, 5});
    }
}
