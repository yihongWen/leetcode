package zyj.yihong.leetcode.mid.arr;

import java.util.Arrays;

/**
 * rotate189. 轮转数组
 */
public class Rotate189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int realK = k % length;
        reverse(nums,0,length-1);
        reverse(nums,0,realK-1);
        reverse(nums,realK,length-1);
    }

    private void reverse(int[] nums,int i,int j){
        while (i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Rotate189 rotate189 = new Rotate189();
        rotate189.rotate(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
