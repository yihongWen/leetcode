package zyj.yihong.leetcode.mid.arr;

import java.util.Random;

/**
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution384 {
    private int[] nums;
    private int[] saveNums;
    private Random random = new Random();
    public Solution384(int[] nums) {
        this.nums=nums;
        saveNums = new int[nums.length];
        System.arraycopy(nums,0,saveNums,0,nums.length);
    }

    public int[] reset() {
        System.arraycopy(saveNums,0,nums,0,nums.length);
        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length - i)+i;
            int num = nums[index];
            nums[index] = nums[i];
            nums[i] = num;
        }
        return nums;
    }
}
