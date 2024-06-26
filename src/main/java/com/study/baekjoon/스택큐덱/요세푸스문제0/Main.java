package com.study.baekjoon.스택큐덱.요세푸스문제0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static LinkedList<Integer> q = new LinkedList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        int index = 1;
        while (!q.isEmpty()) {

            if (index == k) {
                sb.append(q.poll());

                if (!q.isEmpty()) {
                    sb.append(", ");
                } else {
                    sb.append(">");
                }

                index = 1;
                continue;
            } else {
                q.offer(q.poll());
            }

            index++;
        }

        System.out.println(sb);

    }
}
