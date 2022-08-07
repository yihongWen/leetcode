package zyj.yihong.leetcode.random_select;

//646. 最长数对链
//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
//
//现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
//
//给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain_M_646 {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing(a->a[0]));
        // dp(i):当前index结尾的pair,最长的个数
        int[] dp = new int[pairs.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < pairs.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0]>pairs[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing(a->a[1]));
        int ans = 1;
        int maxRight = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0]>maxRight){
                maxRight = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        [[1,2],[7,8],[4,5]]

        int[][] arr = {{1,2},{7,8},{4,5}};
        int longestChain = findLongestChain(arr);
        System.out.println(longestChain);
    }
}
