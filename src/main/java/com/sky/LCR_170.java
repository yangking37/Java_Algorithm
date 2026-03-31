package com.sky;

public class LCR_170 {
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

    public static void main(String[] args) {
        LCR_170 lcr = new LCR_170();
        int[] record = {9, 7, 5, 4, 6};
        int result = lcr.reversePairs(record);
        System.out.println(result);
    }
}
