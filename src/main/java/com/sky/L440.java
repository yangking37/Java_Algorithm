package com.sky;

import java.util.Arrays;
import java.util.Comparator;

public class L440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
    public static void main(String[] args) {
        String[] a = new String[5000];
        for (int i = 0; i < a.length; i++) {
            a[i] = String.valueOf(i + 1);
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
