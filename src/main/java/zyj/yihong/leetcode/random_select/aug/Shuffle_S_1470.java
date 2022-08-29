package zyj.yihong.leetcode.random_select.aug;

// 1470. 重新排列数组
public class Shuffle_S_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[i+ n];
        }
        return ans;
    }
}
