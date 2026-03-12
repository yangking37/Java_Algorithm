package com.sky;

import java.util.Scanner;

public class L45 {

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;

    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        L45 l22 = new L45();
        System.out.println(l22.jump(nums));

    }
}
