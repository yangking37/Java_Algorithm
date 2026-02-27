package com.sky;

import java.util.*;

public class L128 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // 去重
        }
        int longBreak = 0;
        for (Integer i : set) {
            int CurrentNum = i;
            int CurrentBreak = 1;
            if (!set.contains(CurrentNum + 1)) { // 添加效率，对于存在直接后驱的进行过滤
                while (set.contains(CurrentNum - 1)) { // 那么能够进来的就是某个连续子序列最大的数
                    CurrentNum--;
                    CurrentBreak++;
                }
            }
            longBreak = Math.max(longBreak, CurrentBreak);
        }
        return longBreak;
    }

    public static void main(String[] args) {
//        int[] a = {0,3,7,2,5,8,4,6,0,1};
//        System.out.println(longestConsecutive(a));
    }
}
