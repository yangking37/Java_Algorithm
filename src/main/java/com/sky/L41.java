package com.sky;

public class L41 {

    public static int firstMissingPositive(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (num == 1) {
                ans = 1;
                break;
            }
        }
        int index = nums[0];
        if (ans == 1) {// 存在1
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= nums.length+1 || nums[i] <= 0) // 将超过限制的设置为1
                    nums[i] = 1;
            }
            for (int i = 0; i < nums.length; i++) {
                index = Math.abs(nums[i]) - 1;
                nums[index] = -Math.abs(nums[index]);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 1) {
                    return i + 1;
                }
            }
        } else { // 不存在1
            return 1;
        }
        return nums.length + 1; // 如果到这了，返回长度加1
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 0};
        System.out.println(firstMissingPositive(a));
    }
}
