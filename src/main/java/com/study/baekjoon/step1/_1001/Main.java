package com.study.baekjoon.step1._1001;

import java.io.*;
import java.util.StringTokenizer;

/**
 문제
 두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.

 입력
 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

 출력
 첫째 줄에 A-B를 출력한다.

 예제 입력 1
 3 2
 예제 출력 1
 1
 */
public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));) {

            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            System.out.print(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
        }
    }
}
