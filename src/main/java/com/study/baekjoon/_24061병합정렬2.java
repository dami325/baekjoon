package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24061병합정렬2 {

    private static int[] a, temp;
    private static int n, k,count;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        temp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(-1);

        mergeSort(0, n - 1);

        System.out.println(sb.toString());

        br.close();
    }

    public static void mergeSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2;
            mergeSort(startIndex, middle);
            mergeSort(middle + 1, endIndex);
            merge(startIndex,middle,middle+1,endIndex);
        }
    }

    public static void merge(int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int start = leftStart;
        int tempIndex = leftStart;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (a[leftStart] <= a[rightStart]) {
                temp[tempIndex++] = a[leftStart++];
            }else {
                temp[tempIndex++] = a[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            temp[tempIndex++] = a[leftStart++];
        }

        while (rightStart <= rightEnd) {
            temp[tempIndex++] = a[rightStart++];
        }

        for (int i = start; i <= rightEnd; i++) {
            count++;
            a[i] = temp[i];
            if(count == k) {
                sb.setLength(0);
                for (int j = 0; j < a.length; j++) {
                    sb.append(a[j]).append(" ");
                }
            }
        }

    }
}
