package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> list = new ArrayList<Integer>();
        int len1 = slots1.length, len2 = slots2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (end - start >= duration) {
                list.add(start);
                list.add(start + duration);
                return list;
            }
            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list;
    }
}
