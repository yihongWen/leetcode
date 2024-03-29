package zyj.yihong.leetcode.random_select;

// 712. 两个字符串的最小ASCII删除和
public class MinimumDeleteSum_M_712 {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp  = new int[len1+1][len2+1];
        // 初始化dp
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = dp[i-1][0]+ s1.charAt(i-1);
        }

        for (int i = 1; i < len2+1; i++) {
            dp[0][i] = dp[0][i-1]+s2.charAt(i-1);
        }

        // 计算dp
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                dp[i][j] = Math.min(dp[i-1][j]+s1.charAt(i-1),dp[i][j-1]+s2.charAt(j-1));
            }
        }


        return dp[len1][len2];
    }
}
