package zyj.yihong.leetcode.mid.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 */
public class SubarraySum560 {
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        // 使用前缀和+map的方式
        int curPreSum = 0;
        Map<Integer,Integer> preSumCountMap = new HashMap<>();
        preSumCountMap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            curPreSum+=nums[i];
            ans+= preSumCountMap.getOrDefault(curPreSum-k,0);
            preSumCountMap.put(curPreSum,preSumCountMap.getOrDefault(curPreSum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int i = subarraySum(arr, 2);
        System.out.println(i);
    }

}
