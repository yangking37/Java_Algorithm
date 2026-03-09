package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, list);
        return res;
    }

    public void dfs(int[] candidates, int target, int index, List<Integer> list) {
        if (0 == target) {
            res.add(new ArrayList<>(list));
        } else
            for (int i = index; i < candidates.length; i++) {
                if (target < candidates[i]) continue;  // 剪枝
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, list);
                list.remove(list.size() - 1);
            }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
//        int[] a = {2, 3, 5};
        L39 l39 = new L39();
        System.out.println(l39.combinationSum(a, 8));
    }
}
