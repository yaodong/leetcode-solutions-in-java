package leetcode.q174;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if (isEmpty(dungeon)) {
            return 0;
        }

        int nRow = dungeon.length;
        int nCol = dungeon[0].length;

        int[][] health = new int[nRow][nCol];

        // start from the last cell (bottom-right)
        health[nRow - 1][nCol - 1] = Math.max(1, 1 - dungeon[nRow - 1][nCol - 1]);

        // initialize last col
        // knight can only go down in the last column
        int lc = nCol - 1;
        for (int r = nRow - 2; r >= 0; r--) {
            health[r][lc] = Math.max(1, health[r + 1][lc] - dungeon[r][lc]);
        }

        // initialize last row
        // knight can only go right in the last row
        int lr = nRow - 1;
        for (int c = nCol - 2; c >= 0; c--) {
            health[lr][c] = Math.max(1, health[lr][c + 1] - dungeon[lr][c]);
        }

        // calculate rest cells from bottom right to top left
        for (int r = nRow - 2; r >= 0; r--) {
            for (int c = nCol - 2; c >= 0; c--) {
                health[r][c] = Math.min(
                        Math.max(1, health[r + 1][c] - dungeon[r][c]),
                        Math.max(1, health[r][c + 1] - dungeon[r][c])
                );
            }
        }

        return health[0][0];
    }

    private boolean isEmpty(int[][] dungeon) {
        return dungeon == null || dungeon.length == 0 || dungeon[0].length == 0;
    }
}
