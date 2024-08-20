package com.study.baekjoon.항해99.챌린저30일차;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minOperations(int[] target, int[] arr) {
        // Step 1: Target 배열의 인덱스를 매핑
        Map<Integer, Integer> targetIndexMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            targetIndexMap.put(target[i], i);
        }

        // Step 2: arr 배열을 target 인덱스 배열로 변환
        List<Integer> targetIndices = new ArrayList<>();
        for (int num : arr) {
            if (targetIndexMap.containsKey(num)) {
                targetIndices.add(targetIndexMap.get(num));
            }
        }

        // Step 3: 변환된 배열에서 LIS 찾기
        return target.length - lengthOfLIS(targetIndices);
    }

    private int lengthOfLIS(List<Integer> nums) {
        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            int pos = binarySearch(lis, num);
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }
        return lis.size();
    }

    // Collections.binarySearch()를 직접 구현한 이진 탐색 메서드
    private int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) == target) {
                return mid;
            } else if (lis.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;  // target이 들어가야 할 위치를 반환
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] target = {5, 1, 3};
        int[] arr = {9, 4, 2, 3, 4};
        System.out.println(solution.minOperations(target, arr));  // 출력: 2

        int[] target2 = {6, 4, 8, 1, 3, 2};
        int[] arr2 = {4, 7, 6, 2, 3, 8, 6, 1};
        System.out.println(solution.minOperations(target2, arr2));  // 출력: 3
    }
}

