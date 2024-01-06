package com.study.baekjoon.문자열.문자열반복;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line = br.readLine();

            int N = Integer.parseInt(line);

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                String caseStr = br.readLine();
                st = new StringTokenizer(caseStr);
                String token1 = st.nextToken();
                String token2 = st.nextToken();

                int i1 = Integer.parseInt(token1);
                for (int j = 0; j < token2.length(); j++) {
                    for(int k = 0; k < i1; k++) {
                        bw.write(String.valueOf(token2.charAt(j)));
                    }
                }
                bw.newLine();
            }
        }
    }
}
