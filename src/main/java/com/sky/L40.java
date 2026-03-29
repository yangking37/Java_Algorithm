package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.fill(visited, false);
        Arrays.sort(candidates);
        dfs(candidates, target, 0, list, visited);
        return res;
    }

    public void dfs(int[] candidates, int target, int index, List<Integer> list, boolean[] visited) {
        if (0 == target) {
            res.add(new ArrayList<>(list));
        } else
            for (int i = index; i < candidates.length; i++) {
                if (target < candidates[i]) continue;  // 剪枝
                if (i > 0 && !visited[i - 1] && candidates[i] == candidates[i - 1]) continue;
                if (!visited[i]) {
                    list.add(candidates[i]);
                    visited[i] = true;  // 标记为已使用
                    dfs(candidates, target - candidates[i], i+1, list, visited);
                    visited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
    }

    public static void main(String[] args) {
        int[] a = {2,5,2,1,2};
//        int[] a = {2, 3, 5};
        L40 l39 = new L40();
        System.out.println(l39.combinationSum2(a, 5));
    }
}
