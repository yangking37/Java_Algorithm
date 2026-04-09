package com.common;

import java.util.Arrays;

//线段树-->见L53题解
//public class SegmentTree {
//    public class Status {
//        public int lSum, rSum, mSum, iSum;
//
//        public Status(int lSum, int rSum, int mSum, int iSum) {
//            this.lSum = lSum;
//            this.rSum = rSum;
//            this.mSum = mSum;
//            this.iSum = iSum;
//        }
//    }
//
//    public int maxSubArray(int[] nums) {
//        return getInfo(nums, 0, nums.length - 1).mSum;
//    }
//
//    public Status getInfo(int[] a, int l, int r) { // 递归创建线段树
//        if (l == r) {
//            return new Status(a[l], a[l], a[l], a[l]);
//        }
//        int m = (l + r) >> 1;
//        Status lSub = getInfo(a, l, m);
//        Status rSub = getInfo(a, m + 1, r);
//        return pushUp(lSub, rSub);
//    }
//
//    public Status pushUp(Status l, Status r) {
//        int iSum = l.iSum + r.iSum;
//        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
//        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
//        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
//        return new Status(lSum, rSum, mSum, iSum);
//    }
//}
public class SegmentTree {
    private int[] tree;     // 线段树数组
    private int[] lazy;     // 懒惰标记数组
    private int[] data;     // 原始数据（可选，用于构建树）
    private int n;          // 数据长度

    /**
     * 构造函数
     * @param arr 原始数组
     */
    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.data = Arrays.copyOf(arr, n);

        // 线段树的大小为4n
        this.tree = new int[4 * n];
        this.lazy = new int[4 * n];

