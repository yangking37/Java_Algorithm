package com.sky;

import java.util.HashMap;

public class L523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remain = sum % k;
            if (map.containsKey(remain)){
                if (i - map.get(remain) > 1){
                    return true;
                }
            }else {
                map.put(remain, i);
            }
        }
        return false;
    }
}
