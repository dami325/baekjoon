package com.study.baekjoon.항해99.챌린저2일차;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int solution = Solution.solution(new int[]{14, 35, 119}, new int[]{18, 30, 102});
        System.out.println(solution);
    }

    /**
     * 1. 각 배열의 최대 공약수로 다른 배열을 나눠보며 안나눠진다면 출력?
     * => 유클리드 호제법을 배열에 적용?
     * => 루프 한번에 유클리드 호제법 재귀면 시간복잡도는 어떻게 되는거지?
     * => 각 배열의 최대 공약수를 구했으면 그 다음은
     * => 공약수끼리 공약수를 구해서 1이 나와야 하나?
     * 5 / 3 = 2
     * <p>
     * 3 / 2 = 1
     * <p>
     * 2 / 1 = 0
     * ////
     * <p>
     * 10 / 5 = 5
     * 5 / 5 = 0
     */

    class Solution {

        // 유클리드 호제법을 이용한 최대공약수 계산
        private static int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        // 배열의 최대공약수 계산
        private static int findGCD(int[] array) {
            return Arrays.stream(array)
                    .skip(1)
                    .reduce(array[0], (a, b) -> gcd(a, b));
        }

        // 특정 값으로 배열 요소가 나누어지는지 확인
        private static boolean isDivisibleBy(int divisor, int[] array) {
            return Arrays.stream(array)
                    .anyMatch(num -> num % divisor == 0);
        }

        public static int solution(int[] arrayA, int[] arrayB) {
            int gcdA = findGCD(arrayA);
            int gcdB = findGCD(arrayB);

            if (gcdA == gcdB) {
                return 0;
            }

            boolean bDividesA = isDivisibleBy(gcdA, arrayB);
            boolean aDividesB = isDivisibleBy(gcdB, arrayA);

            if (bDividesA && aDividesB) {
                return 0;
            }

            if (!bDividesA && !aDividesB) {
                return Math.max(gcdA, gcdB);
            }

            if (!bDividesA) {
                return gcdA;
            }

            if (!aDividesB) {
                return gcdB;
            }

            return 0;
        }
    }
}
