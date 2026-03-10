package com.sky;

import java.util.Arrays;

public class L287 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);  // 结束循环时相遇，

        slow = 0; // 将慢指针设置在入口
        while(fast != slow){ // 在走A步即可在入环点相遇
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // 方法二，使用二分(因为数组中的值范围为[1,n-1],n为数组的长度)
    // 那么便有比重复数小的数：num[i-1]<=i-1,比其大的数有，num[i+1] > i
    // 例如[1,2,3,4,4,5],num[1]<=1(比一小的数量)，num[2]<=2,num[3]<=3,num[4]>4,num[5]>5
    // 即在[1,n]区间内，该数组是有序递增的，所以可以使用二分查找
    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) { // 比mid小的数量小于等于mid,说明不可能重复
                l = mid + 1;
            } else { //比mid大的数量大于mid，可能是重复值，记录下来
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2,5,9,6,9,3,8,9,7,1};
        L287 l287 = new L287();
        System.out.println(l287.findDuplicate(a));
    }
}
