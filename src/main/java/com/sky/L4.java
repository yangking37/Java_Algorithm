package com.sky;

import java.util.HashMap;
import java.util.Map;

class L4 {

    //思路，划分数组
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length; // 保持m为长度小的数组长度
        int n = nums2.length;
        int left = 0;
        int right = m;
        int median1 = 0, median2 = 0;
        while (left <= right) {
            int nums1mid = (left + right) / 2;
            int nums2mid = (m + n + 1) / 2 - nums1mid;
            int left1 = (nums1mid == 0 ? Integer.MIN_VALUE : nums1[nums1mid - 1]);
            int left2 = (nums1mid == m ? Integer.MAX_VALUE : nums1[nums1mid]);
            int right1 = (nums2mid == 0 ? Integer.MIN_VALUE : nums2[nums2mid - 1]);
            int right2 = (nums2mid == n ? Integer.MAX_VALUE : nums2[nums2mid]);
            if (left1 <= right2) {
                median1 = Math.max(left1, right1);
                median2 = Math.min(left2, right2);
                left = nums1mid + 1;
            } else
                right = nums1mid - 1;
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public static void main(String[] args) {
        L4 obj = new L4();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }
}