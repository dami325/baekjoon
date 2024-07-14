package com.study.baekjoon.알고리즘분류.백트레킹.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board = new int[9][9];
    private static int boardLength = 9;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < boardLength; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < boardLength; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);

        br.close();

    }

    private static void sudoku(int row, int col) {

        if (col == boardLength) {
            sudoku(row + 1, 0);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (row == boardLength) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        // 만약 해당 위치의 값이 0 이라면 1부터 9까지 중 가능한 수 탐색
        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                // i 값이 중복되지 않는지 검사
                if (possibility(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            board[row][col] = 0; // 해결하지 못하면 다시 돌아와서 0 으로 세팅후 해결못한 백트레킹
            return;
        }

        sudoku(row, col + 1);

    }


    private static boolean possibility(int row, int col, int value) {

        // 가로 검사
        for (int i = 0; i < boardLength; i++) {
            if(board[row][i] == value){
                return false;
            }
        }

        // 세로 검사
        for (int i = 0; i < boardLength; i++) {
            if(board[i][col] == value){
                return false;
            }
        }

        // 3*3 칸 검사
        int row3 = (row / 3) * 3;
        int col3 = (col / 3) * 3;

        for (int i = row3; i < row3 + 3; i++) {
            for (int j = col3; j < col3 + 3; j++) {
                if(board[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }
}
