package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14940쉬운최단거리 {
    private static int n,m, x,y;
    private static int[][] board, result;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        board = new int[n][m];
        result = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if (num == 2) {
                    x = i;
                    y = j;
                }else if(num == 0) {
                    visited[i][j] = true;
                }
            }
        }

        bfs(x,y);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    result[i][j] = -1;
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = point[0] + dx[i];
                int yy = point[1] + dy[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (!visited[xx][yy]) {
                        visited[xx][yy] = true;
                        result[xx][yy] = result[point[0]][point[1]] + 1;
                        queue.add(new int[]{xx,yy});
                    }
                }
            }
        }
    }
}
