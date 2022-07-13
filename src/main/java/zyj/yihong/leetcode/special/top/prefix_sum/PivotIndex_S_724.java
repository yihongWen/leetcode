package zyj.yihong.leetcode.special.top.prefix_sum;

/**
 * 724. 寻找数组的中心下标
 */
public class PivotIndex_S_724 {
    public static int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i]+nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (preSum[i] == preSum[nums.length]-preSum[i+1]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        int index = pivotIndex(arr);
        System.out.println(index);
    }
}
