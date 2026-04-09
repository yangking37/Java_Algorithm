package com.sky;

import java.util.Arrays;

public class L1884 {
    public int twoEggDrop(int n) {
//        int res = 0;
//        while (n > 0) {
//            res++;
//            n -= res;
//        }
//        return res;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                f[i] = Math.min(f[i], Math.max(k - 1, f[i - k]) + 1);
            }
        }
        return f[n];

    }
    public static void main(String[] args) {
        L1884 l1884 = new L1884();
        System.out.println(l1884.twoEggDrop(100));
    }
}
