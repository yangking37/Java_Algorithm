package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L46 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] tmp = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++)
            tmp[i] = true;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (tmp[i]) {
                tmp[i] = false;
                AddNums(nums, list, nums[i],tmp);
                tmp[i] = true;
                list.remove(list.size()-1);
            }
        }
        return res;
    }

    public void AddNums(int[] originArray, List<Integer> list, int num,boolean[] tmp) {
        list.add(num);
        if (list.size() == originArray.length) {
            List<Integer> newList = new ArrayList<>(list);
            res.add(newList);
        }
        for (int i = 0; i < originArray.length; i++) {
            if (tmp[i]) {
                tmp[i] = false;
                AddNums(originArray, list, originArray[i],tmp);
                tmp[i] = true;
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        L46 l46 = new L46();
        System.out.println(l46.permute(a));
    }
}
