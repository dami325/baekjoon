package com.study.baekjoon.기하_직사각형과_삼각형.대지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lowX = Integer.parseInt(st.nextToken());
        int lowY = Integer.parseInt(st.nextToken());
        int highX = lowX;
        int highY = lowY;

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x < lowX) lowX = x;
            if(y < lowY) lowY = y;
            if(x > highX) highX = x;
            if(y > highY) highY = y;
        }

        System.out.println((highX - lowX) * (highY - lowY));
    }
}

