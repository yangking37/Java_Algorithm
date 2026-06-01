package com.sky;

public class L1544 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!sb.isEmpty() && Math.abs(s.charAt(i) - sb.charAt(sb.length() - 1)) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L1544 l1544 = new L1544();
        System.out.println(l1544.makeGood("leEeetcode"));
    }
}
