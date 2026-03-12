package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L155 {
    class MinStack {
        Deque<Integer> stack1;
        Deque<Integer> minstack;

        public MinStack() {
            stack1 = new ArrayDeque<>();
            minstack = new ArrayDeque<>();
            minstack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack1.push(val);
            stack1.push(Math.min(val, minstack.peek()));
        }

        public void pop() {
            stack1.pop();
            minstack.pop();
        }

        public int top() {
            if (!stack1.isEmpty())
                return stack1.peek();
            return -1;
        }

        public int getMin() {
            return minstack.peek();
        }
    }
}
