package zyj.yihong.leetcode.simple.arr;

public class FindRepeatNumber_J03 {
    public static int findRepeatNumber(int[] nums) {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            // 如果index被-max处理过，需要加上
            if (index<0){
                index+=max;
            }
            if (nums[index] < 0) {
                return index;
            }
            nums[index] -= max;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(arr);
        System.out.println(repeatNumber);

    }
}
