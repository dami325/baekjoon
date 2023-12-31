package com.study.baekjoon.step3.영수증;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int totalPrice = Integer.parseInt(br.readLine());
            int totalCount = Integer.parseInt(br.readLine());

            int result = 0;
            for (int i = 0; i < totalCount; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                result += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }

            bw.write(result == totalPrice ? "Yes" : "No");
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
