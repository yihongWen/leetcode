package zyj.yihong.leetcode.mid.dp;

/**
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 */
public class NthUglyNumber264 {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            int num1 = dp[p1] * 2;
            int num2 = dp[p2] * 3;
            int num3 = dp[p3] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num1);
            if (num1==dp[i]){
                p1++;
            }
            if (num2==dp[i]){
                p2++;
            }
            if (num3==dp[i]){
                p3++;
            }
        }
        return dp[n];
    }

    public static int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int ans = nthUglyNumber(11);
        System.out.println(ans);
    }
}
