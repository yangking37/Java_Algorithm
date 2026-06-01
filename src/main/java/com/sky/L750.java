package com.sky;

public class L750 {
    public int countCornerRectangles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // border[i][j] 表示从不包含当前行的前面所有行中,列的 i 索引和 j 索引都为 1 的行的个数
        int[][] border = new int[rows + 1][cols + 1];
        int ans = 0;    // 总共角矩形的个数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    for (int k = j + 1; k < cols; k++) {
                        if (grid[i][k] == 1) {  // 找到了角矩形的一个底边
                            ans += border[j][k];
                            // 第 0 行到第 i 行的每一行中,列索引 j 和 k 都为 1 的行的个数加一
                            border[j][k]++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L750 l = new L750();
        int[][] grid = {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}};
//        int[][] grid = {{1, 1, 1}, {1, 1, 1},{1, 1, 1}};
        System.out.println(l.countCornerRectangles(grid));

    }
}
