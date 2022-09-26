package zyj.yihong.leetcode.random_select.seg;

// 740. 删除并获得点数
public class DeleteAndEarn_M_740 {
    public int deleteAndEarn(int[] nums) {
        // 问题转化
        int numsMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            numsMax = Math.max(numsMax, nums[i]);
        }

//        sum的index代表nums中的值，sum中的值代表nums中相同值的总和
        int[] sum = new int[numsMax + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return dp(sum);
    }

    private int dp(int[] arr){
        // 状态转移方程 f(i) = f(i-2)+f(i-1)+arr[i]
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] =  Math.max(dp[i-1],dp[i-2]+arr[i]);
        }

        return dp[arr.length-1];
    }

    private int dp1(int[] arr){
        int preState = arr[0];
        int nextState = Math.max(arr[0],arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int curValue = Math.max(preState + arr[i], nextState);
            preState = nextState;
            nextState = curValue;
        }
        return nextState;
    }
}
