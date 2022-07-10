package zyj.yihong.leetcode.special.top.prefix_sum;

import java.util.Map;

/**
 * 1413. 逐步求和得到正数的最小值
 */
public class MinStartValue_S_1413 {
    public int minStartValue(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        int min = preSum[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i-1]+ nums[i];
            min = Math.min(preSum[i], min);
        }

        return min>=1?1:(-min+1);
    }
}
