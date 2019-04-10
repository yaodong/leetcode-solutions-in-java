package leetcode.q037;

public class SudokuSolver {

    private int[][] rowLog;
    private int[][] colLog;
    private int[][][] sqLog;

    public char[][] solveSudoku(char[][] board) {
        rowLog = new int[9][9];
        colLog = new int[9][9];
        sqLog = new int[3][3][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    setCell(board, row, col, board[row][col]);
                }
            }
        }

        solve(board, 0, 0);

        return board;
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solve(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (canSet(row, col, c)) {
                setCell(board, row, col, c);
                if (solve(board, row, col + 1)) {
                    return true;
                }
                emptyCell(board, row, col, c);
            }
        }

        return false;
    }

    private boolean canSet(int row, int col, char c) {
        int n = c - '0' - 1;
        return rowLog[row][n] == 0 && colLog[col][n] == 0 && sqLog[row / 3][col / 3][n] == 0;
    }

    private void setCell(char[][] board, int row, int col, char c) {
        board[row][col] = c;
        int n = c - '0' - 1;
        rowLog[row][n] = 1;
        colLog[col][n] = 1;
        sqLog[row / 3][col / 3][n] = 1;
    }

    private void emptyCell(char[][] board, int row, int col, char c) {
        board[row][col] = '.';
        int n = c - '0' - 1;
        rowLog[row][n] = 0;
        colLog[col][n] = 0;
        sqLog[row / 3][col / 3][n] = 0;
    }
}
