package com.sky;

import java.util.Arrays;
import java.util.Comparator;

public class L252 {
    public boolean canAttendMeetings(int[][] graph) {
        Arrays.sort(graph, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < graph.length - 1; i++) {
            if (graph[i][1] > graph[i + 1][0])
                return false;
        }
        return true;
    }
}
