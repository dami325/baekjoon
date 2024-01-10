package com.study.baekjoon.심화1.너의평점은;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    private static final Map<String, Double> scoreMap = Map.of(
            "A+", 4.5d,
            "A0", 4.0d,
            "B+", 3.5d,
            "B0", 3.0d,
            "C+", 2.5d,
            "C0", 2.0d,
            "D+", 1.5d,
            "D0", 1.0d,
            "F", 0.0d
    );
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double result = 0d;
        double myScoreTotal = 0d;

        for (int i = 0; i < 20; i++) {
            String line = br.readLine();

            String[] split = line.split(" ");

            String grade = split[2];
            if (!grade.equals("P")) {
                double myScore = Double.valueOf(split[1]);
                double gradeScore = scoreMap.get(grade);

                result += myScore * gradeScore;
                myScoreTotal += myScore;
            }

        }
        System.out.println(result/myScoreTotal);
    }
}
