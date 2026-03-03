package com.sky;

import java.util.HashSet;
import java.util.Set;

public class L136 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
//        int[] a = {0,3,7,2,5,8,4,6,0,1};
//        System.out.println(longestConsecutive(a));
    }
}
