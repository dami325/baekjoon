package com.study.baekjoon.약수배수와소수.배수와약수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 첫 번째 숫자가 두 번째 숫자의 약수이다.
     * 첫 번째 숫자가 두 번째 숫자의 배수이다.
     * 첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.
     * 입력
     * 입력은 여러 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 10,000이 넘지않는 두 자연수로 이루어져 있다. 마지막 줄에는 0이 2개 주어진다. 두 수가 같은 경우는 없다.
     *
     * 출력
     * 각 테스트 케이스마다 첫 번째 숫자가 두 번째 숫자의 약수라면 factor를, 배수라면 multiple을, 둘 다 아니라면 neither를 출력한다.
     *
     * 예제 입력 1
     * 8 16
     * 32 4
     * 17 5
     * 0 0
     * 예제 출력 1
     * factor
     * multiple
     * neither
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstNum = Integer.parseInt(st.nextToken());
            int lastNum = Integer.parseInt(st.nextToken());

            if(firstNum == 0 && lastNum == 0) {
                break;
            }

            if(lastNum % firstNum == 0) {
                System.out.println("factor");
            } else if(firstNum % lastNum == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }


    }
}
