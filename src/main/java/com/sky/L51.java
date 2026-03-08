package com.sky;

import java.util.*;

class L51 {
    List<List<String>> ans = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        DFS(board,0);
        return ans;
    }
    public void DFS(char[][] board, int row) {
        if (row == board.length) {
            List<String> res = new ArrayList<>();
            for (char[] chars : board) {
                res.add(new String(chars));
            }
            ans.add(res);
            return;
        }
        for (int i = 0; i < board.length; i++) { // 每次循环列数
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                DFS(board, row + 1);
                board[row][i] = '.';
            }
        }
    }
    public Boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) { // 判断列
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        int tempRow = row; // 特别注意不能删除原来的行与列
        int tempCol = col;
        while (tempRow - 1 >= 0 && tempCol - 1 >= 0) { // 判断左上
            if (board[tempRow - 1][tempCol - 1] == 'Q') {
                return false;
            }
            tempRow -= 1;
            tempCol -= 1;
        }
        tempRow = row;
        tempCol = col;
        while (tempRow - 1 >= 0 && tempCol + 1 < board.length) {
            if (board[tempRow - 1][tempCol + 1] == 'Q') {// 判断右上
                return false;
            }
            tempRow -= 1;
            tempCol += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        L51 solver = new L51();
        System.out.println(solver.solveNQueens(8).size());
    }
}