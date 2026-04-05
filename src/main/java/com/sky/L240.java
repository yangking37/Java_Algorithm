package com.sky;

import java.util.ArrayList;
import java.util.Arrays;

public class L240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int res = Arrays.binarySearch(ints, target);
            if (res >= 0)
                return true;
        }
        return false;
    }

    //方法二，Z字形查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(a, 20));
    }
}
