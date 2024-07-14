package com.study.baekjoon.알고리즘분류.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] A;
    private static int[] tmp;
    private static int N;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            A = new int[N];
            tmp = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            mergeSort(0, N - 1); // 1. 정렬
//            Arrays.sort(A);

            for (int i = 0; i < M; i++) {
                int value = Integer.parseInt(st.nextToken());
                System.out.println(binarySearch(value, 0, N - 1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int binarySearch(int value, int start, int end) {

        if (start > end) {
            return 0;
        }

        int middleIndex = (start + end) / 2;

        int middleValue = A[middleIndex];

        if (value == middleValue) {
            return 1;
        }

        if (value < middleValue) {
            return binarySearch(value, start, middleIndex - 1);
        } else {
            return binarySearch(value,middleIndex + 1, end);
        }
    }

    private static void mergeSort(int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int totalIndex = startIndex + endIndex;
            int middleIndex = totalIndex / 2;
            mergeSort(startIndex, middleIndex);
            mergeSort(middleIndex + 1, endIndex);
            merge(startIndex, middleIndex, middleIndex + 1, endIndex);
        }
    }

    private static void merge(int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int start = leftStart;
        int tmpIndex = 0;

        // 비교
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (A[leftStart] <= A[rightStart]) {
                tmp[tmpIndex] = A[leftStart++];
            } else {
                tmp[tmpIndex] = A[rightStart++];
            }
            tmpIndex++;
        }

        // 나머지
        while (leftStart <= leftEnd) {
            tmp[tmpIndex++] = A[leftStart++];
        }

        while (rightStart <= rightEnd) {
            tmp[tmpIndex++] = A[rightStart++];
        }

        tmpIndex = 0;
        for (int i = start; i <= rightEnd; i++) {
            A[i] = tmp[tmpIndex++];
        }
    }


}
