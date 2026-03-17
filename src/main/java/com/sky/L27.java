package com.sky;

public class L27 {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int count = 0;
        if(nums.length == 1 && nums[0] == val) {
            return 0;
        }
        int left = 0,right = nums.length - 1;
        while(left < right){
            while(right >= left && nums[right] == val){
                count++;
                right--;
            }
            while(left < right && nums[left] != val){
                left++;
            }
            if(nums[left] == val && right >= 0){ // 注意如果全部是要移除的元素，right的索引会到-1
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }else break;
        }
        return nums.length - count;
    }
}
