package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L71 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (String s : paths) {
            if (!s.isEmpty()) {
                if (s.equals("..")){
                    if (!stack.isEmpty())
                        stack.pollLast();
                    continue;
                }
                if (s.equals("."))
                    continue;
                stack.offerLast(s);
            }
        }
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollFirst());
        }
        if (sb.isEmpty())
            return "/";
        return sb.toString();
    }

    public static void main(String[] args) {
        L71 l = new L71();
        System.out.println(l.simplifyPath("/../..ga/b/.f..d/..../e.baaeeh./.a"));
    }
}
