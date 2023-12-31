package com.study.baekjoon.step1._11382;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 문제
         * 꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!
         *
         * 입력
         * 첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 1012)이 공백을 사이에 두고 주어진다.
         *
         * 출력
         * A+B+C의 값을 출력한다.
         *
         * 예제 입력 1
         * 77 77 7777
         * 예제 출력 1
         * 7931
         */
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            String total = String.valueOf(a + b + c);
            bw.write(total);
            bw.flush();
        }


    }
}
