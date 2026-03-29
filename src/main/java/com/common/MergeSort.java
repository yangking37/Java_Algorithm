package com.common;

public class MergeSort {
    int[] temp;

    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right)
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= right)
            temp[k++] = nums[j++];
        // 将 temp 中已排序的部分复制回 nums
        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        MergeSort mergeSort = new MergeSort();
        int[] sortedNums = mergeSort.sortArray(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}
