package zyj.yihong.leetcode.random_select.nov;

// 673. 最长递增子序列的个数
public class FindNumberOfLIS_M_673 {
    public int findNumberOfLIS(int[] nums) {
        // 定义变量：dp（当前0-i最大长度），count(0-i中最大长度的个数)，maxLength最大长度，ans返回结果
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int maxLength = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                ans = count[i];
            } else if (maxLength == dp[i]) {
                ans += count[i];
            }
        }

        return ans;
    }
}
