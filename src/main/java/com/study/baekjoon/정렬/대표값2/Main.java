package com.study.baekjoon.정렬.대표값2;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int n = 5;
            int avg = 0;
            int middle = 0;
            int[] arr = new int[5];

            while (n-- > 0) {
                int number = Integer.parseInt(br.readLine());
                arr[n] = number;
                avg += number;
            }

            avg /= 5;
            int[] array = Arrays.stream(arr).sorted().toArray();

            bw.write(String.valueOf(avg));
            bw.newLine();
            bw.write(String.valueOf(array[2]));



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
