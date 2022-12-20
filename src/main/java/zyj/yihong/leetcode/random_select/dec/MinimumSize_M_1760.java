package zyj.yihong.leetcode.random_select.dec;

// 1760. 袋子里最少数目的球
public class MinimumSize_M_1760 {
    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int num : nums) {
            right = Math.max(num, right);
        }
        int ans = 0;
        while (left<=right){
            // 二分，将nums中所有大于的值变成小于等于mid的值
            int mid = left+(right-left)/2;
            int optCount = 0;
            for (int num : nums) {
                if (num > mid) {
                    optCount += (num - 1) / mid;
                }
            }
            if (optCount>maxOperations){
                left = mid+1;
            }else {
                ans = mid;
                right = mid-1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        int max = 2;
        int ans = minimumSize(arr, max);
        System.out.println(ans);
    }
}
