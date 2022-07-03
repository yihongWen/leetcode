package zyj.yihong.leetcode.mid.arr;

import java.util.Arrays;

public class TwoSum167 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left<right){
            int curValue = numbers[left]+numbers[right];
            if (curValue<target){
                left++;
            }else if (curValue>target){
                right--;
            }else {
                return new int[]{left, right};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] ints = twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));
    }
}
