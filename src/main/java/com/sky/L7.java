package com.sky;

public class L7 {
    public int reverse(int x) {
        boolean negative = x < 0;
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(negative ? str.substring(1) : str).reverse();
        if (sb.length() == 10 && sb.compareTo(new StringBuilder("2147483647")) >= 0) {
            return 0;
        }
        if (negative) sb.insert(0, '-');
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        L7 l7 = new L7();
        System.out.println(l7.reverse(-123));
    }
}
