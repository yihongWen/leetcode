package zyj.yihong.leetcode.simple.dp;

public class Fib509 {
    public int fib(int n) {
        if (n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public int fibDp(int n) {
        if (n==0 || n==1){
            return n;
        }
        int[] dp = new int[2];
        dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            int cur =  dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = cur;
        }

        return dp[1];
    }

    public int tribonacci(int n) {
        if (n==0 || n==1 || n == 2){
            return n/2+n%2;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            int cur = dp[0]+dp[1]+dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = cur;
        }
        return dp[2];
    }

    public int leastMinutes(int n) {
        int t = 1;
        int curMaxBandwidth = 1;
        while (curMaxBandwidth<n){
            t++;
            curMaxBandwidth = curMaxBandwidth*2;
        }
        return t;
    }
}
