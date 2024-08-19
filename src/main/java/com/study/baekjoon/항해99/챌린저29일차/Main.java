package com.study.baekjoon.항해99.챌린저29일차;

import java.util.Arrays;

class Solution {
    private static class Job implements Comparable<Job> {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job other) {
            return this.end - other.end;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // 종료 시간을 기준으로 정렬
        Arrays.sort(jobs);

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int includeProfit = jobs[i].profit;

            // 이진 탐색으로 겹치지 않는 이전 작업 찾기
            int l = binarySearch(jobs, i);
            if (l != -1) {
                includeProfit += dp[l];
            }

            // 현재 작업을 포함하는 경우와 포함하지 않는 경우 중 최대 이익 선택
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    // 이진 탐색으로 현재 작업과 겹치지 않는 마지막 작업의 인덱스 찾기
    private int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int answer = solution.jobScheduling(
                new int[]{
                        1, 2, 3, 3
                },
                new int[]{
                        3, 4, 5, 6
                },
                new int[]{
                        50, 10, 40, 70
                }
        );

        System.out.println(answer);
    }

}


