package com.sky;

public class L209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = nums.length - 1;
        int ll = 0, sum = 0;
        int length = Integer.MAX_VALUE;
        sum += nums[ll];
        while (l <= r) {
            if (sum < target) {
                while (ll < r && sum < target) {
                    ll++;
                    sum += nums[ll];
                }
            }
            if (sum >= target)
                length = Math.min(length, ll - l + 1);
            sum -= nums[l];
            l++;
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
