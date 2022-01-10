package zyj.yihong.leetcode;

import java.util.Arrays;

/**
 * 数组拆分
 * @author yihong
 */
public class ArrayPairSum561 {
    /**
     * 给定长2n的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
     * 返回该 最大总和
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int retValue = 0;

        for (int i = 0; i < nums.length; i = i+2) {
            retValue+=nums[i];
        }
        return retValue;

    }
}
