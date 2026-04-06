package com.sky;

public class L59 {
    public int[][] generateMatrix(int n) {
        int k = 0;
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (k < n * n) {
            for (int x = left; x <= right && k <= n * n; x++)
                res[top][x] = ++k;
            top++;
            for (int y = top; y <= bottom && k <= n * n; y++)
                res[y][right] = ++k;
            right--;
            for (int x = right; x >= left && k <= n * n; x--)
                res[bottom][x] = ++k;
            bottom--;
            for (int y = bottom; y >= top && k <= n * n; y--)
                res[y][left] = ++k;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        L59 l = new L59();
        int[][] res = l.generateMatrix(4);
        for (int[] row : res) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
