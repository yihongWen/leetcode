package zyj.yihong.leetcode.mid;

/**
 * 寻找峰值：
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 */
public class FindPeakElement162 {

    /**
     * nums[-1] = nums[n]= -∞，i 都有 nums[i] != nums[i + 1]
     * 以上条件可以确定给定数组存在解，数组两端都是断崖式、而且后一个数不能于前一个数相等
     *
     * 根据题目给出的负载度要求：可以使用二分法
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {

        int start = 0;
        int end  = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if (nums[mid]<nums[mid+1]){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {2,1};
        int index = findPeakElement(arr);
        System.out.println(index);
    }


}
