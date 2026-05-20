package com.sky;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class L340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if (len * k == 0) return 0;
        int left = 0, right = 0;
        int ans = 0;
        // key 为字符，value 为字符在 s[left] ... s[right] 中最右边那个索引
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            map.put(s.charAt(right), right);
            right++;
            if (map.size() > k) {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        L340 l = new L340();
        System.out.println(l.lengthOfLongestSubstringKDistinct("aebeccded", 3));
    }
}
