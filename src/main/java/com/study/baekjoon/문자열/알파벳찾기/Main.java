package com.study.baekjoon.문자열.알파벳찾기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();

        String[] abc = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (String a : abc) {
            int i = next.indexOf(a);
            System.out.print(i + " ");
        }
    }
}
