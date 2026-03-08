package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L994 {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    stack.offer(i * cols + j);
            }
        }
        int size = stack.size();
        int count = size;
        while (!stack.isEmpty()) {
            int rowAndCol = stack.poll();
            int row = rowAndCol / cols;
            int col = rowAndCol % cols;
            if (row - 1 >= 0 && grid[row - 1][col] == 1) { // 向上
                stack.offer((row - 1) * cols + col);
                grid[row - 1][col] = 3;
            }
            if (row + 1 < rows && grid[row + 1][col] == 1) { // 向下
                stack.offer((row + 1) * cols + col);
                grid[row + 1][col] = 3;
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1) { // 向左
                stack.offer(row * cols + col - 1);
                grid[row][col - 1] = 3;
            }
            if (col + 1 < cols && grid[row][col + 1] == 1) { // 向右
                stack.offer(row * cols + col + 1);
                grid[row][col + 1] = 3;
            }
            --size;
            if (size == 0) {
                size = stack.size();
                ans++;
            }
        }
        for (int[] ints : grid) { // 看是否有1仍然存在
            for (int j = 0; j < cols; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        if (count == 0) return 0; // 防止只有零的情况
        return ans == 0 ? -1 : ans - 1;
    }

    public static void main(String[] args) {
        L994 l200 = new L994();
//        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid = new int[][]{{0}};
        System.out.println(l200.orangesRotting(grid));
    }
}
