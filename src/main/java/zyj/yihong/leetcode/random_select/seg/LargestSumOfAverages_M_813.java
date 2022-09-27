package zyj.yihong.leetcode.random_select.seg;


// 813. 最大平均值和的分组
public class LargestSumOfAverages_M_813 {

    double[][] dp;
    int[] preSum;

    public double largestSumOfAverages(int[] nums, int k) {
        preSum = new int[nums.length];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            preSum[i] = curSum;
        }

        // 定义dp
        dp = new double[k+1][nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j == 1) {
                    dp[j][i] = (double) preSum[i] / (i + 1);
                    continue;
                }
                if (j > i + 1) {
                    continue;
                }
                f(i,j);
            }
        }

        return dp[k][nums.length-1];
    }

    private void f(int i,int j){
        double ans = 0;
        for (int curIndex = 0; curIndex < i; curIndex++) {
            if (curIndex+1<j-1){
                continue;
            }
            ans = Math.max(dp[j-1][curIndex]+(double)(preSum[i]- preSum[curIndex])/(i-curIndex),ans);
        }
        dp[j][i] = ans;
    }

    public static void main(String[] args) {
        LargestSumOfAverages_M_813 largestSumOfAverages_m_813 = new LargestSumOfAverages_M_813();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 4;
        double v = largestSumOfAverages_m_813.largestSumOfAverages(nums, k);
        System.out.println(v);
    }
}
