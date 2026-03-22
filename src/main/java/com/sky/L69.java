package com.sky;

public class L69 {

    public int mySqrt(int x) {
        // 方法一 ，使用对数函数和指数函数进行转换
//        if (x == 0) {
//            return 0;
//        }
//        int ans = (int) Math.exp(0.5 * Math.log(x));
//        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
        //而指数函数和对数函数的参数和返回值均为浮点数，因此运算过程中会存在误差
        //因此在得到结果的整数部分 ans 后，我们应当找出 ans 与 ans+1 中哪一个是真正的答案

        // 方法二 二分
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
