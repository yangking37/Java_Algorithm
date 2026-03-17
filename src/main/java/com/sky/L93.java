package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L93 {
    List<String> ans = new ArrayList<>();
    List<String> t = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 4);   // 4表示需要有4段
        return ans;
    }

    public void dfs(String s, int i, int k) {
        if (k == 0) { // 剪枝，将小于零的过滤掉
            if (i == s.length())
                ans.add(String.join(".", t));
            return;
        }
        for (int j = i; j < s.length() && j < i + 3; ++j) {
            if (s.charAt(i) == '0' && j > i) return;    // 不能是前导0
            int v = Integer.parseInt(s.substring(i, j + 1));
            if (v >= 0 && v <= 255) {
                t.add(s.substring(i, j + 1));
                dfs(s, j + 1, k - 1);
                t.remove(t.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        L93 l93 = new L93();
        System.out.println(l93.restoreIpAddresses("25525511135"));
    }
}
