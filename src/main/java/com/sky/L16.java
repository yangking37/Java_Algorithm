package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int Maxdiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                int diff = Math.abs(sum - target);
                if (diff < Maxdiff) {
                    Maxdiff = diff;
                    res = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-1, 2, 1, -4};
        L16 l16 = new L16();
        System.out.println(l16.threeSumClosest(a, 1));
    }
}
