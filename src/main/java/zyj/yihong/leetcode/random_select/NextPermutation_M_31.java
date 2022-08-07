package zyj.yihong.leetcode.random_select;

/**
 * 31. 下一个排列
 */
public class NextPermutation_M_31 {
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
            segReverse(nums,0);
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

}
