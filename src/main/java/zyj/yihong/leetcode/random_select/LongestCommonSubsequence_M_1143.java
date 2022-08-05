package zyj.yihong.leetcode.random_select;

// 1143. 最长公共子序列
public class LongestCommonSubsequence_M_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i < text1.length(); i++) {
            char c = text1.charAt(i);
            for (int j = 0; j < text2.length(); j++) {
                if (c==text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
