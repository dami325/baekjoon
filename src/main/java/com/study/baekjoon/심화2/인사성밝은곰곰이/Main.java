package com.study.baekjoon.심화2.인사성밝은곰곰이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * 7
         * ENTER
         * pjshwa
         * chansol
         * chogahui05
         * ENTER
         * pjshwa
         * chansol
         *
         * 5
         */
        try(BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));){
            int N = Integer.parseInt(br.readLine());

            Map<String, String> chattingLog = new java.util.HashMap<>();

            int result = 0;
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                if (i + 1 == N && !line.equals("ENTER")) {
                    chattingLog.put(line, "");
                    result += chattingLog.size();
                }

                if(line.equals("ENTER")) {
                    Set<String> strings = chattingLog.keySet();
                    result += strings.size();
                    chattingLog.clear();
                } else {
                    chattingLog.put(line, "");
                }
            }
            System.out.println(result);

        }

    }
}
