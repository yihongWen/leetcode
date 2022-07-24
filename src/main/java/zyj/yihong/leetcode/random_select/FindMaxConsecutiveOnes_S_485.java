package zyj.yihong.leetcode.random_select;

/**
 * 485. 最大连续 1 的个数
 */
public class FindMaxConsecutiveOnes_S_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                ans = Math.max(count,ans);
                count = 0;
                continue;
            }
            count++;
        }
        ans = Math.max(count, ans);
        return ans;
    }
}
