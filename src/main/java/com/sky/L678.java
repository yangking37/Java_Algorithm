package com.sky;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L678 {

    // 贪心写法
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0; // 维护未匹配的左括号数量
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') { // 遇到左括号，最小值加一，最大值加一
                minCount++;
                maxCount++;
            } else if (c == ')') { // 遇到右括号，最小值减一，最大值减一
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) { //任何情况下，未匹配的左括号数量必须非负
                    return false;
                }
            } else { // 遇到星号，最小值减一，最大值加一
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0; // 最终未匹配的左括号数量必须为零
    }

    // 解法二，栈 在有星号的情况下，需要两个栈分别存储左括号和星号。
    public boolean checkValidString2(String s) {
        Deque<Integer> leftStack = new LinkedList<Integer>();
        Deque<Integer> asteriskStack = new LinkedList<Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

    public static void main(String[] args) {
        L678 l53 = new L678();
        System.out.println(l53.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}
