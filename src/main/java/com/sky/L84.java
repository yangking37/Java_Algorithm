package com.sky;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L84 {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < newHeights.length; i++) {
            if (stack.isEmpty() || newHeights[i] >= newHeights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int top = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int right = i;
                        int height = newHeights[top];
                        int width = right - left - 1;
                        maxArea = Math.max(maxArea, height * width);
                    }
                }
                stack.push(i);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        L84 l739 = new L84();
        System.out.println(l739.largestRectangleArea(new int[]{4,4,4}));
    }
}
