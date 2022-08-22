package zyj.yihong.leetcode.random_select.aug;

// 453. 最小操作次数使数组元素相等
public class MinMoves_M_453 {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            ans+= nums[i]-min;
        }

        return ans;
    }
}
