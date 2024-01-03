package com.study.baekjoon.어려워.습격자초라기;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int testCount = Integer.parseInt(br.readLine());

            while (testCount-- > 0) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                int areaCount = Integer.parseInt(st.nextToken());
                int memberCount = Integer.parseInt(st.nextToken());

                List<Integer> enemyList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                List<Integer> enemyList2 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

                enemyList.addAll(enemyList2);

                int size = enemyList.size();
                int middleIndex = areaCount - 1;
                int lastIndex = size - 1;

                Map<String, Integer> totalCase = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    int upCase = i + areaCount;
                    int rightCase = i + 1;
                    int lastIndexRightCase = i - middleIndex;

                    if (i == middleIndex) {
                        putTotalCase(i, lastIndexRightCase, enemyList, totalCase);
                        putTotalCase(i, upCase, enemyList, totalCase);
                    } else if (i == lastIndex) {
                        putTotalCase(i, lastIndexRightCase, enemyList, totalCase);
                    } else if (i < areaCount) {
                        putTotalCase(i, rightCase, enemyList, totalCase);
                        putTotalCase(i, upCase, enemyList, totalCase);
                    } else {
                        putTotalCase(i, rightCase, enemyList, totalCase);
                    }
                }

                Map<String, Integer> resultMap = new HashMap<>();

                // 합이 100이면 resultMap 추가 100이 넘으면 case 에서 삭제
                Set<String> cloneKey1 = new HashSet<>(totalCase.keySet());
                for (String key : cloneKey1) {

                    Integer value = totalCase.get(key);
                    if(value == null) continue;

                    if (value == 100) {
                        resultMap.put(key, 100);
                        Set<String> cloneKey2 = new HashSet<>(totalCase.keySet());
                        for (String keys : cloneKey2) {
                            if(Arrays.stream(keys.split(",")).anyMatch(i -> {
                                String[] split = key.split(",");
                                return i.equals(split[0]) || i.equals(split[1]);
                            })){
                                totalCase.remove(keys);
                            }
                        }
                    } else if (value > 100) {
                        totalCase.remove(key);
                    }
                }

            } // while
        }
    }

    private static void putTotalCase(int firstIndex, int secondIndex, List<Integer> enemyList, Map<String, Integer> totalCase) {
        totalCase.put(firstIndex + "," + secondIndex, enemyList.get(firstIndex) + enemyList.get(secondIndex));
    }
}
