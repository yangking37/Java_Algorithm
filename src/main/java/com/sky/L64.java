package com.sky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        // 记录最优解
        List<Integer> list = new ArrayList<>(m + n - 1);
        int i = m - 1;
        int j = n - 1;
        while (true) {
            list.add(grid[i][j]);
            if (i == 0 && j == 0) {
                break;
            }
            if (i == 0) {
                j--;
            } else if (j == 0) {
                i--;
            } else {
                if (dp[i][j - 1] < dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        Collections.reverse(list);
        System.out.println("最优解为：" + list);
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        L64 solution = new L64();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
