package com.sky;

import java.util.*;

public class L78 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    // 这道题两种思路，
    // 第一种思路，求某个集合的子集，首先我们知道子集的数量为2的n次方，n为集合的长度
    // 那么将其换算成二进制就是从0到n-1，每一位二进制数代表着是否取这个数，
    public List<List<Integer>> subsets(int[] nums) {
//        int n = nums.length;
//        for (int mask = 0; mask < (1 << n); ++mask) {
//            t.clear();
//            for (int i = 0; i < n; ++i) {
//                if ((mask & (1 << i)) != 0) {
//                    t.add(nums[i]);
//                }
//            }
//            ans.add(new ArrayList<>(t));
//        }
        dfs(0, nums);
        return ans;
    }

    // 第二种思路，递归，每次递归选或者递归不选，可以将这个递归看成一个满二叉数，叶子节点的数量为2的n次方
    // 每一次到达叶子节点，也就表明了选择
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums); // 选
        t.remove(t.size() - 1);
        dfs(cur + 1, nums); // 不选
    }

    public static void main(String[] args) {
        L78 l78 = new L78();
        System.out.println(l78.subsets(new int[]{1, 2, 3,4,5}));
    }
}
