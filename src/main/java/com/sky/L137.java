package com.sky;

public class L137 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int bNext = ~a & (b ^ num);
            a = (~a & b & num) | (a & ~b & ~num);
            b = bNext;
        }
        return b;
    }


    public int singleNumber3(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

}
