package com.study.baekjoon.재귀.알고리즘수업_병합정렬1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int k;
    private static int cnt = 0;
    private static int result = -1;
    private static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        tmp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, n - 1);

        System.out.println(result);
    }

    private static void mergeSort(int[] arr, int leftIndex, int rightIndex){
        if (cnt > k) {
            return;
        }
        // leftIndex는 항상 0 즉 오른쪽 인덱스가 1 이상일경우만 수행
        if (leftIndex < rightIndex) {
            int index = leftIndex + rightIndex;
            int middleIndex = index / 2;
            mergeSort(arr, leftIndex,middleIndex); // 0 ~ 중간까지
            mergeSort(arr, middleIndex + 1, rightIndex); // 중간+1 ~ 끝까지
            merge(arr, leftIndex, middleIndex, rightIndex); // 병합 수행
        }
    }

    private static void merge(int[] arr, int leftIndex, int middleIndex, int lastIndex){
        int leftStart = leftIndex;
        int rightStart = middleIndex + 1;
        int tmpIndex = 0;

        while (leftStart <= middleIndex && rightStart <= lastIndex) {
            if (arr[leftStart] < arr[rightStart]) {
                tmp[tmpIndex] = arr[leftStart];
                leftStart++;
            } else {
                tmp[tmpIndex] = arr[rightStart];
                rightStart++;
            }
            tmpIndex++;
        }

        while (leftStart <= middleIndex) {
            tmp[tmpIndex++] = arr[leftStart++];
        }

        while (rightStart <= lastIndex) {
            tmp[tmpIndex++] = arr[rightStart++];
        }

        tmpIndex = 0;
        for (int i = leftIndex; i <= lastIndex; i++) {
            cnt++;
            if(cnt == k){
                result = tmp[tmpIndex];
                break;
            }
            arr[i] = tmp[tmpIndex++];
        }
    }
}
