package com.study.baekjoon.어려워.습격자초라기;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 문제
         * 초라기는 한국의 비밀국방기지(원타곤)를 습격하라는 임무를 받은 특급요원이다.
         * 원타곤의 건물은 도넛 형태이며, 초라기는 효율적인 타격 포인트를 정하기 위해 구역을 아래와 같이 두 개의 원 모양으로 나누었다.
         * (그림의 숫자는 각 구역의 번호이다.)
         * 초라기는 각각 W명으로 구성된 특수소대를 다수 출동시켜 모든 구역에 침투시킬 예정이며,
         * 각 구역 별로 적이 몇 명씩 배치되어 있는지는 초라기가 모두 알고 있다. 특수소대를 아래 조건에 따라 침투 시킬 수 있다.
         * 한 특수소대는 침투한 구역 외에, 인접한 한 구역 더 침투할 수 있다.
         * (같은 경계를 공유하고 있으면 인접 하다고 한다. 위 그림에서 1구역은 2, 8, 9 구역과 서로 인접한 상태다.)
         * 즉, 한 특수소대는 한 개 혹은 두 개의 구역을 커버할 수 있다.
         * 특수소대끼리는 아군인지 적인지 구분을 못 하기 때문에, 각 구역은 하나의 소대로만 커버해야 한다.
         * 한 특수소대가 커버하는 구역의 적들의 합은 특수소대원 수 W 보다 작거나 같아야 한다.
         * 이때 초라기는 원타곤의 모든 구역을 커버하기 위해 침투 시켜야 할 특수 소대의 최소 개수를 알고 싶어 한다.
         * 입력
         * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 구성되어있다.
         * 첫째 줄에는 (구역의 개수)/2 값 N과 특수 소대원의 수 W가 주어진다. (1 ≤ N ≤ 10000, 1 ≤ W ≤ 10000).
         * 둘째 줄에는 1~N번째 구역에 배치된 적의 수가 주어지고, 셋째 줄에는 N+1 ~ 2N번째 구역에 배치된 적의 수가 공백으로 구분되어 주어진다.
         * (1 ≤ 각 구역에 배치된 최대 적의 수 ≤ 10000)
         * 단, 한 구역에서 특수 소대원의 수보다 많은 적이 배치된 구역은 존재하지 않는다.
         * (따라서, 각 구역에 배치된 최대 적의 수 ≤ W)
         * 출력
         * 각 테스트케이스에 대해서 한 줄에 하나씩 원타곤의 모든 구역을 커버하기 위해 침투 시켜야 할 특수 소대의 최소 개수를 출력하시오.
         * 예제 입력 1
         * 1
         * 8 100
         * 70 60 55 43 57 60 44 50 70
         * 58 40 47 90 45 52 80 40 58
         * 예제 출력 1
         * 11
         * 힌트
         * 하나의 특수 소대로 인접한 두 영역을 커버할 수 있는 배치는 (2,10), (9,16), (4,5), (7,8), (13,14) 이다.
         * 그리고 나머지 6개 구역은 각각 하나의 특수 소대로 커버할 수 있다. 그러므로 최소 11개 특수 소대를 침투시켜야 한다.
         */
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

                for (Map.Entry<Integer[], Integer> caseEntry : totalCase.entrySet()) {
                    System.out.println("caseEntry.getKey() = " + caseEntry.getKey()[0] + "," + caseEntry.getKey()[1]);
                    System.out.println("caseEntry.getValue() = " + caseEntry.getValue());
                }
            }
        }
    }

    private static void putTotalCase(int firstIndex, int secondIndex, List<Integer> enemyList, Map<Integer[], Integer> totalCase) {
        totalCase.put(new Integer[]{firstIndex,secondIndex}, enemyList.get(firstIndex) + enemyList.get(secondIndex));
    }
}
