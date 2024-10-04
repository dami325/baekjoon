package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[right];

        while (left <= right && right < n) {
            if (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= arr[left++];
            } else if (sum < s) {
                int end = ++right;
                if(end == n) break;
                sum += arr[end];
            }
        }


        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
        br.close();
    }
}
