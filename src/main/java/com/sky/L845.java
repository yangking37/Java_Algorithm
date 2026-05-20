package com.sky;

public class L845 {
    public int longestMountain(int[] arr) {
        if (arr == null || arr.length <= 2)
            return 0;
        int n = arr.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        boolean flag = false; // 用于标记是否处于山脉的上升或下降阶段
        while (right < n - 1) {
            while (right < n - 1 && arr[right] < arr[right + 1]) {
                right++;
            }
            if (right == left){ // 处于上升阶段，但无法形成山脉
                right++;
                left++;
                continue;
            }
            while (right < n - 1 && arr[right] > arr[right + 1]) {
                flag = true; // 标记处于下降阶段
                right++;
            }
            if (right - left + 1 > 2 && flag) {  // 满足山脉条件
                ans = Math.max(ans, right - left + 1);
            }
            if (right == left)  // 处于下降阶段，但无法形成山脉
                right++;
            left = right;
            flag = false;
        }
        return ans;
    }
}
