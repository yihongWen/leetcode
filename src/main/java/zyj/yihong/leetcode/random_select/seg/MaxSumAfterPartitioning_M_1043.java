package zyj.yihong.leetcode.random_select.seg;

// 1043. 分隔数组以得到最大和
public class MaxSumAfterPartitioning_M_1043 {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        // dp
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length ; i++) {
            int curMax = -1;
            // 分割
            int edge = Math.max(i - k+1, 0);
            for (int j = i; j >= edge  ; j--) {
                curMax = Math.max(curMax, arr[j]);
                dp[i] = Math.max(dp[i],(j-1<0?0:dp[j-1])+curMax*(i-j+1));
            }
        }

        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        int i = maxSumAfterPartitioning(arr, k);
        System.out.println(i);
    }

//    arr = [1,15,7,9,2,5,10], k = 3
//输出：84
//解释：
//因为 k=3 可以分隔成 [1,15,7] [9] [2,5,10]，结果为 [15,15,15,9,10,10,10]，和为 84，是该数组所有分隔变换后元素总和最大的。
//若是分隔成 [1] [15,7,9] [2,5,10]，结果就是 [1, 15, 15, 15, 10, 10, 10] 但这种分隔方式的元素总和（76）小于上一种。

}
