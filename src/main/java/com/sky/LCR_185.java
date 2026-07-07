package com.sky;

import java.util.Arrays;

public class LCR_185 {
    public double[] statisticsProbability(int num) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= num; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        LCR_185 lcr = new LCR_185();
        double[] res = lcr.statisticsProbability(2);
        for (double re : res) {
            System.out.println(re);
        }
    }
}
