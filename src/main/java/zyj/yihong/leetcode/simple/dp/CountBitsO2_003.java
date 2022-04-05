package zyj.yihong.leetcode.simple.dp;

/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 */
public class CountBitsO2_003 {
    public int[] countBits(int n) {
        // 动态规划
        int[] ans = new int[n+1];
        int curHigh1Num = 1;
        for (int i = 1; i <= n ; i++) {
            if ((i&i-1)==0){
                curHigh1Num = i;
            }
            ans[i] = ans[i-curHigh1Num]+1;
        }

        return ans;
    }
}
