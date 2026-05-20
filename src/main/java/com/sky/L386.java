package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L386 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return list;
    }

    public void dfs(int cur, int limit) {
        if (cur > limit) return;
        list.add(cur);
        if(cur*10>limit) return; // 剪枝
        for (int i = 0; i <= 9; i++) {
            dfs(cur * 10 + i, limit);
        }
    }

    public static void main(String[] args) {
        L386 l386 = new L386();
        System.out.println(l386.lexicalOrder(130));
    }
}
