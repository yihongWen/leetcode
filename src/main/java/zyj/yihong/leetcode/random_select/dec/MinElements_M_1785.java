package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;
import java.util.Map;

// 1785. 构成特定和需要添加的最少元素
public class MinElements_M_1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        long diff = Math.abs(sum-(long)goal);
        return (int)(diff/limit+(diff%limit==0?0:1));
    }
}
