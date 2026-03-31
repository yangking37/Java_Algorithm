package com.sky;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L221 {

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            Arrays.fill(dp[i], 0);
        int max = 0;
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][0] == '1')
                dp[i][0] = 1;
        for (int j = 0; j < matrix[0].length; j++)
            if (matrix[0][j] == '1')
                dp[0][j] = 1;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }


    public static void main(String[] args) {
        L221 l = new L221();
    }
}
