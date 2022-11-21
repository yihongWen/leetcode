package zyj.yihong.leetcode.random_select.nov;

// 808. 分汤
public class SoupServings_M_808 {
    private double[][] dp;

    public double soupServings(int n) {
        // 概率层面的计算
        if (n > 5000) {
            return 1;
        }

        // 数据简化
        int simpleSize = n / 25 + (n % 25!=0?1:0);
        dp = new double[simpleSize + 1][simpleSize + 1];

        return dfs(simpleSize, simpleSize);

    }

    private double dfs(int i, int j) {
        // 边界条件
        if (i <= 0 && j <= 0) {
            return 0.5;
        } else if (i <= 0) {
            return 1;
        } else if (j <= 0) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }


        // 转移方程
        dp[i][j] =0.25*(dfs(i - 4, j) + dfs(i - 3, j - 1) +
                dfs(i - 2, j - 2) + dfs(i - 1, j - 3));
        return dp[i][j];
    }

    public static void main(String[] args) {
        SoupServings_M_808 soup = new SoupServings_M_808();
        double v = soup.soupServings(100);
        System.out.println(v);
    }
}
