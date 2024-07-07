package com.study.baekjoon.알고리즘분류.정렬.소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//    public static void main(String[] args) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
//
//            int num = Integer.parseInt(br.readLine());
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    // 메인 메서드
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        printArray(array);
    }

    // 합병 정렬 메서드
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 좌측 절반 정렬
            mergeSort(array, left, mid);

            // 우측 절반 정렬
            mergeSort(array, mid + 1, right);

            // 정렬된 두 하위 배열 합병
            merge(array, left, mid, right);
        }
    }

    // 두 개의 하위 배열 합병 메서드
    public static void merge(int[] array, int left, int mid, int right) {
        // 하위 배열 크기 계산
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 임시 배열 생성
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 데이터 복사
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // 임시 배열의 데이터를 병합하여 원래 배열에 정렬
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 남아 있는 요소 복사
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // 배열 출력 메서드
    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
