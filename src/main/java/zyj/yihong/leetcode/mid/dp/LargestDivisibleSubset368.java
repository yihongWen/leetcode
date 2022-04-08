package zyj.yihong.leetcode.mid.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestDivisibleSubset368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length==1){
            ans.add(nums[0]);
        }

        // 对数组从小到大排序
        Arrays.sort(nums);

        // 定义dp，初始化每一个元素，都是一个单独的子集
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxCount = 1;
        int maxCurValue = nums[0];

        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]%nums[j]==0){
                    dp[i] =  Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i]>=maxCount) {
                maxCount = dp[i];
                maxCurValue = nums[i];
            }
        }

        // 逆向找出结果集
        for (int i = nums.length - 1; i >= 0; i--) {
            if (dp[i]==maxCount && maxCurValue%nums[i]==0){
                maxCount--;
                maxCurValue = nums[i];
                ans.add(nums[i]);
            }
        }


        return ans;
    }

    public static void main(String[] args) {
         int[] arr = {3,17};
        List<Integer> integerList = largestDivisibleSubset(arr);
        System.out.println(integerList);
    }
}
