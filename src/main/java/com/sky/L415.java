package com.sky;

class L415 {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        while (m >= 0 && n >= 0) {
            int sum = 0;
            int ch1 = num1.charAt(m) - '0';
            int ch2 = num2.charAt(n) - '0';
            sum = ch1 + ch2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            m--;
            n--;
        }
//        if (num1.length() == num2.length()) {
//            if (carry > 0)
//                sb.append(carry);
//            return sb.reverse().toString();
//        } else {
//            String left = num1.length() > num2.length() ? num1 : num2;
//            for (int i = Math.abs(num1.length() - num2.length()) - 1; i >= 0; i--) {
//                if (carry > 0) {
//                    int num = carry + (left.charAt(i) - '0');
//                    carry = num / 10;
//                    sb.append(num % 10);
//                } else
//                    sb.append(left.charAt(i));
//            }
//        }
        carry = getCarry(num2, carry, sb, n);
        carry = getCarry(num1, carry, sb, m);
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    private int getCarry(String num2, int carry, StringBuilder sb, int n) {
        while (n >=0){
            int sum = 0;
            int ch1 = num2.charAt(n) - '0';
            sum = ch1 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            n--;
        }
        return carry;
    }

    public static void main(String[] args) {
        L415 l125 = new L415();
        System.out.println(l125.addStrings("9", "99"));
    }
}