package com.common;

// 树状数组
public class BinaryIndexedTree {

    private int[] tree;
    private int[] nums;
    private int size;
    public BinaryIndexedTree(int[] nums) {
        this.size = nums.length;
        this.tree = new int[size + 1];
        this.nums = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            add(i, nums[i - 1]);
        }
    }

    int lowbit(int x) { // 获取x的二进制表示中最低位的1
        return x & (-x);
    }

    void add(int i, int val) { // 点更新，及其直接后缀更新
        while (i <= size) {
            tree[i] += val;
            i += lowbit(i);
        }
    }

    int sum(int i) { // 前缀和
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    int sum(int i,int j){ // 区间和
        return sum(j) - sum(i - 1);
    }
}
