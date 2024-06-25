package com.study.baekjoon.스택큐덱.제로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Integer> stack = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        while (n-- > 0) {
            Integer num = Integer.parseInt(br.readLine());
            if (num.equals(0) && !stack.isEmpty()) {
                Integer integer = stack.removeFirst();
                result -= integer;
            } else {
                stack.push(num);
                result += num;
            }
        }

        System.out.println(result);

    }
}
