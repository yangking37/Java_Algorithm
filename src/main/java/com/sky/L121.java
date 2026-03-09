package com.sky;

import java.util.HashMap;
import java.util.Map;

class L121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        L121 l121 = new L121();
        System.out.println(l121.maxProfit(new int[]{7,6,4,3,1}));
    }
}