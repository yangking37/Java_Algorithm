package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L394 {
    public String decodeString(String s) {
        Deque<String> ChStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            ChStack.push(String.valueOf(s.charAt(i)));
            if (s.charAt(i) == ']') {
                getDecodeString(ChStack);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!ChStack.isEmpty()) {
            res.append(ChStack.pop());
        }
        return res.reverse().toString();
    }

    private void getDecodeString(Deque<String> chStack) {
        StringBuilder StringTemp = new StringBuilder();
        while (!chStack.isEmpty()) {
            if (!chStack.peek().matches("[0-9]")) {
                StringTemp.append(chStack.pop());
            } else
                break;
        }
        StringTemp.deleteCharAt(StringTemp.length() - 1);
        StringTemp.deleteCharAt(0); // 去除两个括号
        StringBuilder DigitTemp = new StringBuilder();
        while (!chStack.isEmpty()) {
            if (chStack.peek().matches("[0-9]")) {
                DigitTemp.append(chStack.pop());
            } else
                break;
        }
        String s = String.valueOf(StringTemp).repeat(Integer.parseInt(DigitTemp.reverse().toString()));
        chStack.push(s);
    }

    public static void main(String[] args) {
        L394 l394 = new L394();
        System.out.println(l394.decodeString("100[leetcode]"));
    }
}
