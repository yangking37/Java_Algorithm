package com.sky;

public class L754 {
    public int reachNumber(int target) {
        if (target == 0) return 0;
        target = Math.abs(target);
        int count = 1;
        while (true) {
            target -= count;
            if (target <= 0 && target % 2 == 0) return count;
            count++;
        }
    }
}
