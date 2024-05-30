package com.study.baekjoon.집합과맵.회사에있는사람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            Map<String, String> map = new HashMap<>();

            StringTokenizer st = null;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String enterOrLeave = st.nextToken();

                if (enterOrLeave.equals("leave")) {
                    if (map.get(name) != null)
                        map.remove(name);
                } else {
                    map.put(name, enterOrLeave);
                }
            }

            List<String> collect = map.keySet().stream().sorted((o1, o2) -> {
                        if (o1.length() == o2.length()) {
                            for (int i = 0; i < o1.length(); i++) {
                                if (o1.charAt(i) != o2.charAt(i)) {
                                    return o2.charAt(i) - o1.charAt(i);
                                }
                            }
                        } else if (o1.length() > o2.length()) {
                            {
                                for (int i = 0; i < o2.length(); i++) {
                                    if (o2.charAt(i) != o1.charAt(i)) {
                                        return o2.charAt(i) - o1.charAt(i);
                                    }
                                }
                            }
                        } else {

                            for (int i = 0; i < o1.length(); i++) {
                                if (o1.charAt(i) != o2.charAt(i)) {
                                    return o2.charAt(i) - o1.charAt(i);
                                }
                            }
                        }
                        return o2.length() - o1.length();
                    }
            ).collect(Collectors.toList());

            for (String key : collect) {
                System.out.println(key);
            }

        } catch (IOException e) {

        }
        ;
    }
}
