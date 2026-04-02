package com.sky;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L498 {
    public int[] findDiagonalOrder(int[][] mat) {
//        int i = 0;
//        int j = 0;
//        int n = mat.length;
//        int m = mat[0].length;
//        List<Integer> list = new ArrayList<>();
//        while (i != mat.length - 1 || j != mat[0].length - 1) {
//            // 右上对角线
//            while (i != mat.length - 1 || j != mat[0].length - 1) {
//                list.add(mat[i][j]);
//                if (i - 1 < 0 || j + 1 >= m) {
//                    break;
//                } else {
//                    i--;
//                    j++;
//                }
//            }
//            if (j + 1 < m)
//                j++;
//            else if (i + 1 < n)
//                i++;
//            // 左下对角线
//            while (i != mat.length - 1 || j != mat[0].length - 1) {
//                list.add(mat[i][j]);
//                if (i + 1 >= n || j - 1 < 0) {
//                    break;
//                } else {
//                    i++;
//                    j--;
//                }
//            }
//            if (i + 1 < n) {
//                i++;
//            } else if (j + 1 < m) {
//                j++;
//            }
//        }
//        list.add(mat[i][j]);
//        return list.stream().mapToInt(Integer::intValue).toArray();

        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int k = 0;
        for (int i = 0; i < m + n - 1; ++i) {
            int x, y;
            // 起点 x + y = i
            if (i % 2 == 0) {
                if (i < m) {
                    x = i;
                    y = 0;
                } else {
                    x = m - 1;
                    y = i - m + 1;
                }
                // 遍历
                while (x >= 0 && y < n) {
                    ans[k] = mat[x][y];
                    k++;
                    x--;
                    y++;
                }
            } else {
                if (i < n) {
                    x = 0;
                    y = i;
                } else {
                    x = i - n + 1;
                    y = n - 1;
                }
                // 遍历
                while (x < m && y >= 0) {
                    ans[k] = mat[x][y];
                    k++;
                    x++;
                    y--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] mat = {{1, 2},{ 3, 4}, };
        L498 l498 = new L498();
        System.out.println(Arrays.toString(l498.findDiagonalOrder(mat)));
    }
}
