package com.study.baekjoon.어려워.습격자초라기;

import java.io.*;
import java.util.*;

public class Main {
    private static final StringBuilder builder = new StringBuilder();

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


                Map<String, Integer> caseMap = new HashMap<>();

                for (int i = 0; i < areaCount; i++) {

                    String bottomStr = bottomList[i];
                    String topStr = topList[i];

                    int bottomInt = Integer.parseInt(bottomStr);
                    int topInt = Integer.parseInt(topStr);

                    int defaultCaseSum = bottomInt + topInt;
                    if (defaultCaseSum <= memberCount) {
                        caseMap.put(getKey(i, i + areaCount), defaultCaseSum);
                    }

                    if (i != lastIndex) {
                        int rightIndex = i + 1;
                        String bottomRight = bottomList[rightIndex];
                        String topRight = topList[rightIndex];

                        int bottomRightInt = Integer.parseInt(bottomRight);
                        int sum1 = bottomInt + bottomRightInt;
                        if (sum1 <= memberCount) {
                            caseMap.put(getKey(i, rightIndex), sum1);
                        }

                        int i2 = Integer.parseInt(topRight);
                        int sum2 = topInt + i2;
                        if (sum2 <= memberCount) {
                            caseMap.put(getKey(i + areaCount, rightIndex + areaCount), sum2);
                        }

                    } else {

                        int ifLastIndexRightIndex = i - lastIndex;

                        String bottomRight = bottomList[ifLastIndexRightIndex];
                        String topRight = topList[ifLastIndexRightIndex];
                        int bottomRightInt = Integer.parseInt(bottomRight);
                        int sum1 = bottomInt + bottomRightInt;
                        if (sum1 <= memberCount) {
                            caseMap.put(getKey(i, ifLastIndexRightIndex), sum1);
                        }
                        int topRightInt = Integer.parseInt(topRight);
                        int sum2 = topInt + topRightInt;
                        if (sum2 <= memberCount) {
                            caseMap.put(getKey(i + areaCount, ifLastIndexRightIndex + areaCount), sum2);
                        }

                    }
                }

                List<String> indexList = new ArrayList<>();

                List<Map.Entry<String, Integer>> entryList = new ArrayList<>(caseMap.entrySet());
                entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

                for (Map.Entry<String, Integer> entry : entryList) {
                    String key = entry.getKey();
                    String[] split = key.split(",");

                    String i1 = split[0];
                    String i2 = split[1];

                    if (!indexList.contains(i1) && !indexList.contains(i2)) {
                        indexList.add(i1);
                        indexList.add(i2);
                    }
                }


                int size = indexList.size();
                int i = size >> 1;
                int i1 = areaCount << 1;

                bw.write(Integer.toString(i + i1 - size));
                bw.newLine();
            } // while
        }
    }

    private static String getKey(int index1, int index2) {
        builder.setLength(0);
        builder.append(index1);
        builder.append(",");
        builder.append(index2);
        return builder.toString();
    }

}

