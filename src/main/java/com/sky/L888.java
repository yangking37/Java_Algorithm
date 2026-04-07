package com.sky;

import java.util.HashSet;

public class L888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        HashSet<Integer> setA = new HashSet<>();
        for (int a : aliceSizes) {
            setA.add(a);
        }
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) {
            sumA += a;
        }
        for (int b : bobSizes) {
            sumB += b;
        }
        int diff = (sumA - sumB) / 2;
        for (int b : bobSizes) {
            if (setA.contains(b + diff)) {
                return new int[]{b + diff, b};
            }
        }
        return new int[]{};
    }
}
