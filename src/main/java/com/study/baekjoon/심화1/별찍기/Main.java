package com.study.baekjoon.심화1.별찍기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();


        int l1 = n * 2 - 1;
        int star = 1;
        int space = n - 1;

        for (int l = 0; l < l1; l++) {

            for (int i = 0; i < space; i++) {
                sb.append(" ");
            }

            for (int s = 0; s < star; s++) {
                sb.append("*");
            }

            sb.append("\n");
            if (l < n-1) {
                space--;
                star+=2;
            }else {
                space++;
                star -= 2;
            }
        }

        System.out.println(sb.toString());


    }
}
