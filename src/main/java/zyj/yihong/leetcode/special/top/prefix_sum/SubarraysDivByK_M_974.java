package zyj.yihong.leetcode.special.top.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
 *
 * 子数组 是数组的 连续 部分。
 */
public class SubarraysDivByK_M_974 {
    // 同余前缀
    public int subarraysDivByK(int[] nums, int k) {
        // 用map记录同余前缀的个数,
        Map<Integer,Integer> map = new HashMap<>();

        // 特殊处理
        map.put(0,1);
        int ans = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum+= num;
            // 负数特殊处理，k=3,比如-2、7（7+2）
            int remain = (preSum % k + k) % k;
            Integer count = map.getOrDefault(remain, 0);
            ans+=count;
            map.put(remain,count+1);
        }
        return ans;
    }
}
