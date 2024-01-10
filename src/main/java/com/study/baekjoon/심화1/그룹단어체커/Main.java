package com.study.baekjoon.심화1.그룹단어체커;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;
        while (N-- > 0) {

            String input = sc.next();

            count += solution(input);
        }
        System.out.println(count);
    }

    public static int solution(String input) {

        int length = input.length();

        for (int i = 0; i < length-1; i++) {
            char before = input.charAt(i);
            char next = input.charAt(i + 1);

            if (before != next) {
                String substring = input.substring(i + 1);
                if(substring.contains(String.valueOf(before))){
                    return 0;
                };
            }
        }
        return 1;
    }
}
