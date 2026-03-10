package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L22 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        Dfs(n, n, sb);
        return res;
    }

    public void Dfs(int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            String s = sb.toString();
            res.add(s);
            return;
        }
        if (left >= 0 && left <= right) {
            if (left > 0) {
                sb.append('(');
                Dfs(left - 1, right, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right > left) {
                sb.append(')');
                Dfs(left, right - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int a = 3;
        L22 l22 = new L22();
        System.out.println(l22.generateParenthesis(a));
    }
}
