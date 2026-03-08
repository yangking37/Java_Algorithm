package com.sky;

import java.util.*;

public class L207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indegree;
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        indegree = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indegree[info[0]];
        }
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int cur = queue.poll();
            List<Integer> integers = edges.get(cur);
            for (Integer integer : integers) {
                --indegree[integer];
                if (indegree[integer] == 0) {
                    queue.offer(integer);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        L207 l207 = new L207();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(l207.canFinish(numCourses, prerequisites));
    }
}
