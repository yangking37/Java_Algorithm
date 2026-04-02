package com.sky;

import java.util.HashMap;
import java.util.Map;

class L208 {
    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie cur = this;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                if (cur.children[aChar - 'a'] == null) {
                    cur.children[aChar - 'a'] = new Trie();
                }
                cur = cur.children[aChar - 'a'];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            Trie cur = this;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                if (cur.children[aChar - 'a'] == null) {
                    return false;
                }
                cur = cur.children[aChar - 'a'];
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie cur = this;
            char[] chars = prefix.toCharArray();
            for (char aChar : chars) {
                if (cur.children[aChar - 'a'] == null) {
                    return false;
                }
                cur = cur.children[aChar - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        L208 l208 = new L208();
        Trie head = l208.new Trie();
        head.insert("apple");
        System.out.println(head.search("apple"));
    }
}