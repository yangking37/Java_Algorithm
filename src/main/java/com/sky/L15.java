package com.sky;

import java.util.*;

public class L15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 同样是避免重复
            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];
            while (l<r){
                int sum = nums[l] + nums[r];
                if (target == sum){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    // 跳过重复元素
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }else if(target > sum)
                    l++;
                else
                    r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(a));
    }
}
