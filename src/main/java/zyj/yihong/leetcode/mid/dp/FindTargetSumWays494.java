package zyj.yihong.leetcode.mid.dp;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTargetSumWays494 {

    // 转化成01背包问题，选和不选
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }

        if ((sum-target<0)||(sum-target)%2!=0){
            return 0;
        }
        int neg = (sum-target)/2;
        int[] dp = new int[neg+1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = neg; j >= num ; j--) {
                dp[j] += dp[j-num];
            }
        }
        return dp[neg];

    }
}
