package com.study.baekjoon.스택큐덱.스택수열;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int stackIndex = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            while (true) {
                if (stackIndex <= num) {
                    sb.append("+").append("\n");
                    stack.push(stackIndex);
                    stackIndex++;
                } else {
                    if (stack.isEmpty() || stack.peek() != num) {
                        System.out.println("NO");
                        return;
                    }
                    stack.pop();
                    sb.append("-").append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);


        sc.close();
    }
}
