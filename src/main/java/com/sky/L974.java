package com.sky;

import java.util.HashMap;

public class L974 {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            int remain = sum % k;
            if (remain < 0) remain += k; // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            if (map.containsKey(remain)) {
                ans += map.get(remain);
                map.put(remain, map.get(remain) + 1);
            } else {
                map.put(remain, 1);
            }
        }
        return ans;
    }
}
