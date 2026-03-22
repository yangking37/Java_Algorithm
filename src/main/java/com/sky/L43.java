package com.sky;

import java.util.Objects;

class L43 {
    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) return "0";
        // 保存计算结果的每一位
        int[] arr = new int[num1.length() + num2.length()];
        // 遍历
        for (int i = num1.length() - 1; i >= 0; i--) {
            int ch1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int ch2 = num2.charAt(j) - '0';
                int sum = ch1 * ch2 + arr[i + j + 1];
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = arr[0] == 0 ? 1 : 0;
        for (int i = start; i < arr.length; i++)
            sb.append(arr[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        L43 l9 = new L43();
        System.out.println(l9.multiply("123", "456"));
    }
}