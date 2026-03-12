package com.sky;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L763 {

    public List<Integer> partitionLabels(String s) {
        int start = 0;
        List<Integer> res = new ArrayList<Integer>();
        int end = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, count[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L763 l22 = new L763();
        System.out.println(l22.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
