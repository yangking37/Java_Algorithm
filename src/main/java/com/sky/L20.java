package com.sky;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            }else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
            }else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        L20 l22 = new L20();
        System.out.println(l22.isValid(s1));
    }
}
