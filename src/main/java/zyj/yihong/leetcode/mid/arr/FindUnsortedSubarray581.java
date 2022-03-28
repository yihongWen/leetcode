package zyj.yihong.leetcode.mid.arr;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindUnsortedSubarray581 {
    public static int findUnsortedSubarray(int[] nums) {
        int leftIndex = -1;
        int rightIndex = -1;
        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=rightMax){
                rightMax = nums[i];
            }else {
                rightIndex = i;
            }

            if (nums[nums.length-i-1]<=leftMin){
                leftMin = nums[nums.length-i-1];
            }else {
                leftIndex = nums.length-i-1;
            }
        }

        if (rightIndex!=-1){
            return rightIndex-leftIndex+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3};
        int unsortedSubarray = findUnsortedSubarray(arr);
        System.out.println(unsortedSubarray);
    }
}
