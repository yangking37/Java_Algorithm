package com.sky;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m); // 取得能从num1中取的最小长度和最大长度
        for (int i = start; i <= end; ++i) {
            int[] sub1 = getMaxSub(nums1, i); // 从num1中取i个数
            int[] sub2 = getMaxSub(nums2, k - i); // 从num2中取k-i个数
            int[] mergeSeq = merge(sub1, sub2); // 合并两个数列
            if (compare(mergeSeq, 0, res, 0) > 0) { // 比较两个数列
                res = mergeSeq;
            }
        }
        return res;
    }

    public int[] getMaxSub(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; ++i) {
            while (top >= 0 && stack[top] < nums[i] && n - i >= k - top) {
                --top;
            }
            if (top < k - 1) {
                stack[++top] = nums[i];
            }
        }
        return Arrays.copyOfRange(stack, 0, k);
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m == 0)
            return nums2;
        if (n == 0)
            return nums1;
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (compare(nums1, i, nums2, j) > 0) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];
        }
        return res;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

}
