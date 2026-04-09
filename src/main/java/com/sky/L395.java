package com.sky;

public class L395 {
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        boolean valid = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) valid = false;
        }
        if (valid) return s.length(); // 所有字符都大于等于k
        int i = 0, j = 0;
        int res = 0;
        while (j < s.length()) {
            if (count[s.charAt(j) - 'a'] < k) { // 对于当前字符小于k，那么必须进行分割
                res = Math.max(res, longestSubstring(s.substring(i, j), k));
                j = j + 1;
                i = j;
            } else { // 当前字符大于等于k，那么可以继续向右扩展
                j++;
                if (j == s.length()){ // 如果j到达字符串末尾，则需要进行一次分割
                    res = Math.max(res, longestSubstring(s.substring(i, j), k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L395 l = new L395();
        System.out.println(l.longestSubstring("cababb", 2));
    }
}
