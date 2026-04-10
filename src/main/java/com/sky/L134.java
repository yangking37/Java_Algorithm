package com.sky;

public class L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gasSum = 0, costSum = 0;
        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) return -1; // 如果消耗的大于能够加的，则怎么都不可能走完
        int maxIndex = 0;
        int costs = 0;
        int minGas = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            costs += gas[i] - cost[i];
            if (costs < minGas) maxIndex = i;// 找到耗油最多的站点
            minGas = Math.min(costs,minGas);
        }
        return (maxIndex + 1) % n;
    }
}
