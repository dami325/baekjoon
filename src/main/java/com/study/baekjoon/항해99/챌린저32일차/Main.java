package com.study.baekjoon.항해99.챌린저32일차;


import java.util.*;

class Solution {

    // 상하좌우 이동을 위한 방향 설정
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];

        // 직사각형을 지도에 2배 크기로 그리기 (확대하여 그리기)
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] != 2) { // 테두리
                            map[i][j] = 1;
                        }
                    } else {
                        map[i][j] = 2; // 내부 채우기
                    }
                }
            }
        }

        // BFS로 최단 경로 찾기
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];

        queue.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 아이템 위치에 도달했을 경우
            if (x == itemX * 2 && y == itemY * 2) {
                return distance / 2;
            }

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 102 && ny < 102) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, distance + 1});
                    }
                }
            }
        }

        return -1; // 여기까지 오지 않음
    }
}


public class Main {

    private static final Solution solution = new Solution();
    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 5, 7}};
        int result = solution.solution(
                rectangle,
                1,
                1,
                4,
                7
        );
        System.out.println(result);
    }
}
