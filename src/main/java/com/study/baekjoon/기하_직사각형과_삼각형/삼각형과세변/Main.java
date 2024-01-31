package com.study.baekjoon.기하_직사각형과_삼각형.삼각형과세변;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 문제
         * 삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
         * Equilateral :  세 변의 길이가 모두 같은 경우
         * Isosceles : 두 변의 길이만 같은 경우
         * Scalene : 세 변의 길이가 모두 다른 경우
         * 단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
         * 세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
         * 입력
         * 각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
         * 출력
         * 각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.
         * 예제 입력 1
         * 7 7 7
         * 6 5 4
         * 3 2 5
         * 6 2 6
         * 0 0 0
         * 예제 출력 1
         * Equilateral
         * Scalene
         * Invalid
         * Isosceles
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0) {
                break;
            }
            int sum = A + B + C;
            Integer[] integers = {A, B, C};

            boolean b1 = A == B;
            boolean b2 = A == C;
            boolean b3 = B == C;

            int sameCount = 0;
            if (b1) {
                sameCount +=1;
            }
            if (b2) {
                sameCount +=1;
            }
            if (b3) {
                sameCount +=1;
            }

            int high = 0;
            for (int i = 0; i < 3; i++) {
                Integer integer = integers[i];
                if (high < integer) {
                    high = integer;
                }
            }

            if (sum - high <= high) {
                sb.append("Invalid\n");
                continue;
            }
            if (sameCount == 3) {
                sb.append("Equilateral\n");
            }
            else if (sameCount == 1) {
                sb.append("Isosceles\n");

            } else if (sameCount == 0) {
                sb.append("Scalene\n");
            }
        }

        System.out.println(sb.toString());

    }
}
