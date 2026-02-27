package com.sky;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L283 {
    public static void moveZeroes(int[] nums) {
        int r = 0;
        int le = nums.length - 1;
        while (r < le) {
            while (nums[r] != 0 && r < le) // 找到一个为0的
                r++;
            int l = r + 1;
            while (l <= le && nums[l] == 0) {// 找到一个不为0的
                l++;
            }
            if (l > le)
                break;
            // 交换
            nums[r] = nums[l];
            nums[l] = 0;
            r++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes(a);
    }
}
