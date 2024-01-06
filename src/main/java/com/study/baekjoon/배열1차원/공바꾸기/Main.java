package com.study.baekjoon.배열1차원.공바꾸기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int basketCount = Integer.parseInt(st.nextToken());
            int mixCount = Integer.parseInt(st.nextToken());
            
            String[] baskets = new String[basketCount];
            
            for (int i = 0; i < basketCount; i++) {
                baskets[i] = "" + (i + 1);
            }
            
            for (int i = 0; i < mixCount; i++) {
                line = br.readLine();
                st = new StringTokenizer(line);
                int basket1 = Integer.parseInt(st.nextToken()) - 1;
                int basket2 = Integer.parseInt(st.nextToken()) - 1;
                String temp = baskets[basket1];
                baskets[basket1] = baskets[basket2];
                baskets[basket2] = temp;
            }
            for(int i = 0; i < basketCount; i++) {
                if(i == 0) {
                    System.out.print(baskets[i]);
                    continue;
                }
                System.out.print(" " + baskets[i]);
            }

        }
    }
}
