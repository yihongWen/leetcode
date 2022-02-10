package zyj.yihong.leetcode.mid.sort;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 *
 *
 * 解题思路
 * 1：排序，左右挨个插入数据（数据的值比较小 5000，可以考虑计数排序的思路）
 *
 * 2：不需要排序，只需要使用快排的方式找到中间。
 */
public class WiggleSort324 {

    /**
     * 使用计数的方式
     * @param nums
     */
    public static void wiggleSort1(int[] nums) {
        // 定义数组:题目给定最大数为5000
        int[] countingArr = new int[5001];
        for (int num : nums) {
            countingArr[num]++;
        }

        //确定末尾的高低,如何是奇数，最后一个数是低位，偶数最后一位是高位
        int maxIndexHigh;
        int maxIndexLow;
        if((nums.length&1)==1){
            maxIndexLow=nums.length-1;
            maxIndexHigh= nums.length-2;
        }else{
            maxIndexLow=nums.length-2;
            maxIndexHigh= nums.length-1;
        }
        int start = 0;
        int end = 5000;
        for (int i = 1; i <= maxIndexHigh;) {
            while (true){
                if (countingArr[end]==0){
                    end--;
                    continue;
                }
                nums[i] = end;
                i = i+2;
                countingArr[end]--;
                break;
            }
        }

        for (int i = maxIndexLow; i >= 0;) {
            while (true){
                if (countingArr[start]==0){
                    start++;
                    continue;
                }
                nums[i] = start;
                i = i-2;
                countingArr[start]--;
                break;
            }

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort2(int[] nums) {
        // 找到nums中间元素 快排 找到k大元素
        int k = nums.length/2;
        findKthLargest(nums,k);

        // 三路划分
        int left = 0;
        int curIndex = 0;
        int right = nums.length-1;
        while(curIndex<right){
            if (nums[curIndex]<nums[k]){
                int temp = nums[curIndex];
                nums[curIndex] = nums[left];
                nums[left] = temp;
                curIndex++;
                left++;

            }else if (nums[curIndex]>nums[k]){
                int temp = nums[curIndex];
                nums[curIndex] = nums[right];
                nums[right] = temp;
                right--;
            }else {
                curIndex++;
            }
        }

        //确定末尾的高低,如何是奇数，最后一个数是低位，偶数最后一位是高位
        int maxIndexHigh;
        int maxIndexLow;
        if((nums.length&1)==1){
            maxIndexLow=nums.length-1;
            maxIndexHigh= nums.length-2;
        }else{
            maxIndexLow=nums.length-2;
            maxIndexHigh= nums.length-1;
        }
        int[] temp = new int[nums.length];
        System.arraycopy(nums,0,temp,0,nums.length);

        //

        int tempIndex = temp.length-1;
        for (int i = 1; i <= maxIndexHigh;) {
            nums[i]  = temp[tempIndex];
            tempIndex--;
            i = i+2;
        }

        for (int i = 0; i <= maxIndexLow;) {
            nums[i]  = temp[tempIndex];
            tempIndex--;
            i = i+2;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int findKthLargest(int[] nums, int k) {
        // 利用快速排序的思想：
        int left = 0;
        int right = nums.length-1;
        int index = portition(nums,left,right);
        int flag = k;
        while(index!=flag){
            if(index>flag){
                right = index-1;
                index = portition(nums,left,right);
            }else{
                k= k-(index-left+1);
                left = index+1;
                index = portition(nums,left,right);
            }
        }

        return nums[index];
    }

    public static int portition(int[] nums,int left,int right){
        int p = left-1;

        // 遍历
        for(int i = left;i<right;i++){
            if(nums[i]<=nums[right]){
                int temp = nums[i];
                nums[i] = nums[++p];
                nums[p] = temp;
            }
        }
        int temp = nums[right];
        nums[right] = nums[++p];
        nums[p] = temp;

        return p;
    }

    public static void main(String[] args) {
        int[] testArr = {5,3,1,2,6,7,8,5,5};
        wiggleSort2(testArr);

        System.out.println(Arrays.toString(testArr));
    }





}
