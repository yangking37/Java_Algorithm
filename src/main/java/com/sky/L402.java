package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L402 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !deque.isEmpty() && num.charAt(deque.peek()) - '0' > num.charAt(i) - '0') {
                deque.pop();
                k--;
            }
            deque.push(i);
        }
        StringBuilder str = new StringBuilder();
        while (!deque.isEmpty()) {
            str.append(num.charAt(deque.pop()));
        }
        // 删前导0，删未删除完的值
        while (!str.isEmpty() && str.charAt(str.length() - 1) == '0')
            str.deleteCharAt(str.length() - 1);
        if (k > 0 && str.length() > k) {
            String substring = str.reverse().substring(0, str.length() - k);
            while (!str.isEmpty() && str.charAt(str.length() - 1) == '0')
                str.deleteCharAt(str.length() - 1);
            return substring;
        } else {
            if (k > 0)
                return "0";
            return str.isEmpty() ? "0" : str.reverse().toString();
        }
    }

    public static void main(String[] args) {
        L402 l402 = new L402();
        System.out.println(l402.removeKdigits("1432219", 3));
    }
}
