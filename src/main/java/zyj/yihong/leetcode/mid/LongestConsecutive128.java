package zyj.yihong.leetcode.mid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题
 */
public class LongestConsecutive128 {

    /**
     *
     * @param nums 给定数组
     * @return 最长连续长度
     */
    public static int longestConsecutive(int[] nums) {
        // 参数校验
        if (nums==null || nums.length==0){
            return 0;
        }

        // 构造set集合
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int num : nums) {
            numSet.add(num);
        }

        int retLength = 1;
        for (int num : nums) {
            int curLength = 1;
            // 如果当前的值是最小的（间隔最小），查找当前值的连续数量
            int curNum = num;
            if (!numSet.contains(num-1)){
                while (numSet.contains(++curNum)){
                    curLength++;
                }
            }
            retLength = Math.max(retLength,curLength);
        }
        return retLength;
    }

    public static void main(String[] args) {
        int[] test1 = {0,3,7,2,5,8,4,6,0,1};
        int[] test2 = {100,4,200,1,3,2};
        int length1 = longestConsecutive(test1);
        int length2 = longestConsecutive(test2);
        System.out.println(length1);
        System.out.println(length2);
    }
}
