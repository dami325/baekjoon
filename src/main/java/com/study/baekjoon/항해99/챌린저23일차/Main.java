package com.study.baekjoon.항해99.챌린저23일차;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int maximizedCapital = new Solution().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        System.out.println(maximizedCapital);
    }
}

class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new Project(profits[i], capital[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().cost <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            w += maxProfitHeap.poll().profit;
        }

        return w;
    }

    private class Project {
        int profit;
        int cost;

        public Project(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }
}
