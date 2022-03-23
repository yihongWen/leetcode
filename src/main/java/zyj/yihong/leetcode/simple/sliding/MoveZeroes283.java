package zyj.yihong.leetcode.simple.sliding;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            int num = nums[i];
            int swap = i;
            for (int j = i-1; j >=0 ; j--) {
                if (nums[j]==0){
                    swap = j;
                }
            }

            nums[i] = nums[swap];
            nums[swap] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
