package com.sky;

import java.util.ArrayList;
import java.util.List;

class L17 {
    List<String> ans = new ArrayList<>();
    char[] two = new char[]{'a', 'b', 'c' };
    char[] three = new char[]{'d', 'e', 'f' };
    char[] four = new char[]{'g', 'h', 'i' };
    char[] five = new char[]{'j', 'k', 'l' };
    char[] six = new char[]{'m', 'n', 'o' };
    char[] seven = new char[]{'p', 'q', 'r', 's' };
    char[] eight = new char[]{'t', 'u', 'v' };
    char[] nine = new char[]{'w', 'x', 'y', 'z' };

    public List<String> letterCombinations(String digits) {
        List<Character> list = new ArrayList<Character>();
        dfs(digits, list, 0);
        return ans;
    }

    public void dfs(String digits, List<Character> res, int len) {
        if (res.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character re : res) {
                sb.append(re);
            }
            ans.add(sb.toString());
            return;
        }
        char ch = digits.charAt(len);
        if (ch == '9') {
            for (char c : nine) {
                res.add(c);
                dfs(digits, res, len + 1);
                res.remove(res.size() - 1);
            }
        } else if (ch == '2') {
            for (char c : two) {
                res.add(c);
                dfs(digits, res, len + 1);
                res.remove(res.size() - 1);
            }
        } else if (ch == '3') {
            for (char c : three) {
                res.add(c);
                dfs(digits, res, len + 1);
                res.remove(res.size() - 1);
            }
        } else if (ch == '4') {
            for (char c : four) {
                res.add(c);
                dfs(digits, res, len + 1);
                res.remove(res.size() - 1);
            }
        } else if (ch == '5') {
            for (char c : five) {
                res.add(c);
                dfs(digits, res, len + 1);
                res.remove(res.size() - 1);
            }
        } else if (ch == '6') {
            for (char c : six) {
                res.add(c);
                dfs(digits, res, len + 1);
                res.remove(res.size() - 1);
            }
        } else if (ch == '7') {
            for (char c : seven) {
                res.add(c);
                dfs(digits, res, len + 1);
                res.remove(res.size() - 1);
            }
        } else if (ch == '8') {
            for (char c : eight) {
                res.add(c);
                dfs(digits, res, len + 1);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        L17 l17 = new L17();
        System.out.println(l17.letterCombinations("23"));
    }
}