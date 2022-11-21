package zyj.yihong.leetcode.random_select.nov;

// 1014. 最佳观光组合
public class MaxScoreSightseeingPair_M_1014 {
    public static int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int curMax = values[0];

        for (int i = 1; i < values.length; i++) {
            ans = Math.max(values[i]-i+curMax,ans);
            curMax = Math.max(curMax,values[i]+i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {8,1,5,2,6};
        int i = maxScoreSightseeingPair(arr);
        System.out.println(i);
    }
}
