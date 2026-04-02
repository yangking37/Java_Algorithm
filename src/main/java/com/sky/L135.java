package com.sky;

import java.util.Arrays;

public class L135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = Math.max(candies[i], candies[i - 1] + 1);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        return Arrays.stream(candies).sum();
    }

    // 解法2，使用常数空间的解法，主要是通过观察发现，每次递增或递减的序列，最小的糖果数是1，
    // 所以可以使用常数空间来记录递增或递减的序列长度，并计算糖果数
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;// pre记录前一个孩子的糖果数，inc记录递增序列长度，dec记录递减序列长度
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) { // 递减序列长度等于递增序列长度时，需要将递减序列长度加1
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        L135 l135 = new L135();
        int[] ratings = { 2, 3, 4, 3,2,1};
        int result = l135.candy(ratings);
        System.out.println(result);
    }
}
