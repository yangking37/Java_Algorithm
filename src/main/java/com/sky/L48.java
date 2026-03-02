package com.sky;

import java.util.ArrayList;
import java.util.Arrays;

public class L48 {

    // 方法一正着来
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int index = n - 1;
        int tempi = 0;
        int tempj = 0;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            if (i == n / 2) break;
            for (int j = i; j < n - i - 1; j++) {
                temp = matrix[i][j];
                tempi = j;
                tempj = index - i;
                while (tempi != i || tempj != j) {
                    int swap = matrix[tempi][tempj];
                    matrix[tempi][tempj] = temp;
                    temp = swap;
                    int swap2 = tempi;
                    tempi = tempj;
                    tempj = index - swap2;
                }
                matrix[tempi][tempj] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    // 方法二反着来
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    // 方法三，水平翻转加上对角线翻转
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] a = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(a);
    }
}
