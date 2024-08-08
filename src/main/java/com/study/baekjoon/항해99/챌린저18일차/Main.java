package com.study.baekjoon.항해99.챌린저18일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int w, h;
    private static int[][] map;
    private static int[][] result;
    private static boolean[][] visited;
    private static int oddDir[][] = {{0, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}};//홀수 행
    private static int evenDir[][] = {{0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}};//짝수 행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());


        map = new int[w + 2][h + 2];
        visited = new boolean[w + 2][h + 2];
        result = new int[w + 2][h + 2];
        for (int i = 1; i <= w; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= h; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        int answer = 0;
        for (int i = 0; i < w + 2; i++) {
            for (int j = 0; j < h + 2; j++) {
                answer += result[i][j];
            }
        }

        System.out.println(answer);
    }

    public static void bfs() {

        Queue<Home> q = new LinkedList<>();
        q.add(new Home(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Home temp = q.poll();
            int x = temp.x;
            int y = temp.y;

            for (int dir = 0; dir < 6; dir++) {
                int nx = 0;
                int ny = 0;
                if (x % 2 == 1) {
                    nx = x + oddDir[dir][0];
                    ny = y + oddDir[dir][1];
                } else {
                    nx = x + evenDir[dir][0];
                    ny = y + evenDir[dir][1];
                }

                if (nx < 0 || nx >= w + 2 || ny < 0 || ny >= h + 2) continue;
                if (map[nx][ny] == 1) {
                    result[x][y] += 1;
                    continue;
                }

                if (visited[nx][ny] == true) continue;
                visited[nx][ny] = true;
                q.add(new Home(nx, ny));
            }
        }
    }

}

class Home {
    int x;
    int y;

    public Home(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
