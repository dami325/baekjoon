package com.study.baekjoon.알고리즘분류.정렬.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 좌표 압축이란
 * 수의 범위가 큰 상태에서 수의 값과 상관 없이 숫자 간의 대소관계만 알면 될 때 이용하는 알고리즘
 * <p>
 * [입력으로 주어진 숫자를 서로 비교하여 자기보다 작은 수를 세는 알고리즘]
 */
public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Integer N = Integer.parseInt(br.readLine());

            Integer[] arr = new Integer[N];
            HashSet<Integer> integers = new HashSet<>();

            String[] split = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(split[i]);
                integers.add(arr[i]);
            }

            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();

            int j = 0;

            List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());

            for(int i : collect) {
                integerIntegerHashMap.put(i, j++);
            }

            StringBuilder sb= new StringBuilder();
            for (Integer integer : arr) {
                sb.append(integerIntegerHashMap.get(integer)).append(" ");
            }

            System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
