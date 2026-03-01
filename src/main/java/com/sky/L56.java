package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56 {

    public int[][] merge(int[][] intervals) {
        // 对原数组进行排序，按照左端数字大小进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);
        for (int[] interval : intervals) {
            if (interval[0] <= list.get(list.size() - 1)[1])
                list.get(list.size() - 1)[1] = Math.max(interval[1], list.get(list.size() - 1)[1]);
            else
                list.add(interval);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        L56 l53 = new L56();
//        int[][] a = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] a = new int[][]{{2, 3}, {1, 4}};

        System.out.println(Arrays.deepToString(l53.merge(a)));
    }
}
