package zyj.yihong.leetcode.mid.dp;

/**
 * 343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 */
public class IntegerBreak343 {
    public int integerBreak(int n) {
        //使用最简单的dp,dp[0、1] = 0
        int[] dp = new int[n+1];
        for (int i = 2; i <=n ; i++) {
            int iMax = 0;
            for (int j = 1; j <i ; j++) {
                // 化分不可拆割
                int ans1 = (i - j) * j;
                int ans2 = (i - j) * dp[j];
                iMax = Math.max(iMax,Math.max(ans1,ans2));
            }
            dp[i] = iMax;
        }
        return dp[n];
    }
}
