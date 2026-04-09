package com.sky;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        L253 l253 = new L253();
        System.out.println(l253.minMeetingRooms(new int[][]{{0, 30}, {7, 10}, {9, 20}}));
    }
}
