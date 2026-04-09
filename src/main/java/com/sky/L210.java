package com.sky;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                stack.offer(i);
                list.add(i);
            }
        }
        while (!stack.isEmpty()) {
            int course = stack.poll();
            for (int nextCourse : edges.get(course)) {
                --indegree[nextCourse];
                if (indegree[nextCourse] == 0) {
                    stack.offer(nextCourse);
                    list.add(nextCourse);
                }
            }
        }
        if (list.size() != numCourses) {
            return new int[0];
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
