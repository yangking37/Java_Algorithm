package com.sky;

public class L912 {
    public int[] sortArray(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeapify(nums, 0, i);
        }
        return nums;
    }

    public void buildHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }

    private void maxHeapify(int[] nums, int i, int length) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < length && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < length && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            maxHeapify(nums, largest, length);
        }
    }
}
