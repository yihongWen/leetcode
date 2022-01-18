package zyj.yihong.leetcode.mid;

import java.util.Arrays;

/**
 * 80. 删除有序数组中的重复项 II
 */
public class RemoveDuplicates80 {

    /**
     * 使用双指针
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int retCurIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[retCurIndex - 2]) {
                nums[retCurIndex] = nums[i];
                retCurIndex++;
            }
        }
        return retCurIndex;
    }

    public static void main(String[] args) {
        int[] testArr = {1, 1, 1, 2, 2, 3};
        int index = removeDuplicates(testArr);
        System.out.println(Arrays.toString(testArr));
        System.out.println(index);
    }

}
