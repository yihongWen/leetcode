package zyj.yihong.leetcode.mid.arr;

import java.util.Arrays;

/**
 * 532. 数组中的 k-diff 数对
 */
public class FindPairs532 {
    public int findPairs(int[] nums, int k) {
        // 排序+遍历
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // 防止重复，当前值不能跟上一个值相等
            if (i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            while (j<nums.length){
                if (nums[i]+k==nums[j]){
                    ans++;
                    break;
                }else {
                    j++;
                }
            }
        }

        return ans;
    }
}
