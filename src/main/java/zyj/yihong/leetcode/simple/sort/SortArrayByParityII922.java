package zyj.yihong.leetcode.simple.sort;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 *
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 */
public class SortArrayByParityII922 {

    /**
     * 双指针、交换
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        for ( ;i < nums.length ; i=i+2) {
            if ((nums[i]&1)==1){
                while (true){
                    if ((nums[j]&1)==0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        j = j+2;
                        break;
                    }
                    j = j+2;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,5,7};
        int[] ints = sortArrayByParityII(nums);
        System.out.println(Arrays.toString(ints));

    }
}
