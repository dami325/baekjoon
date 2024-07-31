package com.study.baekjoon.항해99.챌린저10일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Long> q = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            long num = Long.parseLong(br.readLine());
            if (num == 0) {
                if(!q.isEmpty()){
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            }else{
                q.add(num);
            }
        }

        br.close();

    }
}
