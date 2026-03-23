package com.sky;

class L122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        int point = 0;
        while (point < prices.length) {
            int min = prices[point];
            while (point < prices.length - 1 && prices[point + 1] >= prices[point]) {
                point++;
            }
            profit += prices[point] - min;
            point++;
        }
        return profit;
    }

    public static void main(String[] args) {
        L122 l121 = new L122();
        System.out.println(l121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}