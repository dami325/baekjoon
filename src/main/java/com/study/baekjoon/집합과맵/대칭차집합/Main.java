package com.study.baekjoon.집합과맵.대칭차집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            List<Integer> list = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Set<String> resultSet = new HashSet<>();

            list.forEach(
                    number -> {
                        try {
                            StringTokenizer st = new StringTokenizer(br.readLine());
                            for (int i = 0; i < number; i++) {
                                String token = st.nextToken();
                                if (resultSet.contains(token)) {
                                    resultSet.remove(token);

                                } else {
                                    resultSet.add(token);
                                }
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );

            System.out.println(resultSet.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
