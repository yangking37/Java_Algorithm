package com.sky;

import java.util.HashMap;

public class L525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;
            sum += nums[i];
            map.putIfAbsent(sum, i); // 保证是最长的
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            }
        }
        return ans;
    }
}
