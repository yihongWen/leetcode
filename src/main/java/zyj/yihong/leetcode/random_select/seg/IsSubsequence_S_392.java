package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 392. 判断子序列
// 如果存在大量的s，但是重复的t可以选择dp
public class IsSubsequence_S_392 {
    private int[][] dp;
    public boolean isSubsequence(String s, String t) {
        handleDp(t);
        int curIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dp[curIndex][c-'a']==t.length()){
                return false;
            }else {
                curIndex = dp[curIndex][c-'a']+1;
            }
        }
        return true;
    }

    private void handleDp(String t){
        dp = new int[t.length()+1][26];
        Arrays.fill(dp[t.length()],t.length());
        for (int i = t.length()-1; i >=0 ; i--) {
            char c = t.charAt(i);
            for (int j = 0; j < 26; j++) {
                dp[i][j] = (c-'a'==j)?i:dp[i+1][j];
            }
        }
    }
}
