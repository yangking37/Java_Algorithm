package com.sky;

import java.util.*;
import java.util.stream.Collectors;

public class L3 {
    public static int lengthOfLongestSubstringNo(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int rk = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
//        String s = "pwwkew";
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstringNo(s));
    }
}
