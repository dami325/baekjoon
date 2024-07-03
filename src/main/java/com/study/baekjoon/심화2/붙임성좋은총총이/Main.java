package com.study.baekjoon.심화2.붙임성좋은총총이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static Set<String> rainbowDance = new HashSet<>();
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = null;

            rainbowDance.add("ChongChong");

            while (n-- > 0) {

                st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if(rainbowDance.contains(a)) {
                    rainbowDance.add(b);
                }

                if(rainbowDance.contains(b)) {
                    rainbowDance.add(a);
                }
            }

            System.out.println(rainbowDance.size());


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
