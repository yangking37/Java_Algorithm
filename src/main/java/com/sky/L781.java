package com.sky;

public class L781 {
    public int numRabbits(int[] answers) {
        int[] cnt = new int[1000];
        for (int a : answers) {
            cnt[a]++;
        }
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            if (cnt[i] == 0) continue;
            ans += (cnt[i] + i) / (i + 1) * (i + 1); //加i是为了保证向上取整
        }
        return ans;
    }
}
