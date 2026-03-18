package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        List<String> list1 = removeZero(v1);
        List<String> list2 = removeZero(v2);
        int point = 0;
        while (point < Math.min(list1.size(), list2.size())) {
            String str1 = list1.get(point);
            String str2 = list2.get(point);
            if (str1.length() > str2.length()) {
                return 1;
            } else if (str1.length() < str2.length()) {
                return -1;
            }
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) > str2.charAt(i)) {
                    return 1;
                } else if (str1.charAt(i) < str2.charAt(i)) {
                    return -1;
                }
            }
            point++;
        }
        List<String> left = list1.size() > list2.size() ? list1 : list2;
        for (int i = point; i < left.size(); i++) {
            if (left.get(i).charAt(0) - '0' > 0) {
                return list1.size() > list2.size() ? 1 : -1;
            }
        }
        return 0;
    }

    private List<String> removeZero(String[] v2) {
        List<String> v = new ArrayList<>();
        for (String s : v2) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) != '0') {
                    break;
                }
                i++;
            }
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
            }
            if (!sb.toString().isEmpty())
                v.add(sb.toString());
            else
                v.add("0");
        }
        return v;
    }

    // 方法二，在遍历的同时进行比较，主要是将其转化为数值
    public int compareVersion2(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0'; // 将遍历到的字符转为数字，并且将上一个从乘10进行保存
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) { // 如果相等，那么保存的值也是相等的，否则就可以得出答案
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        L165 l165 = new L165();
        System.out.println(l165.compareVersion("1.0.0.100", "1.0"));
    }
}
