package zyj.yihong.leetcode.mid.dp;

/**
 * 560. 和为 K 的子数组
 */
public class SubarraySum560 {
    public static int subarraySum(int[] nums, int k) {
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int coin = nums[i];
            for (int j = coin; j <= k ; j++) {
                dp[j] += dp[j-coin];
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;
        int i = subarraySum(arr, k);
        System.out.println(i);
    }
}
