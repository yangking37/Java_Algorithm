package com.common;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
//        int search = Arrays.binarySearch(nums, target);
//        return search >= 0 ? search : -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (target < nums[m]) j = m - 1;
            else if (target > nums[m]) i = m + 1;
            else return m;
        }
        return -1;
    }
}
