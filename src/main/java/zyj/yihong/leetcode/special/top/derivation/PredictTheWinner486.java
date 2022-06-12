package zyj.yihong.leetcode.special.top.derivation;

import org.apache.commons.math3.analysis.function.Max;
import zyj.yihong.lang.demo.MainThread;

/**
 * 486. 预测赢家
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 *
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 *
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 *
 */
public class PredictTheWinner486 {

    public boolean predictTheWinner(int[] nums) {
        int max = dfs(nums, 0, nums.length - 1, 1);
        return max>=0;
    }

    private int dfs(int[] nums,int start,int end,int sign){
        // 使用递归的方式:结构为一颗二叉树，树的高度为为num.length

        // 结束条件：如果数组中只剩下一个数时
        if (start==end){
            return nums[start]*sign;
        }

        // dfs
        int selectStart = nums[start]*sign+dfs(nums,start+1,end,-sign);
        int selectEnd = nums[end]*sign+dfs(nums,start,end-1,-sign);

        // 选择最优的结果：先手取正，后手取负
        int max = Math.max(selectStart*sign, selectEnd*sign)*sign;
        return max;
    }

    private static boolean dp0(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length-2; i >=0; i--) {
            for (int j = i+1; j < nums.length ; j++) {
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }

    private static boolean dp1(int[] nums){
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int i = nums.length-2; i >=0; i--) {
            for (int j = i+1; j < nums.length ; j++) {
                dp[j] = Math.max(nums[i]-dp[j],nums[j]-dp[j-1]);
            }
        }
        return dp[nums.length-1]>=0;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2};
        boolean b = dp0(arr);
        System.out.println(b);
    }


}
