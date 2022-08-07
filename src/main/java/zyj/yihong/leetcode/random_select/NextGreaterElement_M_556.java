package zyj.yihong.leetcode.random_select;

import java.util.Arrays;

// 556. 下一个更大元素 III
public class NextGreaterElement_M_556 {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i]-'0';
        }

        nextPermutation(nums);
        if (nums[0]==-1){
            return -1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(nums[i]);
        }
        long num = Long.parseLong(stringBuilder.toString());
        if (num>Integer.MAX_VALUE){
            return -1;
        }
        return (int) num;

    }


    public void nextPermutation(int[] nums) {
        // 从右侧起第一个小的值 index1
        int index1 = -1;
        int index2 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i]<nums[i+1]){
                index1 = i;
                index2 = i+1;
                break;
            }
        }

        // 如果index1==-1,此时为最大值，直接反转为最小值
        if (index1==-1){
            nums[0]=-1;
            return;
        }

        // 从右侧起找到第一个比index1大的值,index2
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i]>nums[index1]){
                index2 = i;
                break;
            }
        }

        // 交换index1 跟index2
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

        // 将右侧递减段，处理为递增段
        segReverse(nums,index1+1);

    }

    private void segReverse(int[] arr,int i){
        int left = i;
        int right = arr.length-1;
        while (left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }



    public static void main(String[] args) {
//        NextGreaterElement_M_556 nextGreaterElement_m_556 = new NextGreaterElement_M_556();
//        int[] arr = {1,2};
//        int i = nextGreaterElement_m_556.nextGreaterElement(2147483486);
//        System.out.println(i);

        System.out.println(Long.parseLong("2147483648"));

    }

}
