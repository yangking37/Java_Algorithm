package com.sky;

public class L53 {

    public int maxSubArray(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int max = prefix[0];
        int min = Math.min(0,max);
        for (int i = 1; i < prefix.length; i++) {
            max = Math.max(prefix[i]-min, max);
            if (prefix[i] < min) min = prefix[i]; // 记录最小的负数
        }
        return max;
    }

    public static void main(String[] args) {
        L53 l53 = new L53();
        System.out.println(l53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
