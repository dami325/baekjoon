package com.study.baekjoon.브루트포스.영화감독_숌;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            int n = Integer.parseInt(br.readLine());

            int count = 0;

            String result = "666";

            int number = 666;
            while (count != n) {

                result = String.valueOf(number++);

                if(result.contains("666")) {
                    count++;
                }
            }

            bw.write(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
