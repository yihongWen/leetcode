package zyj.yihong.leetcode.mid.dp;

/**
 * 375. 猜数字大小 II
 */
public class GetMoneyAmount375 {
    public int getMoneyAmount(int n) {
        // 区间dp
        int[][] dp = new int[n+1][n+1];
        for (int len = 2; len <= n ; len++) {
            for (int left = 1; left <= n-len+1; left++) {
                int right = left+len-1;
                dp[left][right] = Integer.MAX_VALUE;
                for (int select = left; select <= right; select++) {
                    int value = Math.max(dp[left][select - 1], dp[select + 1][right]) + select;
                    dp[left][right] = Math.min(value,dp[left][right]);
                }
            }
        }

        return dp[1][n];
    }
}
