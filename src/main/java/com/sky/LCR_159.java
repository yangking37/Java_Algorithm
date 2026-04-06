package com.sky;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LCR_159 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int[] res = new int[cnt];
        for (int i : stock) {
            pq.offer(i);
        }

        for (int i = 0; i < cnt; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        LCR_159 lcr_159 = new LCR_159();
        int[] stock = {40, 50, 10, 20, 30};
        int cnt = 3;
        int[] res = lcr_159.inventoryManagement(stock, cnt);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
