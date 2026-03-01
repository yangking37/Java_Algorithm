package com.sky;

import java.util.HashMap;
import java.util.Map;

public class L76 {
    Map<Character, Integer> tmap = new HashMap<>(); // 用来存储t中字符出现的次数
    Map<Character, Integer> smap = new HashMap<>(); // 用来存储s中字符出现的次数
    // 方法一
    public String minWindow(String s, String t) {
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        System.out.println(tmap.size());
        int ansL = 0, ansR = 0;
        int left = 0, right = -1;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length() - 1) {
            right++;
            if (tmap.containsKey(s.charAt(right))) {
                smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansL = left;
                    ansR = left+minLen;
                }
                // 删除已经来过的单词
                smap.put(s.charAt(left), smap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (smap.getOrDefault(key, 0) < val)
                return false;
        }
        return true;
    }

    // 方法二
    //没有在每次移动右边时进行重复的判断，而是采用一个flag,记录t字符串的需要的种类，
    //flag会在每次移动右边时进行判断当前加入的字母数量是否正好等于需要的数量，如若是则加一，当flag等于模式串的长度时
    //标明当前满足模式串的一个子串，同理，删除字符串也是同样的判断方法
    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        L76 l76 = new L76();
        System.out.println(l76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
