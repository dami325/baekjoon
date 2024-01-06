package com.study.baekjoon.반복문.별찍기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        String result = "";
        for (int i = 1; i <= line; i++) {
            int space = line - i;
            for (int draw = 1; draw <= space; draw++) {
                result += " ";
            }

            for (int star = 1; star <= i; star++) {
                result += "*";
            }
            result += "\n";
        }
        System.out.println(result);
    }
}
