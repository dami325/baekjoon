import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String[] commands = {"up", "down", "left", "right"};
    private static int maxBlock = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            Square[][] board = new Square[n][n];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    board[i][j] = new Square(Integer.parseInt(line[j]));
                }
            }

            // 백트래킹 시작
            dfs(board, 0);

            // 결과 출력
            System.out.println(maxBlock);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(Square[][] board, int depth) {
        if (depth == 5) {
            // 최대값 갱신
            for (Square[] row : board) {
                for (Square square : row) {
                    maxBlock = Math.max(maxBlock, square.getValue());
                }
            }
            return;
        }

        // 현재 보드 상태를 복사
        Square[][] copy = new Square[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                copy[i][j] = new Square(board[i][j].getValue());
            }
        }

        // 네 방향으로 움직여보고 재귀 호출
        for (String command : commands) {
            move(copy, command);
            dfs(copy, depth + 1);

            // 재귀 호출 후 보드 상태를 원래대로 되돌림
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    copy[i][j] = new Square(board[i][j].getValue());
                }
            }
        }
    }

    private static void move(Square[][] board, String command) {
        switch (command) {
            case "up":
                for (int j = 0; j < board.length; j++) {
                    int idx = 0;
                    for (int i = 1; i < board.length; i++) {
                        if (board[i][j].getValue() != 0) {
                            int temp = board[i][j].getValue();
                            board[i][j].setValue(0);
                            if (board[idx][j].getValue() == 0) {
                                board[idx][j].setValue(temp);
                            } else if (board[idx][j].getValue() == temp && !board[idx][j].isMoved()) {
                                board[idx][j].setValue(board[idx][j].getValue() * 2);
                                board[idx][j].setMoved(true);
                                idx++;
                            } else {
                                idx++;
                                board[idx][j].setValue(temp);
                            }
                        }
                    }
                    resetMoved(board);
                }
                break;
            case "down":
                for (int j = 0; j < board.length; j++) {
                    int idx = board.length - 1;
                    for (int i = board.length - 2; i >= 0; i--) {
                        if (board[i][j].getValue() != 0) {
                            int temp = board[i][j].getValue();
                            board[i][j].setValue(0);
                            if (board[idx][j].getValue() == 0) {
                                board[idx][j].setValue(temp);
                            } else if (board[idx][j].getValue() == temp && !board[idx][j].isMoved()) {
                                board[idx][j].setValue(board[idx][j].getValue() * 2);
                                board[idx][j].setMoved(true);
                                idx--;
                            } else {
                                idx--;
                                board[idx][j].setValue(temp);
                            }
                        }
                    }
                    resetMoved(board);
                }
                break;
            case "left":
                for (int i = 0; i < board.length; i++) {
                    int idx = 0;
                    for (int j = 1; j < board.length; j++) {
                        if (board[i][j].getValue() != 0) {
                            int temp = board[i][j].getValue();
                            board[i][j].setValue(0);
                            if (board[i][idx].getValue() == 0) {
                                board[i][idx].setValue(temp);
                            } else if (board[i][idx].getValue() == temp && !board[i][idx].isMoved()) {
                                board[i][idx].setValue(board[i][idx].getValue() * 2);
                                board[i][idx].setMoved(true);
                                idx++;
                            } else {
                                idx++;
                                board[i][idx].setValue(temp);
                            }
                        }
                    }
                    resetMoved(board);
                }
                break;
            case "right":
                for (int i = 0; i < board.length; i++) {
                    int idx = board.length - 1;
                    for (int j = board.length - 2; j >= 0; j--) {
                        if (board[i][j].getValue() != 0) {
                            int temp = board[i][j].getValue();
                            board[i][j].setValue(0);
                            if (board[i][idx].getValue() == 0) {
                                board[i][idx].setValue(temp);
                            } else if (board[i][idx].getValue() == temp && !board[i][idx].isMoved()) {
                                board[i][idx].setValue(board[i][idx].getValue() * 2);
                                board[i][idx].setMoved(true);
                                idx--;
                            } else {
                                idx--;
                                board[i][idx].setValue(temp);
                            }
                        }
                    }
                    resetMoved(board);
                }
                break;
        }
    }

    private static void resetMoved(Square[][] board) {
        for (Square[] row : board) {
            for (Square square : row) {
                square.setMoved(false);
            }
        }
    }

    private static class Square {
        private boolean isMoved;
        private int value;

        public Square(int value) {
            this.value = value;
            this.isMoved = false;
        }

        public boolean isMoved() {
            return isMoved;
        }

        public void setMoved(boolean moved) {
            isMoved = moved;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
