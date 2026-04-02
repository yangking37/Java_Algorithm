package com.sky;

public class L260 {
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num; // 拿到两个不同数字的异或结果
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum)); // 找到最低位的1
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {// 因为其中一个与最低位的1与，结果不为0, 所以将数字分为两组
                type1 ^= num; // 拿到两个不同数字中，其中一个数字
            } else {
                type2 ^= num; // 拿到两个不同数字中，另一个数字
            }
        }
        return new int[]{type1, type2};
    }

}
