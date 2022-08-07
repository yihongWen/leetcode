package zyj.yihong.leetcode.random_select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 */
public class MinSubsequence_S_1043 {
    public static  List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        List<Integer> ans = new ArrayList<>();
        int i = nums.length-1;
        int curSum = 0;
        int target = (sum >> 1) + 1;
        while (i>=0){
            curSum+=nums[i];
            ans.add(nums[i]);
            if (curSum>=target){
                return ans;
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,4,7,6,7};
        List<Integer> integers = minSubsequence(arr);
        System.out.println(integers);

    }
}
