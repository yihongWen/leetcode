package zyj.yihong.leetcode.mid.dp;

import java.util.Arrays;

/**
 * 313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 *
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 *
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthSuperUglyNumber313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        // 定义dp需要的数据结构
        int[] dp = new int[n+1];
        int[] p = new int[primes.length];
        int[] curNum = new int[primes.length];

        // 初始值
        dp[1] = 1;
        Arrays.fill(p,1);
        System.arraycopy(primes,0,curNum,0,primes.length);

        for (int i = 2; i <= n; i++) {
            // 计算当前dp
            int min = Arrays.stream(curNum).min().getAsInt();
            dp[i] = min;

            // 判断当前质数与当前的个数乘积与min相等
            for (int i1 = 0; i1 < primes.length; i1++) {
                if (curNum[i1]==min){
                    // 计算下次的数
                    p[i1]++;
                    curNum[i1] = dp[p[i1]]*primes[i1];
                }
            }
        }

        return dp[n];
    }
}
