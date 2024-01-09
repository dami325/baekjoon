package com.study.baekjoon.심화1.크로아티아알파벳;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> croatianAlphabet = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

    //ex ljes=njak
    // 6
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        solution(sc.next());
    }

    public static void solution(String input) {
        for (int i = 0; i < 8; i++) {
            String s = croatianAlphabet.get(i);
            if(input.contains(s)){
                input =  input.replace(s, "##");
            };
        }

        int length = input.replace("##", "").length();

        int resultCount = (input.length() - length) /2 + length;
        System.out.println(resultCount);
    }
}
