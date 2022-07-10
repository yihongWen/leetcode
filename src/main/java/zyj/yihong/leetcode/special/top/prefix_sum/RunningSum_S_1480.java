package zyj.yihong.leetcode.special.top.prefix_sum;

/**
 * 1480. 一维数组的动态和
 */
public class RunningSum_S_1480 {
    public int[] runningSum(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i-1]+nums[i];
        }
        return preSum;
    }
}
