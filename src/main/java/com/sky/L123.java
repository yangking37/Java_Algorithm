package com.sky;

import java.util.Deque;
import java.util.LinkedList;

class L123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        L123 l121 = new L123();
        System.out.println(l121.maxProfit(new int[]{3,2,6,5,0,3}));
    }
}