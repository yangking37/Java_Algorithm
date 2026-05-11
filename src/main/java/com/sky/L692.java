package com.sky;

import javafx.util.Pair;

import java.util.*;

public class L692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Pair<String, Integer>> list = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        list.sort((o1, o2) -> {
            if (!Objects.equals(o1.getValue(), o2.getValue())) {
                return o2.getValue() - o1.getValue(); // 按照频率降序排序
            }else  {
                return o1.getKey().compareTo(o2.getKey()); // 按照字典序排序
            }
        });
        List<String> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        L692 l692 = new L692();
        System.out.println(l692.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
