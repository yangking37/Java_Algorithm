package com.sky;

public class L424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int start = 0, end = 0;
        int ans = 0;
        while (end < s.length()) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end++) - 'A']);
            if (end - start - maxCount > k) { // k不够用了
                count[s.charAt(start++) - 'A']--;
                ans = Math.max(ans, end - start);
            }
        }
        return Math.max(ans, end - start);
    }

    public static void main(String[] args) {

        L424 obj = new L424();
        int result = obj.characterReplacement("ABAB", 2);
        System.out.println(result);
    }
}
