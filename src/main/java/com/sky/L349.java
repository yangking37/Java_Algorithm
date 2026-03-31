package com.sky;

import java.util.HashSet;

public class L349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] resultArray = new int[result.size()];
        int i = 0;
        for (int num : result) {
            resultArray[i++] = num;
        }
        return resultArray;
    }
}
