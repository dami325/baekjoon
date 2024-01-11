package com.study.baekjoon.배열2차원.최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = -1;
        String xy = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        for (int i = 1; i < 10; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            for (int j = 1; j < 10; j++) {
                int number = Integer.parseInt(st.nextToken());
                if(max < number){
                    max = number;
                    xy = i + " " + j;
                }
            }
        }

        System.out.println(max +"\n" + xy);
    }
}
