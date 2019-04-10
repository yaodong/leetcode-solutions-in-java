package leetcode.q329;

import java.util.Arrays;

public class Solution {

    private int nRows;

    private int nCols;

    private int[][] memory;

    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        nRows = matrix.length;
        nCols = matrix[0].length;

        memory = new int[nRows][nCols];
        for (int[] row : memory) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                ans = Math.max(ans, deepFirstSearch(matrix, row, col));
            }
        }

        return ans;
    }

    private int deepFirstSearch(int[][] matrix, int row, int col) {
        if (memory[row][col] != -1) {
            return memory[row][col];
        }

        memory[row][col] = 1;

        for (int i = 0; i < directions.length; i++) {
            int nextRow = row + directions[i][0];
            int nextCol = col + directions[i][1];

            if (nextRow < 0 || nextCol < 0 || nextCol >= nCols || nextRow >= nRows || matrix[nextRow][nextCol] <= matrix[row][col]) {
                continue;
            }

            memory[row][col] = Math.max(memory[row][col], 1 + deepFirstSearch(matrix, nextRow, nextCol));
        }

        return memory[row][col];
    }

}
