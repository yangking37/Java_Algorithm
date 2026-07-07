package com.sky;

import java.util.Arrays;
import java.util.Comparator;

public class L435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) { // 找到的是不重叠的数量
                right = intervals[i][1];
                ++ans;
            }
        }
        return n - ans;
    }
}
