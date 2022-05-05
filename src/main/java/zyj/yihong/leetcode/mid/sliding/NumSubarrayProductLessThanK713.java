package zyj.yihong.leetcode.mid.sliding;

/**
 * 713. 乘积小于 K 的子数组
 */
public class NumSubarrayProductLessThanK713 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // 滑动窗口，right往右走，做乘法运算（添加），当超过k时，left往右走，做除法运算（移除）
        int left = 0;
        int mul = 1;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            mul = mul*nums[right];
            while (mul>=k&&left<=right){
                mul = mul/nums[left];
                left++;
            }

            count+= right-left+1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        int count = numSubarrayProductLessThanK(arr, 100);
        System.out.println(count);
    }
}
