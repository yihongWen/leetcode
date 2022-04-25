package zyj.yihong.leetcode.mid.dp;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition416 {
    public boolean canPartition(int[] nums) {
        // nums数组的个数是否大于2
        if (nums.length<2){
            return false;
        }

        // 计算总和是否为偶数、计算最大值是否大于一半总和
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum+ nums[i];
            max = Math.max(max,nums[i]);
        }

        if ((sum&1)!=0 || (max>sum>>1)){
            return false;
        }

        int target = sum>>1;

        // dp计算
        boolean[] dp = new boolean[target+1];
        dp[0]  = true;

        for (int cur : nums) {
            for (int j = target; j >= cur; j--) {
                dp[j] = dp[j] || dp[j - cur];
            }
        }



        return dp[target];
    }
}
