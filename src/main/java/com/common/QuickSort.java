package com.common;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left];
            int i = left, j = right;
            while (i < j) {
                while (i < j && arr[j] >= pivot) {
                    j--;
                }
                while (i < j && arr[i] <= pivot) {
                    i++;
                }
                if (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // 将基准值放到最终位置（此时i==j）
            arr[left] = arr[i];
            arr[i] = pivot;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
