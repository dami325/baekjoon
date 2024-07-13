package com.study.baekjoon.알고리즘분류.재귀.재귀의귀재;

import java.util.Scanner;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int recursionCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            String s = sc.next();
            sb.append(isPalindrome(s)).append(" ").append(recursionCount).append("\n");
            recursionCount = 0;
        }
        System.out.println(sb);
    }

    private static int isPalindrome(String s) {
        return recursion(s.toCharArray(), 0, s.length() - 1);
    }

    private static int recursion(char[] charArray, int left, int right) {
        recursionCount++;
        if (left >= right) {
            return 1;
        }

        if (charArray[left] != charArray[right]) {
            return 0;
        }

        return recursion(charArray, left + 1, right - 1);
    }

}
