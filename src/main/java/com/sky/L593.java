package com.sky;

import java.util.Arrays;

public class L593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dis = new int[6];
        dis[0] = distance(p1, p2);
        dis[1] = distance(p1, p3);
        dis[2] = distance(p1, p4);
        dis[3] = distance(p2, p3);
        dis[4] = distance(p2, p4);
        dis[5] = distance(p3, p4);
        Arrays.sort(dis);
        return dis[0] > 0 && dis[0] == dis[3] && dis[4] == dis[5];
    }
    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        L593 l593 = new L593();
        int[] p1 = {0,0};
        int[] p2 = {1,1};
        int[] p3 = {1,0};
        int[] p4 = {0,12};
        System.out.println(l593.validSquare(p1, p2, p3, p4));
    }
}
