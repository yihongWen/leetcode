package zyj.yihong.leetcode.simple.arr;

import java.util.Random;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 */
public class RepeatedNTimes961 {
    public int repeatedNTimes(int[] nums) {
        Random random = new Random();
        while (true){
            int index1 = random.nextInt(nums.length);
            int index2 = random.nextInt(nums.length);
            if (index1!=index2&&nums[index1]==nums[index2]){
                return nums[index1];
            }
        }
    }
}
