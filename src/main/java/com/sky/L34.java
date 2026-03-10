package com.sky;

import java.util.Arrays;

public class L34 {


    public int[] searchRange(int[] nums, int target) {
        int rightIdx = BinaryFind(target, nums, false) - 1;
        int leftIdx = BinaryFind(target, nums, true);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int BinaryFind(int target, int[] nums, boolean lower) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 10};
        int target = 8;
        L34 l34 = new L34();
        System.out.println(Arrays.toString(l34.searchRange(a, target)));
    }
}
