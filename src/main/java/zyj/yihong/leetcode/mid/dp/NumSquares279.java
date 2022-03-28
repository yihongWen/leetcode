package zyj.yihong.leetcode.mid.dp;

import zyj.yihong.leetcode.mid.sort.MaximumGap164;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSquares279 {
    public int numSquares(int n) {
        // 使用动态规划的方式
        int[] dp = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j*j <=i ; j++) {
                dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        return dp[n];
    }
}
