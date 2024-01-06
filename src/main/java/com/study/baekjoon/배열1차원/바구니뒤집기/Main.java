package com.study.baekjoon.배열1차원.바구니뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int basketCount = Integer.parseInt(st.nextToken());
        int mixCount = Integer.parseInt(st.nextToken());

        List<Integer> baskets = new ArrayList<>();
        for (int i = 1; i <= basketCount; i++) {
            baskets.add(i);
        }

        for (int i = 0; i < mixCount; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int start = indexParsInt(st.nextToken());
            int end = indexParsInt(st.nextToken());
            List<Integer> mixList = new ArrayList<>();
            for (int j = start; j <= end; j++) {
                Integer e = baskets.get(j);
                mixList.add(e);
                if (j == end) {
                    baskets.removeAll(mixList);
                    Collections.reverse(mixList);
                    baskets.addAll(start,mixList);
                }
            }
        }
        baskets.forEach(i -> System.out.print(i + " "));
    }

    public static int indexParsInt(String string) {
        return Integer.parseInt(string) - 1;
    }
}
