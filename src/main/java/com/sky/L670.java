package com.sky;

public class L670 {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            int index = 0;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] >= temp) {
                    index = j;
                    temp = chars[index];
                }
            }
            if (temp != chars[i]) {
                chars[index] = chars[i];
                chars[i] = temp;
                return Integer.parseInt(new String(chars));
            }
        }
        return num;
    }
}
