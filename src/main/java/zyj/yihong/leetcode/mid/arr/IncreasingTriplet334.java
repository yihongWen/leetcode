package zyj.yihong.leetcode.mid.arr;

/**
 * 334. 递增的三元子序列
 */
public class IncreasingTriplet334 {
    public static boolean increasingTriplet(int[] nums) {
        if (nums==null || nums.length<3){
            return false;
        }
        int min = nums[0];
        int max = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>min&&nums[i]<max){
                max = nums[i];
            }else if (nums[i]>max){
                return true;
            }else if (nums[i]<min){
                min = nums[i];
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = {5,1,6};
        boolean b = increasingTriplet(arr);
        System.out.println(b);
    }
}
