package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = 0;
        list.add(matrix[i][j]);
        matrix[i][j] = 101;
        int count = 1; // count为整个矩阵中数字的个数
        while (count < row * col) {
            while (j + 1 < matrix[0].length && matrix[i][j + 1] != 101) { // 向右
                list.add(matrix[i][j + 1]);
                matrix[i][j + 1] = 101;
                j++;
                count++;
            }
            while (i + 1 < matrix.length && matrix[i + 1][j] != 101) { // 向下
                list.add(matrix[i + 1][j]);
                matrix[i + 1][j] = 101;
                i++;
                count++;
            }
            while (j > 0 && matrix[i][j - 1] != 101) { // 向左
                list.add(matrix[i][j - 1]);
                matrix[i][j - 1] = 101;
                j--;
                count++;
            }
            while (i > 0 && matrix[i - 1][j] != 101) { // 向上
                list.add(matrix[i - 1][j]);
                matrix[i - 1][j] = 101;
                i--;
                count++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        L54 l53 = new L54();
        int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(l53.spiralOrder(a));
    }
}
