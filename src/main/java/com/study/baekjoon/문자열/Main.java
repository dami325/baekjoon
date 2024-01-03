package com.study.baekjoon.문자열;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int testCount = Integer.parseInt(br.readLine());

            for(int i = 0; i < testCount; i++) {
                String word = br.readLine();

                System.out.println(word.charAt(0) + "" + word.charAt(word.length() - 1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
