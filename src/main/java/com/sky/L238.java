package com.sky;

import java.util.*;

public class L238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] LeftProduct = new int[nums.length];
        int[] RightProduct = new int[nums.length];
        LeftProduct[0] = 1;
        RightProduct[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            LeftProduct[i] = LeftProduct[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            RightProduct[i] = RightProduct[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = LeftProduct[i] * RightProduct[i];
        }
        return res;
    }

    // 将答案直接存储在答案数组中的一种方法
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length; // 获取数组长度
        int[] result = new int[n]; // 结果数组，存储每个位置的乘积
        // 第一次遍历：计算每个位置左边所有数的乘积
        int leftProduct = 1; // 左边乘积初始化为1
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct; // 当前位置先存左边乘积
            leftProduct *= nums[i]; // 更新左边乘积，包含当前元素
        }
        // 第二次遍历：计算每个位置右边所有数的乘积并合并
        int rightProduct = 1; // 右边乘积初始化为1
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct; // 左边乘积 × 右边乘积
            rightProduct *= nums[i]; // 更新右边乘积，包含当前元素
        }
        return result; // 返回结果数组
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }
}
