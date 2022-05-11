package zyj.yihong.leetcode.mid.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDuplicates442 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 该位置的数值曾今出现过，需要进行恢复
            if (nums[i]<0){
                int temp = nums[i] + Integer.MAX_VALUE;
                if (nums[temp-1]<0){
                    ans.add(temp);
                }else {
                    nums[temp-1]-=Integer.MAX_VALUE;
                }
            }else {
                if (nums[nums[i]-1]<0){
                    ans.add(nums[i]);
                }else {
                    nums[nums[i]-1]-=Integer.MAX_VALUE;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates);
    }
}
