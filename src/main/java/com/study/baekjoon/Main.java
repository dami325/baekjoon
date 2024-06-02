package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            String[] strArr = new String[N];

            for (int i = 0; i < N; i++) {
                strArr[i] = br.readLine();
            }

            if (strArr.length == 1) {
                System.out.println(strArr[0]);
                return;
            }
            for (int i = 0; i < strArr.length-1; i++) {
                if(i == 0){
                    strCompare(strArr[i], strArr[i + 1]);
                }
                strCompare(sb.toString(), strArr[i + 1]);
            }

            System.out.println(sb.toString());

        } catch (IOException e) {

        }

    }

    private static String strCompare(String str1, String str2) {
        sb.setLength(0);

        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
            } else {
                sb.append("?");
            }
        }
        return sb.toString();
    }
}
