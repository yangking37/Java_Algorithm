package com.sky;

public class LCR_139 {
    public int[] trainingPlan(int[] actions) {
        int i = 0, j = actions.length - 1, tmp;
        while(i < j) {
            while(i < j && (actions[i] & 1) == 1) i++;
            while(i < j && (actions[j] & 1) == 0) j--;
            tmp = actions[i];
            actions[i] = actions[j];
            actions[j] = tmp;
        }
        return actions;
    }
}
