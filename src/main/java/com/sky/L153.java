package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L153 {

    int ans = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1])
            return nums[0];
        BinaryFind(nums, 0, nums.length - 1);
        return ans;
    }

    public void BinaryFind(int[] nums, int start, int end) {
        if (start > end)
            return;
        if (nums[start] > nums[end]) {
            int mid = start + (end - start) / 2;
            BinaryFind(nums, start, mid);
            BinaryFind(nums, mid + 1, end);
        }
        ans = Math.min(ans, nums[start]);
    }

    //方法二，直接二分
    // 注意这里出循环的条件为low小于high，而一般的二分条件是小于等于，
    // 这里应为不需要判断是否等于target值，所以当low=high时就是最小值
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        L153 obj = new L153();
        System.out.println(obj.findMin(a));
    }
}
