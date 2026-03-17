package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L46 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] tmp = new boolean[nums.length];
        AddNums(nums, new ArrayList<>(), tmp);
        return res;
    }

    public void AddNums(int[] nums, List<Integer> list, boolean[] tmp) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));
        for (int i = 0; i < nums.length; i++) {
            if (!tmp[i]) {
                list.add(nums[i]);
                tmp[i] = true;
                AddNums(nums, list, tmp);
                tmp[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        L46 l46 = new L46();
        System.out.println(l46.permute(a));
    }
}
