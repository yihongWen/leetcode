package zyj.yihong.leetcode.mid.dp;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class FindLength718 {
    public int findLength(int[] nums1, int[] nums2) {
        int num1Size = nums1.length;
        int num2Size = nums2.length;
        // 预留多一个处理
        int[][] dp = new int[num1Size+1][num2Size+1];
        int maxLength = 0;

        for (int i = num1Size-1; i >= 0; i--) {
            for (int j = num2Size - 1; j >= 0; j--) {
                dp[i][j] = nums1[i]==nums2[j]?dp[i+1][j+1]+1:0;
                maxLength = Math.max(maxLength,dp[i][j]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int ax = 1;
        while (true){
            ax = ax+ax;
        }
    }

}
