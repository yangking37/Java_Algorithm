package com.sky;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L150 {
    public int evalRPN(String[] tokens) {
        Stack<String> queue = new Stack<>();
        for (String token : tokens) {
            if (queue.size() >= 2 && token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = Integer.parseInt(queue.pop());
                int num1 = Integer.parseInt(queue.pop());
                long res = switch (token) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> (long) num1 * num2;
                    case "/" -> num1 / num2;
                    default -> 0;
                };
                queue.push(String.valueOf(res));
            } else
                queue.push(token);
        }
        return Integer.parseInt(queue.pop());
    }

    public static void main(String[] args) {
        String[] a = {"4","13","5","/","+"};
        L150 l = new L150();
        System.out.println(l.evalRPN(a));
    }
}
