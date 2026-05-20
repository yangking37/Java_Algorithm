package com.sky;

import java.util.Arrays;

public class L1099 {
    public int towSumLessThanK(int[] A, int K) {
        int n = A.length;
        int left = 0, right = n - 1;
        int res = 0;
        Arrays.sort(A);
        while (left < right) {
            if (A[left] + A[right] < K) {
                res += right - left;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
