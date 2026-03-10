package com.sky;

import java.util.Arrays;

public class L74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int t = -1;
        int first = Arrays.binarySearch(matrix[0], target);
        if (first >= 0) return true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) return true;
            if (matrix[i][0] > target) {
                t = i - 1;
                break;
            }
        }
        if (t == -1) {
            int last = Arrays.binarySearch(matrix[matrix.length - 1], target);
            return last >= 0;
        }
        int[] tt = matrix[t];
        int res = Arrays.binarySearch(tt, target);
        return res >= 0;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int l = 0, r = matrix.length * matrix[0].length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 13;
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix2(a, target));
    }
}
