package com.study.baekjoon.스택큐덱.queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Deque<String> q = new ArrayDeque<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            String[] a = br.readLine().split(" ");

            String[] b = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                String type = a[i];
                if (type.equals("0")) {
                    String value = b[i];
                    q.add(value);
                }
            }

            int m = Integer.parseInt(br.readLine());

            StringTokenizer c = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();

            if (q.isEmpty()) {

                while (c.hasMoreTokens()) {
                    sb.append(c.nextToken()).append(" ");
                }

                System.out.println(sb);
                return;
            }

            while (m-- > 0) {
                String v = c.nextToken();
                sb.append(q.pollLast()).append(" ");
                q.push(v);
            }
            System.out.println(sb);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
