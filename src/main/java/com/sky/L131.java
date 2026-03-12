package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L131 {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return ret;
    }
    public void dfs(String s, int i) {
        if (i == s.length()) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        L131 l131 = new L131();
        System.out.println(l131.partition("aab"));
    }
}
