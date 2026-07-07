package com.sky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1268 {


    // 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"

    // 比较暴力的解法，还可以使用字典树
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // 先按字典序排序
        List<List<String>> ls = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); ++i) {
            String s = searchWord.substring(0, i); // 找出每个前缀
            List<String> l1 = new ArrayList<>();
            for (String str : products) {
                if (str.startsWith(s)) { // 将符合的前缀加到集合中
                    l1.add(str);
                }
                if (l1.size() == 3) { // 如果集合长度为3，就结束循环，不在继续寻找
                    break;
                }
            }
            ls.add(l1);
        }
        return ls;
    }

}
