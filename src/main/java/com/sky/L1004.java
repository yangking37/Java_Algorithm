package com.sky;

public class L1004 {
    public int longestOnes(int[] nums, int k) {
//        int left = 0;
//        int right = 0;
//        int zero = k;
//        int res = 0;
//        while (right < nums.length) {
//            while (right < nums.length && zero >= 0) {
//                if (nums[right] == 0) {
//                    zero--;
//                    if (zero < 0) break;
//                }
//                right++;
//            }
//            res = Math.max(res, right - left);
//            while (zero < 0 && left < nums.length) {
//                if (nums[left] == 0) {
//                    zero++;
//                    right++;
//                }
//                left++;
//            }
//        }
//        return res;

        // 简短写法
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) k--;
            if (k < 0 && nums[l++] == 0) k++;
        }
        return r - l;
    }

    public static void main(String[] args) {
        L1004 l1004 = new L1004();
        System.out.println(l1004.longestOnes(new int[]{1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0}, 2));
    }
}
