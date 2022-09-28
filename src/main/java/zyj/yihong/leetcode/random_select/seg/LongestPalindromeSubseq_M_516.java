package zyj.yihong.leetcode.random_select.seg;

// 516. 最长回文子序列
public class LongestPalindromeSubseq_M_516 {
    public int longestPalindromeSubseq(String s) {

        // 初始化dp数据
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        // 区间dp
        for (int i = s.length()-2; i >=0 ; i--) {
            char c1 = s.charAt(i);
            for (int j = i+1; j < s.length() ; j++) {
                char c2 = s.charAt(j);
                if (c1==c2){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }

        return dp[0][s.length()-1];
    }
}
