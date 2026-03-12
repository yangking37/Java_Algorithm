package com.sky;

import java.util.Arrays;

public class L31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i + 1);
        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 0, 2, 3, 2, 0};
//        int[] a = {9,8,7,6,5,4,3,2,1};
        L31 l = new L31();
        l.nextPermutation(a);
    }
}
