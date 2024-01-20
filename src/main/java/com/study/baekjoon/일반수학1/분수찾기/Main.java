package com.study.baekjoon.일반수학1.분수찾기;

import java.util.Scanner;

public class Main {

    /**
     * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
     *
     * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();

        int cross_count = 1, prev_count_sum = 0;

        while (true) {

            if (X <= prev_count_sum + cross_count) {

                if (cross_count % 2 == 1) {
                    System.out.print((cross_count - (X - prev_count_sum - 1)) + "/" + (X - prev_count_sum));
                    break;
                }

                else {
                    System.out.print((X - prev_count_sum) + "/" + (cross_count - (X - prev_count_sum - 1)));
                    break;
                }

            } else {
                prev_count_sum += cross_count;
                cross_count++;
            }
        }

    }
}
