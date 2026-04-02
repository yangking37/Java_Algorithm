package com.sky;

import java.util.Arrays;

public class LCR_170 {
    // 归并排序求解
    public int reversePairs(int[] record) {
        int n = record.length;
        if (n < 2) return 0;
        int[] temp = new int[n];
        return mergeSort(record, temp, 0, n - 1);
    }

    private int mergeSort(int[] record, int[] temp, int left, int right) {
        if (left >= right) return 0;
        int mid = (right - left) / 2 + left;
        int count = mergeSort(record, temp, left, mid) + mergeSort(record, temp, mid + 1, right);
        int l = left;
        int r = mid + 1;
        int pos = left;
        while (l <= mid && r <= right) {
            if (record[l] > record[r]) {
                temp[pos++] = record[r++];
                count += mid - l + 1;
            } else {
                temp[pos++] = record[l++];
            }
        }
        while (l <= mid) temp[pos++] = record[l++];
        while (r <= right) temp[pos++] = record[r++];
        System.arraycopy(temp, left, record, left, right - left + 1);
        return count;
    }

    //     树状数组求解
    public int reversePairs2(int[] record) {
        int n = record.length;
        int[] tmp = new int[n];
        System.arraycopy(record, 0, tmp, 0, n);
        // 离散化
        Arrays.sort(tmp);
        for (int i = 0; i < n; ++i) {
            record[i] = Arrays.binarySearch(tmp, record[i]) + 1;
        }
        // 树状数组统计逆序对
        BIT bit = new BIT(n);
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            ans += bit.query(record[i] - 1);
            bit.update(record[i]);
        }
        return ans;
    }
    class BIT {
        private int[] tree;
        private int n;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public int query(int x) {
            int ret = 0;
            while (x != 0) {
                ret += tree[x];
                x -= lowbit(x);
            }
            return ret;
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }
    }

    public static void main(String[] args) {
        LCR_170 lcr = new LCR_170();
        int[] record = {9, 7, 5, 4, 6};
        int result = lcr.reversePairs2(record);
        System.out.println(result);
    }
}
