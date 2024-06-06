package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Map<String,Integer> stringKeyMap = new HashMap<>();
            Map<Integer,String> intKeyMap = new HashMap<>();

            String[] split = br.readLine().split(" ");

            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            for (int i = 1; i <= N; i++) {
                String line = br.readLine();
                stringKeyMap.put(line, i);
                intKeyMap.put(i, line);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= M; i++) {
                String s = br.readLine();

                Integer x = stringKeyMap.get(s);
                if (x == null) {
                    sb.append(intKeyMap.get(Integer.parseInt(s)));
                } else {
                    sb.append(x);
                }
                sb.append("\n");
            }
            System.out.println(sb);


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
