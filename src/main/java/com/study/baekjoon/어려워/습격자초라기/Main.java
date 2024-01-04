package com.study.baekjoon.어려워.습격자초라기;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {


            // 테스트 수
            int testCount = Integer.parseInt(br.readLine());

            while (testCount-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                // 구역 수
                int areaCount = Integer.parseInt(st.nextToken());

                int lastIndex = areaCount - 1;

                // 대원 수
                int memberCount = Integer.parseInt(st.nextToken());

                // 1 ~ N
                String[] bottomList = br.readLine().split(" ");
                // N ~ N2
                String[] topList = br.readLine().split(" ");


                Map<String, Integer> resultMap = new HashMap<>();
                Map<String, Integer> caseMap = new HashMap<>();

                for (int i = 0; i < areaCount; i++) {

                    String bottomStr = bottomList[i];
                    String topStr = topList[i];

                    int sum = getSum(bottomStr, topStr);
                    if (sum <= memberCount) {
                        caseMap.put(getKey(i, i + areaCount), sum);
                    }

                    if (i != lastIndex) {
                        int rightIndex = i + 1;
                        String bottomRight = bottomList[rightIndex];
                        String topRight = topList[rightIndex];

                        int sum1 = getSum(bottomStr, bottomRight);
                        if (sum1 <= memberCount) {
                            caseMap.put(getKey(i, rightIndex), sum1);
                        }

                        int sum2 = getSum(topStr, topRight);
                        if (sum2 <= memberCount) {
                            caseMap.put(getKey(i + areaCount, rightIndex + areaCount), sum2);
                        }

                    } else {

                        int ifLastIndexRightIndex = i - lastIndex;

                        String bottomRight = bottomList[ifLastIndexRightIndex];
                        String topRight = topList[ifLastIndexRightIndex];
                        int sum1 = getSum(bottomStr, bottomRight);
                        if (sum1 <= memberCount) {
                            caseMap.put(getKey(i, ifLastIndexRightIndex), sum1);
                        }
                        int sum2 = getSum(topStr, topRight);
                        if (sum2 <= memberCount) {
                            caseMap.put(getKey(i + areaCount, ifLastIndexRightIndex + areaCount), sum2);
                        }

                    }
                }


                List<Map.Entry<String, Integer>> collect = caseMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toList());

                List<String> indexList = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : collect) {
                    String key = entry.getKey();
                    String[] split = key.split(",");
                    if (indexList.contains(split[0]) || indexList.contains(split[1])) {
                        continue;
                    }
                    indexList.add(split[0]);
                    indexList.add(split[1]);
                    resultMap.put(key, entry.getValue());
                }

                int size = resultMap.size();
                String result = String.valueOf(size + (areaCount * 2 - size * 2));
                bw.write(result);
                bw.newLine();
            } // while
        }
    }

    private static String getKey(int index1, int index2) {
        return index1 + "," + index2;
    }

    private static int getSum(String str1, String str2) {
        int i1 = Integer.parseInt(str1);
        int i2 = Integer.parseInt(str2);
        return i1 + i2;
    }

}

