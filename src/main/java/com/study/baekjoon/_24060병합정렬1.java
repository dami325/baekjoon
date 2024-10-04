package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24060병합정렬1 {

    private static int count, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        int[] arr = new int[a];
        int[] temp = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr,temp, 0, a - 1);

        if(count < k) {
            System.out.println(-1);
        }
    }

    // start = 1, end = 5, middle = 2
    private static void mergeSort(int[] arr,int[] temp, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr,temp, start, middle);
            mergeSort(arr,temp, middle + 1, end);
            merge(arr,temp, start, middle, middle + 1, end);
        }
    }

    private static void merge(int[] arr,int[] temp, int start, int middle, int rightStart , int end) {
        int leftIndex = start;
        int tempIndex = start;
        while (start <= middle && rightStart <= end) {
            if (arr[start] <= arr[rightStart]) {
                temp[tempIndex++] = arr[start++];
            } else {
                temp[tempIndex++] = arr[rightStart++];
            }
        }

        while (start <= middle) {
            temp[tempIndex++] = arr[start++];
        }

        while (rightStart <= end) {
            temp[tempIndex++] = arr[rightStart++];
        }

        for (int i = leftIndex; i <= end; i++) {
            count++;
            arr[i] = temp[i];
            if(count == k) {
                System.out.println(temp[i]);
                System.exit(0);

            }
        }
    }
}
