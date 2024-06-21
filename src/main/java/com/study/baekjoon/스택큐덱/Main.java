package com.study.baekjoon.스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static Stack<String> stack = new Stack<>();

    private static StringTokenizer st = null;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                switch (st.nextToken()) {
                    case "1":
                        stack.push(st.nextToken());
                        break;
                    case "2":
                        if (stack.isEmpty()) {
                            sb.append("-1").append("\n");
                        } else {
                            sb.append(stack.pop()).append("\n");
                        }
                        break;
                    case "3":
                        sb.append(stack.size()).append("\n");
                        break;
                    case "4":
                        if (stack.isEmpty()) {
                            sb.append("1").append("\n");
                        } else {
                            sb.append("0").append("\n");
                        }
                        break;
                    case "5":
                        if (stack.isEmpty()) {
                            sb.append("-1").append("\n");
                        } else {
                            sb.append(stack.peek()).append("\n");
                        }
                        break;
                }
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
