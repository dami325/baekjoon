package com.study.baekjoon.심화1.단어공부;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String next = sc.next();

        int length = next.length();

        LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            String key = String.valueOf(next.charAt(i)).toUpperCase();
            Integer integer = resultMap.get(key);
            if (integer == null) {
                integer = 1;
                resultMap.put(key, integer);
            } else {
                resultMap.put(key,integer+=1);
            }
        }

        List<String> keySet = new ArrayList<>(resultMap.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return resultMap.get(o2).compareTo(resultMap.get(o1));
            }
        });

        int size = keySet.size();

        if (size >= 2) {
            String key1 = keySet.get(0);
            String key2 = keySet.get(1);
            Integer val1 = resultMap.get(key1);
            Integer val2 = resultMap.get(key2);
            System.out.println(val1.equals(val2) ? "?" : key1);
        } else {
            System.out.println(keySet.get(0));
        }
    }
}
