package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L273 {
    private static final String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            Integer a = num % 1000;
            list.add(a);
            num /= 1000;
        }
        List<String> res = helper(list);
        List<String> ans = new ArrayList<>();
        if (res.size() == 1)
            return res.get(0);
        System.out.println(res);
        int i = res.size() - 2;
        if (i == 2) {
            ans.add(res.get(3) + " Billion");
            if (!res.get(2).equals("Zero")) {
                ans.add(res.get(2) + " Million");
            }
            if (!res.get(1).equals("Zero")) {
                ans.add(res.get(1) + " Thousand");
            }
        } else if (i == 1) {
            ans.add(res.get(2) + " " + "Million");
            if (!res.get(1).equals("Zero")) {
                ans.add(res.get(1) + " Thousand");
            }
        } else if (i == 0) {
            ans.add(res.get(1) + " " + "Thousand");
        }
        if (!res.get(0).equals("Zero")) {
            ans.add(res.get(0));
        }
        return String.join(" ", ans);
    }

    private List<String> helper(List<Integer> list) {
        List<String> res = new ArrayList<>();
        for (Integer num : list) {
            if (num <= 99) {
                res.add(numberToWords2(num));
            } else {
                int a = num / 100;
                int b = num % 100;
                if (b == 0)
                    res.add(ones[a] + " Hundred");
                else
                    res.add(ones[a] + " Hundred " + numberToWords2(b));
            }
        }
        return res;
    }

    public String numberToWords2(int num) {
        if (num <= 19) {
            return ones[num];
        } else {
            int a = num / 10;
            int b = num % 10;
            if (b == 0)
                return tens[a];
            else
                return tens[a] + " " + ones[b];
        }
    }

    public static void main(String[] args) {
        L273 l273 = new L273();
        System.out.println(l273.numberToWords(1234567));
    }
}
