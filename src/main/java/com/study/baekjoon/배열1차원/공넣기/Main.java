package com.study.baekjoon.배열1차원.공넣기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] baskets = new String[N];

            for (int i = 0; i < M; i++) {
                String line = br.readLine();
                st = new StringTokenizer(line);
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                String num = st.nextToken();
                for (int j = start; j <= end; j++) {
                    baskets[j - 1] = num;
                }
            }

            for (int i = 0; i < baskets.length; i++) {
                if (baskets[i] == null)
                    baskets[i] = "0";

                if(i == 0) {
                    bw.write(baskets[i]);
                    continue;
                }

                bw.write(" " + baskets[i]);
            }
        }
    }
}
