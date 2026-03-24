package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L227 {

    public int calculate(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || c == '+' || c == '-') {
                stack.push(c);
            } else if (c == '*' || c == '/') {
                int Later = 0;
                char option = s.charAt(i++);
                while (i < s.length() &&
                        (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9 || s.charAt(i) == ' ')) {
                    if (s.charAt(i) == ' ') {
                        i++;
                        continue;
                    }
                    Later = Later*10 + (s.charAt(i) - '0');
                    i++;
                }
                char[] nums = calculate(Later, stack, option);
                for (Character ch : nums) stack.push(ch);
                continue;
            }
            i++;
        }
        // 计算加减
        Deque<Character> stack2 = new ArrayDeque<>();
        while (!stack.isEmpty()) stack2.push(stack.pop());
        long result = getNumFromStack2(stack2);
        while (!stack2.isEmpty()) {
            char option2 = stack2.pop();
            long num2 = getNumFromStack2(stack2);
            if (option2 == '+') result += num2;
            else result -= num2;
        }
        return (int) result;
    }

    private long getNumFromStack2(Deque<Character> stack2) {
        long result = 0;
        while (!stack2.isEmpty()) {
            if (stack2.peek() == '+' || stack2.peek() == '-') break;
            char c = stack2.pop();
            if (c - '0' >= 0 && c - '0' <= 9) {
                result = result * 10 + (c - '0');
            }
        }
        return result;
    }

    private int getNumFromStack(Deque<Character> stack) {
        int count = 0;
        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() == '+' || stack.peek() == '-') break;
            char c = stack.pop();
            if (c - '0' >= 0 && c - '0' <= 9) {
                result += (int) ((c - '0') * Math.pow(10, count++));
            }
        }
        return result;
    }

    public char[] calculate(int Later, Deque<Character> stack, Character option) {
        int PrevNum = getNumFromStack(stack);
        if (option == '*') {
            int sum = PrevNum * Later;
            return String.valueOf(sum).toCharArray();
        } else if (option == '/') {
            int sum = PrevNum / Later;
            return String.valueOf(sum).toCharArray();
        } else {
            return new char[]{};
        }
    }

    // 简便一点的方法
    public int calculate2(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        L227 l53 = new L227();
        System.out.println(l53.calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
