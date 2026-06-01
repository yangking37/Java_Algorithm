package com.sky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class L299 {
    public String getHint(String secret, String guess) {
        HashMap<Character, List<Integer>> SMap = new HashMap<>();
        HashMap<Character, List<Integer>> GMap = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char sch = secret.charAt(i);
            char gch = guess.charAt(i);
            GMap.computeIfAbsent(gch, k -> new ArrayList<>()).add(i);
            SMap.computeIfAbsent(sch, k -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < 10; i++) {
            char ch = (char) ('0' + i);
            if (SMap.containsKey(ch) && GMap.containsKey(ch)) {
                List<Integer> SList = SMap.get(ch);
                List<Integer> GList = GMap.get(ch);
                int[] res = contrastTow(SList, GList);
                bulls += res[0];
                cows += res[1];
            }
        }
        return bulls + "A" + cows + "B";
    }

    public int[] contrastTow(List<Integer> secret, List<Integer> guess) {
        int[] res = new int[2];
        int s = 0 , g = 0;
        while (s < secret.size() && g < guess.size()){
            if (Objects.equals(secret.get(s), guess.get(g))){
                res[0]++;
                s++;
                g++;
            }else if (secret.get(s) < guess.get(g)){
                s++;
            }else {
                g++;
            }
        }
        res[1] = Math.min(secret.size(), guess.size()) - res[0];
        return res;
    }

    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }

    public static void main(String[] args) {
        L299 l299 = new L299();
        String secret = "1123";
        String guess = "0111";
        System.out.println(l299.getHint(secret, guess));
    }
}
