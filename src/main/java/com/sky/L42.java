package com.sky;

import java.util.*;

public class L42 {

    public static int trap(int[] height) {
        int l = 0, r = height.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        while (l < r) {
            int lr = l + 1;
            while (lr <= r && height[l] > height[lr]) {
                lr++;
            }
            if (lr - l < 2 || lr > r) {
                if (lr > r && lr - l > 2) {// 这种情况即第一个就是最高的，往后已经找不到更高的了
                    break; // 这种情况将其反向计算
                }
                l = lr;
                continue;
            } else {
                for (int i = l + 1; i < lr; i++) {
                    map.put(i, height[l] - height[i]);
                }
            }
            l = lr;
        }
        // 如果出现第一个就是最高的情况，那么直接反向计算
        while (r > l){
            int lr = r - 1;
            while (lr >= l && height[r] > height[lr]) {
                lr--;
            }
            if (r - lr < 2) {
                r = lr;
                continue;
            }else {
                for (int i = r - 1; i > lr; i--) {
                    map.put(i, height[r] - height[i]);
                }
            }
            r = lr;
        }
        ArrayList<Integer> res = new ArrayList<>(map.values());
        int ans = 0;
        for (Integer re : res) {
            ans += re;
        }
        return ans;
    }

    // 动态规划
    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    // 单调栈
    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Stack<Integer> stack = new Stack<>();
        for (int i : a) {
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(trap(a));
    }
}
