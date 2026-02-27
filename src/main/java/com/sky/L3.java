package com.sky;

import java.util.*;
import java.util.stream.Collectors;

public class L3 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        int l = 0, r = ss.length - 1, lr = l;
        int ans = 0;
        while (lr <= r && l <= r) {
            if (map.containsKey(ss[lr]) && map.get(ss[lr]) != 0) {
//                map.put(ss[l], map.get(ss[l]) + 1);
                while (l <= lr && ss[l] != ss[lr]) {
                    map.put(ss[l], 0);
                    l++;
                }
                l++; // 当结束while循环时是相等的字符，所以需要再次向前一步
                lr++;
            } else {
                map.put(ss[lr], 1);
                lr++;
                ArrayList<Integer> tempList = new ArrayList<>(map.values());
                List<Integer> collect = tempList.stream().filter(i -> i != 0).toList();
                ans = Math.max(ans, collect.toArray().length);
            }
        }
        return ans;
    }

    // 解法2
    public static int lengthOfLongestSubstringNo2(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int rk = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i-1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk+1))) {
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
        System.out.println(lengthOfLongestSubstringNo2(s));
    }
}
