package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L200 {

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    solve(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void solve(char[][] grid, int row, int col) {
        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            if (row < grid.length - 1)
                solve(grid, row + 1, col);
            if (col < grid[0].length - 1)
                solve(grid, row, col + 1);
            if (row >= 1) {
                solve(grid, row - 1, col);
            }
            if (col >= 1) {
                solve(grid, row, col - 1);
            }
        }
    }

    public static void main(String[] args) {
        L200 l200 = new L200();
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(l200.numIslands(grid));
    }
}
