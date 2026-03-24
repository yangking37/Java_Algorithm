package com.sky;

public class L162 {
    int m = -1;
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        findPeak(nums, left, right);
        return m;
    }

    public void findPeak(int[] nums, int left, int right) {
        if (left >= right || m != -1) return;
        int mid = left + (right - left) / 2;
        findPeak(nums, left, mid);
        findPeak(nums, mid + 1, right);
        if (mid == 0 && nums[mid] > nums[mid + 1]) {
            m = mid;
        } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            m = mid;
        } else if (mid != 0 && mid != nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            m = mid;
        }
    }

    public static void main(String[] args) {
        L162 l162 = new L162();
        int[] nums = {3, 4, 3, 2, 1};
        int i = l162.findPeakElement(nums);
        System.out.println(i);
    }
}
