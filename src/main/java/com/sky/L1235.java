package com.sky;

import java.util.Arrays;
import java.util.Comparator;

public class L1235 {

    static class job {
        int start, end, profit;
        job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        job[] jobs = new job[n];
        for (int i = 0; i < n; ++i)
            jobs[i] = new job(startTime[i], endTime[i], profit[i]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (jobs[mid].end <= jobs[i].start) l = mid;
                else r = mid - 1;
            }
            if (jobs[l].end <= jobs[i].start) dp[i] = Math.max(dp[i - 1], dp[l] + jobs[i].profit);
            else dp[i] = Math.max(dp[i - 1], jobs[i].profit);
        }
        return dp[n - 1];
    }
}
