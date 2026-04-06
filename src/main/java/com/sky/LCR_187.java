package com.sky;

public class LCR_187 { // 约瑟夫环问题
    public int iceBreakingGame(int num, int target) {
        int f = 0;
        for (int i = 2; i != num + 1; ++i) {
            f = (target + f) % i;
        }
        return f;
    }



    //递归解法 公式f(n) = (f(n - 1) + target) % n
    public int iceBreakingGame2(int num, int target) {
        return f(num, target);
    }

    public int f(int num, int target) {
        if (num == 1) {
            return 0;
        }
        int x = f(num - 1, target);
        return (target + x) % num;
    }

}
