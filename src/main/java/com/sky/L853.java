package com.sky;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class L853 {
    public int carFleet(int target, int[] position, int[] speed) {
        Pair<Integer, Double>[] pairs = new Pair[position.length];
        for (int i = 0; i < position.length; i++)
            pairs[i] = new Pair<>(position[i], (double) (target - position[i]) / speed[i]);
        int ans = 0;
        Arrays.sort(pairs, (o1, o2) -> o1.getKey() - o2.getKey());
        for (int i = pairs.length - 1; i > 0; i--) {
            if (pairs[i].getValue() >= pairs[i - 1].getValue())
                pairs[i - 1] = pairs[i];
            else
                ans++;
        }
        return ans + 1;// +1 is for the last car,最后一个无论是否是一个车队都没有被统计上
    }

    public static void main(String[] args) {
        L853 l853 = new L853();
        System.out.println(l853.carFleet(10, new int[]{8, 3, 7, 4, 6, 5}, new int[]{4, 4, 4, 4, 4, 4}));
    }
}
