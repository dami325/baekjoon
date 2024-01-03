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

                Map<Integer[], Integer> totalCase = new HashMap<>();
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

                Map<Integer[], Integer> resultMap = new HashMap<>();
                
                for (Map.Entry<Integer[], Integer> caseEntry : totalCase.entrySet()) {
                    if (caseEntry.getValue() == 100) {
                        resultMap.put(caseEntry.getKey(), 100);

                        Integer[] key = caseEntry.getKey();

                        Set<Integer[]> integers = totalCase.keySet();

                        for (Integer[] integer : integers) {
                            if(Arrays.stream(integer).anyMatch(i -> i.equals(key[0]) || i.equals(key[1]))){
                               totalCase.remove(integer);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void putTotalCase(int firstIndex, int secondIndex, List<Integer> enemyList, Map<Integer[], Integer> totalCase) {
        totalCase.put(new Integer[]{firstIndex,secondIndex}, enemyList.get(firstIndex) + enemyList.get(secondIndex));
    }
}
