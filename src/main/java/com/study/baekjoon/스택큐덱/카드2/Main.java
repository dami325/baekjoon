package com.study.baekjoon.스택큐덱.카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            for (int i = 1; i <= n; i++) {
                q.add(i);
            }

            String result = "";
            while (!q.isEmpty()){
                result = q.poll() + "";

                if (!q.isEmpty()) {
                    q.add(q.poll());
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