        // 构建线段树
        buildTree(0, 0, n - 1);
    }

    /**
     * 构建线段树
     * @param node 当前节点索引
     * @param l 当前节点表示的区间左边界
     * @param r 当前节点表示的区间右边界
     */
    private void buildTree(int node, int l, int r) {
        // 叶子节点
        if (l == r) {
            tree[node] = data[l];
            return;
        }

        int mid = l + (r - l) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        // 递归构建左右子树
        buildTree(leftChild, l, mid);
        buildTree(rightChild, mid + 1, r);

        // 更新当前节点的值为左右子树的最大值
        tree[node] = Math.max(tree[leftChild], tree[rightChild]);
    }

    /**
     * 查询区间最大值
     * @param queryL 查询区间左边界
     * @param queryR 查询区间右边界
     * @return 区间最大值
     */
    public int query(int queryL, int queryR) {
        if (queryL < 0 || queryR >= n || queryL > queryR) {
            throw new IllegalArgumentException("查询区间不合法");
        }
        return query(0, 0, n - 1, queryL, queryR);
    }

    /**
     * 查询区间最大值的递归实现
     * @param node 当前节点索引
     * @param l 当前节点表示的区间左边界
     * @param r 当前节点表示的区间右边界
     * @param queryL 查询区间左边界
     * @param queryR 查询区间右边界
     * @return 区间最大值
     */
    private int query(int node, int l, int r, int queryL, int queryR) {
        // 如果当前节点区间完全在查询区间内，直接返回
        if (queryL <= l && r <= queryR) {
            return tree[node];
        }

        // 否则，需要下推懒惰标记
        pushDown(node, l, r);

        int mid = l + (r - l) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        int max = Integer.MIN_VALUE; // 很重要，表示当前区间的最大值

        // 查询左子树
        if (queryL <= mid) {
            max = Math.max(max, query(leftChild, l, mid, queryL, queryR));
        }

        // 查询右子树
        if (queryR > mid) {
            max = Math.max(max, query(rightChild, mid + 1, r, queryL, queryR));
        }

        return max;
    }

    /**
     * 点更新 - 将指定位置的值更新为新值
     * @param index 要更新的位置
     * @param value 新值
     */
    public void update(int index, int value) {
        if (index < 0 || index >= n) {
            throw new IllegalArgumentException("索引越界");
        }
        update(0, 0, n - 1, index, value);
    }

    /**
     * 点更新的递归实现
     * @param node 当前节点索引
     * @param l 当前节点表示的区间左边界
     * @param r 当前节点表示的区间右边界
     * @param index 要更新的位置
     * @param value 新值
     */
    private void update(int node, int l, int r, int index, int value) {
        // 找到叶子节点
        if (l == r) {
            tree[node] = value;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        // 下推懒惰标记
        pushDown(node, l, r);

        // 根据索引位置决定更新左子树还是右子树
        if (index <= mid) {
            update(leftChild, l, mid, index, value);
        } else {
            update(rightChild, mid + 1, r, index, value);
        }

        // 更新当前节点的最大值
        tree[node] = Math.max(tree[leftChild], tree[rightChild]);
    }

    /**
     * 区间更新 - 将指定区间的所有值增加delta
     * @param updateL 更新区间左边界
     * @param updateR 更新区间右边界
     * @param delta 增加值
     */
    public void updateRange(int updateL, int updateR, int delta) {
        if (updateL < 0 || updateR >= n || updateL > updateR) {
            throw new IllegalArgumentException("更新区间不合法");
        }
        updateRange(0, 0, n - 1, updateL, updateR, delta);
    }

    /**
     * 区间更新的递归实现
     * @param node 当前节点索引
     * @param l 当前节点表示的区间左边界
     * @param r 当前节点表示的区间右边界
     * @param updateL 更新区间左边界
     * @param updateR 更新区间右边界
     * @param delta 增加值
     */
    private void updateRange(int node, int l, int r, int updateL, int updateR, int delta) {
        // 如果当前节点区间完全在更新区间内
        if (updateL <= l && r <= updateR) {
            // 更新当前节点的值
            tree[node] += delta;
            // 如果不是叶子节点，设置懒惰标记
            if (l != r) {
                lazy[node] += delta;
            }
            return;
        }

        // 下推已有的懒惰标记
        pushDown(node, l, r);

        int mid = l + (r - l) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        // 更新左子树
        if (updateL <= mid) {
            updateRange(leftChild, l, mid, updateL, updateR, delta);
        }

        // 更新右子树
        if (updateR > mid) {
            updateRange(rightChild, mid + 1, r, updateL, updateR, delta);
        }

        // 更新当前节点的最大值
        tree[node] = Math.max(tree[leftChild], tree[rightChild]);
    }

    /**
     * 下推懒惰标记
     * @param node 当前节点索引
     * @param l 当前节点表示的区间左边界
     * @param r 当前节点表示的区间右边界
     */
    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            // 更新子节点的值
            tree[leftChild] += lazy[node];
            tree[rightChild] += lazy[node];

            // 如果子节点不是叶子节点，设置懒惰标记
            if (l != r) {
                lazy[leftChild] += lazy[node];
                lazy[rightChild] += lazy[node];
            }

            // 清除当前节点的懒惰标记
            lazy[node] = 0;
        }
    }

    /**
     * 打印线段树结构（用于调试）
     */
    public void printTree() {
        System.out.println("线段树结构:");
        printTree(0, 0, n - 1, 0);
    }

    private void printTree(int node, int l, int r, int level) {
        if (l > r) return;

        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }

        if (l == r) {
            System.out.println(indent.toString() + "节点[" + l + "," + r + "] = " + tree[node] + " (叶子)");
        } else {
            System.out.println(indent.toString() + "节点[" + l + "," + r + "] = " + tree[node]);
            int mid = l + (r - l) / 2;
            printTree(2 * node + 1, l, mid, level + 1);
            printTree(2 * node + 2, mid + 1, r, level + 1);
        }
    }

    /**
     * 获取原始数组的副本
     */
    public int[] getData() {
        return Arrays.copyOf(data, n);
    }

    /**
     * 测试示例
     */
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println("原始数组: " + Arrays.toString(arr));

        // 创建线段树
        SegmentTree segTree = new SegmentTree(arr);
        System.out.println("线段树创建完成");
        segTree.printTree();

        // 查询示例
        System.out.println("\n查询区间[1, 3]的最大值: " + segTree.query(1, 3));
        System.out.println("查询区间[0, 5]的最大值: " + segTree.query(0, 5));
        System.out.println("查询区间[2, 4]的最大值: " + segTree.query(2, 4));

        // 点更新示例
        System.out.println("\n将索引2处的值更新为10");
        segTree.update(2, 10);
        System.out.println("查询区间[0, 5]的最大值: " + segTree.query(0, 5));

        // 区间更新示例
        System.out.println("\n将区间[1, 4]的所有值增加5");
        segTree.updateRange(1, 4, 5);
        System.out.println("查询区间[0, 5]的最大值: " + segTree.query(0, 5));
        System.out.println("查询区间[1, 3]的最大值: " + segTree.query(1, 3));
    }
}
