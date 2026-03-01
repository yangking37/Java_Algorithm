package com.sky;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L189 {

    // 方法一
    public static void rotate(int[] nums, int k) {
        int len = nums.length - 1;
        while (k >= nums.length && k != 0) k -= nums.length;
        if (k > Math.ceil(nums.length >> 1)) { // 标明是向左旋转
            // 首先将要旋转的进行交换
            k = nums.length - k;
            int[] subList = new int[k];
            System.arraycopy(nums, len - k + 1, subList, 0, k);
            for (int i = 0; i < k; i++) {
                int temp = nums[i];
                nums[i] = nums[len + 1 - k + i];
                nums[len + 1 - k + i] = temp;
            }
            for (int i = k; i <= len - k + 1; i++) {
                nums[i - k] = nums[i];
            }
            for (int i = 0; i < subList.length; i++) {
                nums[len - 2 * k + 1 + i] = subList[i];
            }
//            System.out.println(Arrays.toString(nums));
        } else {  // 向右旋转
            int[] subList = new int[k];
            System.arraycopy(nums, 0, subList, 0, k);
            for (int i = 0; i < k; i++) {
                int temp = nums[i];
                nums[i] = nums[len + 1 - k + i];
                nums[len + 1 - k + i] = temp;
            }
            for (int i = len - k; i > k - 1; i--) { // 从len-k开始向移动
                nums[i + k] = nums[i];
            }
            for (int i = 0; i < subList.length; i++) {
                nums[i + k] = subList[i];
            }
//            System.out.println(Arrays.toString(nums));
        }
    }

    // 方法二(数组反转)
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int[] a = {-1,-100,3,99};
        rotate(a, 2);
    }
}
