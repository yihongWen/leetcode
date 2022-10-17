package zyj.yihong.leetcode.random_select.oct;

// 940. 不同的子序列 II
public class DistinctSubseqII_H_940 {
    public static int distinctSubseqII(String s) {
        int mod = (int) Math.pow(10,9)+7;
        int[] t = new int[26];
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int curEndCount = 1;
            for (int j = 0; j < 26; j++) {
                curEndCount=(curEndCount+t[j])%mod;
            }
            t[s.charAt(i)-'a'] = curEndCount;
        }

        for (int i = 0; i < t.length; i++) {
            ans+=t[i];
            ans%=mod;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
