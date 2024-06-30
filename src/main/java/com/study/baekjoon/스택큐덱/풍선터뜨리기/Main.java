package com.study.baekjoon.스택큐덱.풍선터뜨리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int num = Integer.parseInt(st.nextToken());

        Deque<Balloon> balloon = new ArrayDeque<>();

        for (int i = 2; i <= n; i++) {
            balloon.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        sb.append("1 ");

        while (!balloon.isEmpty()) {

            if (num > 0) {

                for (int i = 1; i < num; i++) {
                    balloon.offer(balloon.poll());
                }

                Balloon next = balloon.poll();
                num = next.numValue;
                sb.append(next.index + " ");

            } else {

                for (int i = 1; i < -num; i++) {
                    balloon.push(balloon.pollLast());
                }

                Balloon next = balloon.pollLast();
                num = next.numValue;
                sb.append(next.index + " ");

            }
        }

        System.out.println(sb);

    }

    //풍선의 인덱스와 숫자 값을 저장하는 클래스 Balloon

}

class Balloon {
    int index;
    int numValue;

    public Balloon(int index, int numValue) {
        this.index = index;
        this.numValue = numValue;
    }
}
