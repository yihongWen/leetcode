package zyj.yihong.leetcode.simple.arr;

/**
 * 905. 按奇偶排序数组
 */
public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0,j=0; i < nums.length; i++) {
            if ((nums[i]&1)==0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }
}
