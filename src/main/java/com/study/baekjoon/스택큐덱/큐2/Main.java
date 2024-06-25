package com.study.baekjoon.스택큐덱.큐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static LinkedList<Integer> q = new LinkedList<>();

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                switch (st.nextToken()) {
                    case "push":
                        q.offer(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        sb.append(q.isEmpty() ? "-1" : q.poll()).append("\n");
                        break;
                    case "size":
                        sb.append(q.size()).append("\n");
                        break;
                    case "empty":
                        sb.append(q.isEmpty() ? "1" : "0").append("\n");
                        break;
                    case "front":
                        sb.append(q.isEmpty() ? "-1" : q.peek()).append("\n");
                        break;
                    case "back":
                        sb.append(q.isEmpty() ? "-1" : q.peekLast()).append("\n");
                        break;
                }
            }

            System.out.println(sb);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
