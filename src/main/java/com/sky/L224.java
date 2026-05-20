package com.sky;

import java.util.Deque;
import java.util.LinkedList;

public class L224 {

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
            } else if (s.charAt(i) == ')') {
                ops.pop();
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
                continue;
            }
            i++;
        }
        return ret;
    }

    // 递归解法
    int i = 0;
    public int calculate2(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                //用来获取数字
            } else if (c == '+' || c == '-') {
                res += sign * num;
                //用来进行求和
                num = 0;
                sign = c == '+' ? 1 : -1;
                //这个是下一个数的前缀

            } else if (c == '(') {
                num = calculate(s);
                //为了求括号里的表达式，直到遇见‘）’
            } else if (c == ')') {
                res += sign * num;
                return res;
                //通过 返回res来结束递归调用
            }
        }
        res += sign * num;
        return res;
    }


    public static void main(String[] args) {
        L224 l = new L224();
        System.out.println(l.calculate("(1+(4+5+2)-3)-(6+8)"));
    }
}
