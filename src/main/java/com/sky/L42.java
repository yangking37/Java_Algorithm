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
