package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L73 {

    public static void setZeroes(int[][] matrix) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) { // 记录行列
                    row.add(i);
                    col.add(j);
                }
            }
        }
        // 将行置为零
        for (Integer i : row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        // 将列置为零
        for (Integer i : col) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
//        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(a);
    }
}
