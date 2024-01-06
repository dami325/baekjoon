package com.study.baekjoon.배열1차원.평균;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");

        List<Integer> list = Arrays.stream(scores)
                .map(Integer::parseInt).sorted().collect(Collectors.toList());

        Integer max = list.get(list.size() - 1);
        double newAvg = max;

        double result = 0;
        for (Integer score : list) {
            result += (score/newAvg) * 100;
        }

        System.out.println(result / count);
    }
}
