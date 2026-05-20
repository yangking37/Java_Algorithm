package com.sky;

import java.util.Arrays;

public class L902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String N = String.valueOf(n);
        int m = digits.length;
        int ans = 0;
        for (int i = 1; i < N.length(); i++) { // 枚举长度
            ans += (int) Math.pow(m, i);
        }// 将长度小于n的数字的个数累加起来
        int nlen = N.length();
        for (int i = 0; i < nlen; i++) { // 长度等于n的数字的个数
            boolean hasEqual = false;
            for (String digit : digits)
                if (digit.charAt(0) < N.charAt(i))
                    ans += (int) Math.pow(m, nlen - i - 1);
                else if (digit.charAt(0) == N.charAt(i)) {
                        hasEqual = true;
                }else
                    break;
            if (!hasEqual) return ans; // 达到这里就表示digits中都小于N.charAt(i), 提前返回结果
            if (i == nlen - 1) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] a = {"1"};
        L902 l = new L902();
        System.out.println(l.atMostNGivenDigitSet(a, 188));
    }

}
