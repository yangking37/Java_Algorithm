package com.sky;

public class L316 {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        boolean[] visited = new boolean[26];  // 记录字符是否已在结果中

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a']--;  // 减少当前字符的剩余计数

            if (visited[c - 'a']) {  // 如果已经在结果中，跳过
                continue; // 因为在这之前字典序已经是最小的了，如果再加进去就不一定s是最小的了
            }

            // 当栈顶字符大于当前字符，且栈顶字符后面还会出现
            while (!sb.isEmpty() &&
                    sb.charAt(sb.length() - 1) > c &&
                    cnt[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                // 移除栈顶字符
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
            visited[c - 'a'] = true;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        L316 l = new L316();
        System.out.println(l.removeDuplicateLetters("acbacb"));
    }
}
