package com.sky;

import java.util.HashMap;
import java.util.Map;

class L9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int rev = 0;
        int temp = x;
        for (; temp > 0; temp /= 10) {
            int y = temp % 10;
            rev = rev * 10 + y;
        }
        return rev == x;
    }

    public static void main(String[] args) {
        L9 l9 = new L9();
        System.out.println(l9.isPalindrome(121));
    }
}