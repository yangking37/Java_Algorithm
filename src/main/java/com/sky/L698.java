package com.sky;

import java.util.Arrays;

public class L698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        return canPartition(nums, k, 0, new boolean[nums.length], 0, target);
    }

    private boolean canPartition(int[] nums, int k, int index, boolean[] used, int curSum, int target) {
        if (k == 0) return true;
        if (curSum == target) {
            return canPartition(nums, k - 1, 0, used, 0, target);
        }
        for (int i = index; i < nums.length; i++) {
            if (!used[i] && curSum + nums[i] <= target) {
                used[i] = true;
                if (canPartition(nums, k, i + 1, used, curSum + nums[i], target)) return true;
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L698 l698 = new L698();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(l698.canPartitionKSubsets(nums, 3));
    }
}
