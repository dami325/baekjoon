package com.study.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        w -= x;
        h -= y;

        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        list.add(w);
        list.add(h);

        int min = x;
        for (int i = 0; i < 4; i++) {
            Integer integer = list.get(i);
            if(integer.compareTo(min) < 0) {
                min = integer;
            }
        }
        System.out.println(min);

    }
}
