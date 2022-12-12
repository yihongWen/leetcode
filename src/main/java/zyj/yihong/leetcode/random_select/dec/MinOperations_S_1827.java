package zyj.yihong.leetcode.random_select.dec;

// 1827. 最少操作使数组递增
public class MinOperations_S_1827 {
    public int minOperations(int[] nums) {
        int cur = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (cur>=nums[i]){
                ans+=cur-nums[i]+1;
                cur++;
                continue;
            }
            cur = nums[i];
        }

        return ans;
    }
}
