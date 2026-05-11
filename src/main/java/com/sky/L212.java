package com.sky;

import java.util.*;

public class L212 {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 4个方向

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, set, i, j, root);
            }
        }
        return new ArrayList<>(set);
    }

    public void dfs(char[][] board, HashSet<String> set, int i, int j, TrieNode node) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (!node.children.containsKey(board[i][j])) return;
        char ch = board[i][j];
        node = node.children.get(ch);
        if (!Objects.equals(node.word, "")) {
            set.add(node.word);
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            dfs(board, set, i + dir[0], j + dir[1], node);
        }
        board[i][j] = ch;
    }

    class TrieNode {
        String word;
        HashMap<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
            word = "";
        }

        public void insert(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.word = word;
        }
    }

    public static void main(String[] args) {
        L212 l212 = new L212();
        char[][] board = { {'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'} };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(l212.findWords(board, words));
    }
}
