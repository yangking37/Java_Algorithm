package com.sky;

public class L33 {

    int ans = -1;
    public int search(int[] nums, int target) {
        BinaryFind(target, nums, 0, nums.length - 1);
        return ans;
    }
    public void BinaryFind(int target, int[] nums, int start, int end) {
        if (start > end)
            return;
        if (nums[start] > nums[end]) {
            int mid = start + (end - start) / 2;
            BinaryFind(target, nums, start, mid);
            BinaryFind(target, nums, mid + 1, end);
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                return;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
    }



    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        L33 l33 = new L33();
        System.out.println(l33.search(a, target));
    }
}
