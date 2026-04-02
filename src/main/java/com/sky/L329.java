package com.sky;

import java.util.Arrays;

public class L329 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(cache[i], 1);
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(matrix, cache, i, j));
            }
        }
        return res;
    }
    public int dfs(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] > 1) return cache[i][j]; // 这个很重要，当cache[i][j] > 1时，说明已经计算过，直接返回即可
        int m = matrix.length, n = matrix[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, cache, x, y) + 1);
            }
        }
        return cache[i][j];
    }
    public static void main(String[] args) {
        L329 l329 = new L329();
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
        int result = l329.longestIncreasingPath(matrix);
        System.out.println(result);
    }
}

