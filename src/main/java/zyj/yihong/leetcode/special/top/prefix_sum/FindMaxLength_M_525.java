package zyj.yihong.leetcode.special.top.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class FindMaxLength_M_525 {
    public int findMaxLength(int[] nums) {
        // 前缀和+map
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0,-1);
        int curState = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                curState--;
            }else {
                curState++;
            }

            if (map.get(curState)!=null){
                ans = Math.max(i-map.get(curState),ans);
            }else {
                map.put(curState,i);
            }
        }
        return ans;
    }
}
