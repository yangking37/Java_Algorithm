package com.sky;

import java.util.HashSet;
import java.util.Set;

public class L11 {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int min = Math.min(height[left], height[right]); // 短板
        int container = min * (height.length - 1); // 第一次测量的长度
        while (left < right) {
            if (min == height[left]) left++; // 找到一个比短板要长的
            else right--; // 找到一个比短板要长的
            min = Math.min(height[left], height[right]);
            container = Math.max(min * (right - left), container);
        }
        return container;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
