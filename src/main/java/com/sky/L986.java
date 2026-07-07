package com.sky;

import java.util.Arrays;

public class L986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int[][] res = new int[firstList.length + secondList.length][2];
        int index = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                res[index][0] = left;
                res[index][1] = right;
                index++;
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return index == 0 ? new int[0][0] : Arrays.copyOfRange(res, 0, index);
    }
}
