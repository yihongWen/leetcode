package zyj.yihong.leetcode.mid.dp;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS300 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;

        // 状态转移方程：
        // f(x) = 1 or f(x) = f(0->x-1)_check_j+1
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr ={0,1,0,3,2,3};
        int i = lengthOfLIS(arr);
        System.out.println(i);
    }
}
