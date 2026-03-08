package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        a1.add(1);
        a2.add(1);
        a2.add(1);
        res.add(a1);
        if (numRows == 1) {
            return res;
        }
        res.add(a2);
        for (int i = 1; i <= numRows - 2; i++) {
            List<Integer> a = res.get(res.size() - 1);
            List<Integer> b = new ArrayList<>();
            b.add(1);
            for (int i1 = 0; i1 < a.size() - 1; i1++) {
                b.add(a.get(i1) + a.get(i1 + 1));
            }
            b.add(1);
            res.add(b);
        }
        return res;
    }
}
