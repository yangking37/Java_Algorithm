package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] tmp = new boolean[nums.length];
        Arrays.sort(nums); // 去重之前要排序，因为去重是基于排序后的数组进行的，相同的数字会排在一起
        AddNums(nums, new ArrayList<>(), tmp);
        return res;
    }

    public void AddNums(int[] nums, List<Integer> list, boolean[] tmp) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !tmp[i - 1] && nums[i] == nums[i - 1]) {
                continue; // 跳过重复的数字,树层去重
            }
            if (!tmp[i]) {
                list.add(nums[i]); // 添加数字
                tmp[i] = true; // 标记为已使用
                AddNums(nums, list, tmp); // 递归
                tmp[i] = false; // 回溯，标记为未使用
                list.remove(list.size() - 1); // 移除数字
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        L47 l46 = new L47();
        System.out.println(l46.permuteUnique(a));
    }
}
