package com.sky;

public class L984 {
    public String strWithout3a3b(int a, int b) {
        StringBuffer sb = new StringBuffer();

        while (a > 0 && b > 0) {
            if (a == b) {
                sb.append("ab".repeat(Math.max(0, a)));
                a = 0;
                b = 0;
                break;
            } else if (a > b) {
                sb.append("aab");
                a -= 2;
                b--;
            } else {
                sb.append("bba");
                b -= 2;
                a--;
            }
        }
        sb.append("a".repeat(Math.max(0, a)));
        sb.append("b".repeat(Math.max(0, b)));
        return sb.toString();
    }

    public static void main(String[] args) {
        L984 l984 = new L984();
        System.out.println(l984.strWithout3a3b(2, 3));
    }
}
