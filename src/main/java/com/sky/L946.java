package com.sky;

import java.util.Stack;

public class L946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack< Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < pushed.length){
            stack.push(pushed[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]){
                stack.pop();
                popIndex++;
            }
            pushIndex++;
        }
        return stack.isEmpty();
    }
}
