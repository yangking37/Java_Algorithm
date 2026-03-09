package com.sky;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        stack.offer(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        res[temperatures.length - 1] = 0;
        return res;
    }

    public static void main(String[] args) {
        L739 l739 = new L739();
        System.out.println(Arrays.toString(l739.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
