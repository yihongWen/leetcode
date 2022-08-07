package zyj.yihong.leetcode.random_select;

public class MinDistance_M_583 {
    public static int minDistance(String word1, String word2) {
        // dp
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            for (int j = 0; j < word2.length(); j++) {
                if (c == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        int maxLength = dp[word1.length()][word2.length()];
        return word1.length() + word2.length() - (maxLength << 1);
    }

    public static void main(String[] args) {

        int n = 21;
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        System.out.println(ans);
    }

}
