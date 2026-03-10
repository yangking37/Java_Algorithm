package com.sky;

import java.util.Arrays;

public class L79 {
    boolean flag = false;
    int[] row = {1, -1, 0, 0};
    int[] col = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(visited[i], true);
        }
        char ch = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ch){
                    visited[i][j] = false;
                    DFS(board, word, 1, i, j,visited);
                    visited[i][j] = true;
                }
                if (flag)
                    return true;
            }
        }
        return false;
    }

    public void DFS(char[][] board, String word, int len, int i, int j, boolean[][] visited) {
        if (word.length() == len) {
            flag = true;
            return;
        }
        char ch = word.charAt(len);
        for (int k = 0; k < 4; k++) {
            int x = i + row[k];
            int y = j + col[k];
            if (x <= board.length - 1 && y <= board[0].length - 1 && x >= 0 && y >= 0 && board[x][y] == ch && visited[x][y]) {
                visited[x][y] = false;
                DFS(board, word, len + 1, x, y, visited);
                visited[x][y] = true;
            }
        }
    }

    public static void main(String[] args) {
        L79 l79 = new L79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(l79.exist(board, "ABCB"));
    }
}
