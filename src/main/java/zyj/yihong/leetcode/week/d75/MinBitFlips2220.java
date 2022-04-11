package zyj.yihong.leetcode.week.d75;

public class MinBitFlips2220 {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((start&1)!=(goal&1)){
                ans++;
            }
            start = start>>1;
            goal = goal>>1;
        }
        return ans;
    }

    public static int triangularSum(int[] nums) {
        int curSize = nums.length;
        int[] next = new int[nums.length];
        while (curSize>1) {
            for (int i = 0; i < curSize-1; i++) {
                next[i] = (nums[i]+nums[i+1])%10;
            }
            curSize--;
            int[] temp = nums;
            nums = next;
            next = temp;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int i = triangularSum(arr);
        System.out.println(i);
    }
}
