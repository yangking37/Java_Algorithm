package com.sky;

import java.util.Arrays;
import java.util.Comparator;

public class L179 {

    // 基数排序
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, (a, b) -> (a + b).compareTo(b + a));
        if (numsStr[0].equals("0"))
            return "0";
        return String.join("", numsStr);
    }

    public static void main(String[] args) {
        L179 l53 = new L179();
        System.out.println(l53.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
