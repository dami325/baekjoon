package com.study.baekjoon.집합과맵.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            String[] NLine = br.readLine().split(" ");

            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < NLine.length; i++) {
                Integer s = map.get(NLine[i]);

                if (s == null){
                    map.put(NLine[i], 1);
                }
                else {
                    map.put(NLine[i], s + 1);
                }
            }

            int M = Integer.parseInt(br.readLine());

            String[] MLine = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for (String mstr : MLine) {
                sb.append(map.get(mstr) == null ? "0" : map.get(mstr)).append(" ");
            }
            System.out.println(sb);

        } catch (IOException e) {

        }
    }
}
