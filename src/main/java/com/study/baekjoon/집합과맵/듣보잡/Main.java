package com.study.baekjoon.집합과맵.듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            HashSet<String> set = new HashSet<>();
            HashSet<String> resultSet = new HashSet<>();
            for (int i = 0; i < n + m; i++) {
                String str = br.readLine();
                if (set.contains(str)) {
                    resultSet.add(str);
                }
                set.add(str);
            }

            StringBuilder sb = new StringBuilder();

            sb.append(resultSet.size())
                    .append("\n");
            resultSet.stream().sorted()
                    .forEach(
                            s -> {
                                sb.append(s).append("\n");
                            }
                    );
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
