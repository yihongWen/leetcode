package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 1608. 特殊数组的特征值
public class SpecialArray_S_1608 {
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i <= nums.length; i++) {
            // 有i个数大于i
            if (nums[nums.length-i]>=i&&(i==nums.length || nums[nums.length-i-1]<i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5};
        int i = specialArray(arr);
        System.out.println(i);
    }
}
