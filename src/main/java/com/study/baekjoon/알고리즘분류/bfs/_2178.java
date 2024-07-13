package com.study.baekjoon.알고리즘분류.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {

    // 상하좌우탐색용
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int[][] arr;
    private static boolean visited[][];
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs(0, 0);

        System.out.println(arr[n-1][m-1]);

    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});

        visited[i][j]= true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색은 인덱스 4 for문 돌리면됨
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                //배열을 넘어가면 안됨
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    // 0이여서 갈 수 없거나 방문한 곳이면 안됨
                    if (arr[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        //가장 중요한 부분 뎁스 올려주기 이전위치 + 1
                        // 지금 들어가는 x y 좌표는 이전 좌표 뎁스의 + 1인것
                        arr[x][y] = arr[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y}); // 다음 뎁스 탐색
                    }
                }
            }
        }

    }
}
