package zyj.yihong.leetcode.special.top.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 */
public class NumSubarraysWithSum_M_930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        for (int i = 0; i < preSum.length; i++) {
            if (preSum[i] < goal) {
                continue;
            }
            if (preSum[i] == goal) {
                ans++;
            }

            for (int j = 0; j < i; j++) {
                int dif = preSum[i] - preSum[j];
                if (dif < goal) {
                    break;
                } else if (dif == goal) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int numSubarraysWithSumByMap(int[] nums, int goal) {
        int ans = 0;
        Map<Integer, Integer> preSumCountMap = new HashMap<>();
        preSumCountMap.put(0, 1);
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            Integer count = preSumCountMap.getOrDefault(preSum - goal, 0);
            ans += count;
            preSumCountMap.put(preSum, preSumCountMap.getOrDefault(preSum, 0));

        }
        return ans;
    }

    public static int numSubarraysWithSumOp2(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ret = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int i = numSubarraysWithSumOp2(arr, 2);
        System.out.println(i);
    }

}
