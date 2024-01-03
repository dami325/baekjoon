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

                List<Integer> enemyList = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    enemyList.add(Integer.parseInt(st.nextToken()));
                }

                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    enemyList.add(Integer.parseInt(st.nextToken()));
                }

                int size = enemyList.size();
                int middleIndex = areaCount - 1;
                int lastIndex = size - 1;

                Map<String, Integer> totalCaseMap = new HashMap<>();

                for (int i = 0; i < size; i++) {
                    int upCase = i + areaCount;
                    int rightCase = i + 1;
                    int lastIndexRightCase = i - middleIndex;

                    if (i == middleIndex) {
                        putTotalCase(i, lastIndexRightCase, enemyList, totalCaseMap);
                        putTotalCase(i, upCase, enemyList, totalCaseMap);
                    } else if (i == lastIndex) {
                        putTotalCase(i, lastIndexRightCase, enemyList, totalCaseMap);
                    } else if (i < areaCount) {
                        putTotalCase(i, rightCase, enemyList, totalCaseMap);
                        putTotalCase(i, upCase, enemyList, totalCaseMap);
                    } else {
                        putTotalCase(i, rightCase, enemyList, totalCaseMap);
                    }
                }

                Map<String, Integer> resultMap = new HashMap<>();

                // 합이 100이면 resultMap 추가 100이 넘으면 case 에서 삭제
                for (String key : new HashSet<>(totalCaseMap.keySet())) {

                    Integer value = totalCaseMap.get(key);
                    if(value == null) continue;

                    if (value == memberCount) {
                        resultMap.put(key, memberCount);
                        removeContainsKey(totalCaseMap, key);
                        continue;
                    } else if (value > memberCount) {
                        totalCaseMap.remove(key);
                        continue;
                    }  else {
                        continue;
                    }

                }

                // 나머지
                List<String> indexArray = new ArrayList<>();
                totalCaseMap.entrySet().stream()
                        .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                        .forEach(entry -> {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            String[] split = key.split(",");
                            if (!indexArray.contains(split[0]) || !indexArray.contains(split[1])){
                                indexArray.addAll(List.of(split));
                                resultMap.put(key, value);
                            }
                        });

                int mapSize = resultMap.size();
                int solo = ((areaCount*2) - (mapSize*2));

                int result = mapSize + solo;

                bw.write(result + "");

            } // while
        }
    }

    private static void removeContainsKey(Map<String, Integer> totalCase, String key) {
        String[] split = key.split(",");
        for (String keys : new HashSet<>(totalCase.keySet())) {
            if(Arrays.stream(keys.split(","))
                    .anyMatch(i -> i.equals(split[0]) || i.equals(split[1]))){
                totalCase.remove(keys);
            }
        }
    }

    private static void putTotalCase(int firstIndex, int secondIndex, List<Integer> enemyList, Map<String, Integer> totalCase) {
        totalCase.put(firstIndex + "," + secondIndex, enemyList.get(firstIndex) + enemyList.get(secondIndex));
    }
}
