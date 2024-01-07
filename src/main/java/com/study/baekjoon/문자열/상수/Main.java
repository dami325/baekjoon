package com.study.baekjoon.문자열.상수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String secound = sc.next();

        StringBuilder sb = new StringBuilder();
        sb.append(first.charAt(2));
        sb.append(first.charAt(1));
        sb.append(first.charAt(0));

        int reversed = Integer.parseInt(sb.toString());

        sb.setLength(0);
        sb.append(secound.charAt(2));
        sb.append(secound.charAt(1));
        sb.append(secound.charAt(0));

        int reversed2 = Integer.parseInt(sb.toString());

        System.out.println(reversed > reversed2 ? reversed : reversed2);

    }
}
