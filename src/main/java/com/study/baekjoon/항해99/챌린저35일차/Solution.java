package com.study.baekjoon.항해99.챌린저35일차;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
class Solution {
    private final int[] DX = {1, -1, 0, 0};
    private final int[] DY = {0, 0, 1, -1};

    int size;

    class Shape {
        private boolean[][] shape;
        private int x, y;

        public Shape(boolean[][] shape) {
            this.shape = shape;
            this.x = shape.length;
            this.y = shape[0].length;
        }

        public boolean isFit(Shape s) {
            boolean flag = true;

            if (this.x == s.x && this.y == s.y) {
                loop:
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if (this.shape[i][j] ^ s.shape[i][j]) {
                            flag = false;
                            break loop;
                        }
                    }
                }
                if (flag) return true;

                flag = true;
                loop:
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if (this.shape[i][j] ^ s.shape[x - i - 1][y - j - 1]) {
                            flag = false;
                            break loop;
                        }
                    }
                }
                if (flag) return true;
            }

            if (this.x == s.y && this.y == s.x) {
                flag = true;
                loop:
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if (this.shape[i][j] ^ s.shape[y - j - 1][i]) {
                            flag = false;
                            break loop;
                        }
                    }
                }
                if (flag) return true;

                flag = true;
                loop:
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if (this.shape[i][j] ^ s.shape[j][x - i - 1]) {
                            flag = false;
                            break loop;
                        }
                    }
                }
                if (flag) return true;
            }

            return false;
        }

        public int count() {
            int result = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (shape[i][j]) result++;
                }
            }
            return result;
        }
    }

    public int solution(int[][] game_board, int[][] table) {
        this.size = game_board.length;
        List<Shape> shapeList = new ArrayList<>();
        List<Shape> pieceList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game_board[i][j] == 0) {
                    shapeList.add(bfs(game_board, i, j, 1));
                }

                if (table[i][j] == 1) {
                    pieceList.add(bfs(table, i, j, 0));
                }
            }
        }

        int answer = 0;
        boolean[] used = new boolean[shapeList.size()];

        for (Shape piece : pieceList) {
            for (int i = 0; i < shapeList.size(); i++) {
                if (used[i]) continue;
                if (piece.isFit(shapeList.get(i))) {
                    answer += piece.count();
                    used[i] = true;
                    break;
                }
            }
        }

        return answer;
    }

    private Shape bfs(int[][] board, int i, int j, int con) {
        int minX = i, minY = j;
        int maxX = i, maxY = j;

        List<List<Integer>> list = new ArrayList<>();
        Deque<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> init = new ArrayList<>();

        init.add(i);
        init.add(j);
        list.add(init);
        queue.add(init);
        board[i][j] = con;

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.get(0) + DX[k];
                int ny = cur.get(1) + DY[k];
                if (0 > nx || nx >= size || 0 > ny || ny >= size || board[nx][ny] == con) continue;
                minX = Math.min(minX, nx);
                minY = Math.min(minY, ny);
                maxX = Math.max(maxX, nx);
                maxY = Math.max(maxY, ny);

                List<Integer> temp = new ArrayList<>();
                temp.add(nx);
                temp.add(ny);
                list.add(temp);
                queue.add(temp);
                board[nx][ny] = con;
            }
        }

        boolean[][] shape = new boolean[maxX - minX + 1][maxY - minY + 1];
        for (List<Integer> cur : list) {
            shape[cur.get(0) - minX][cur.get(1) - minY] = true;
        }

        return new Shape(shape);
    }
}