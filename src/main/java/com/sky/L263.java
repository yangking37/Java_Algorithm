package com.sky;

public class L263 {
    public boolean isUgly(int n) {
        while(n > 0 && (n % 2 == 0 || n % 3 == 0 || n % 5 == 0)){
            if(n % 2 == 0) n /= 2;
            if(n % 3 == 0) n /= 3;
            if(n % 5 == 0) n /= 5;
        }
        return n == 1;
    }
}
