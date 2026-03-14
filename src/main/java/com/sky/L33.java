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

    // 方法二，不用递归
    public int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;
        L33 l33 = new L33();
        System.out.println(l33.search(a, target));
    }
}
