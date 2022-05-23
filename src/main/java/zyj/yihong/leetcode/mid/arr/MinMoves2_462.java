package zyj.yihong.leetcode.mid.arr;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 *
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 */
public class MinMoves2_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[(nums.length-1)/2];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.abs(nums[i]-mid);
        }
        return ans;
    }
}
