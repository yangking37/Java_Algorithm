package com.sky;

import java.util.*;

public class L49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 第一种方法(对原字母进行排序)，第二种，对每个String的单个字符进行减‘a’操作，所得和是一样的
            char[] ch = str.toCharArray();
            Arrays.sort(ch); // 对原始字母进行排序
            String key = new String(ch);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";

    }
}
