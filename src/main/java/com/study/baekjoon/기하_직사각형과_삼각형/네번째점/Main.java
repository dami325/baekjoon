package com.study.baekjoon.기하_직사각형과_삼각형.네번째점;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            int num = sc.nextInt();
            if (i % 2 == 0) {
                if (y.contains(num)) {
                    y.remove(Integer.valueOf(num));
                }else {
                    y.add(num);
                }
            } else {
                if (x.contains(num)) {
                    x.remove(Integer.valueOf(num));
                }else {
                    x.add(num);
                }
            }
        }

        System.out.println(x.get(0) + " " + y.get(0));

    }
}
