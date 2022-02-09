package zyj.yihong.leetcode.mid.sort;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 */
public class MaximumGap164 {

    /**
     * 先对数组进行排序，然后遍历找到最佳的值
     * 关键就是排序的效率，比较排序的NlogN、所以这里选用基数排序（计数排序可能占用大量无用空间）
     * @param nums
     * @return
     */
    public static int maximumGap(int[] nums) {
        if (nums==null || nums.length<2){
            return 0;
        }
        // 基数排序
        int divideNum = 1;
        // 找到最大的值（也就是位数最多），用于确定停止
        int maxNums = Integer.MIN_VALUE;
        for (int j : nums) {
            maxNums = Math.max(maxNums, j);
        }

        while (maxNums/divideNum!=0){

            // 定义0-9桶的位置，定义当前位的排序结果
            int[] digitsNumArr = new int[10];
            int[] curSortArr = new int[nums.length];

            // 落到桶中
            for (int num : nums) {
                digitsNumArr[(num / divideNum) % 10]++;
            }

            // 计算桶的累计数
            for (int i = 1; i < digitsNumArr.length; i++) {
                digitsNumArr[i]+= digitsNumArr[i-1];
            }

            // 计算当前位的排序结果
            for (int i = nums.length - 1; i >= 0; i--) {
                int i1 = (nums[i] / divideNum) % 10;
                curSortArr[digitsNumArr[i1]-1] = nums[i];
                digitsNumArr[i1]--;
            }

            // 将当前的排序结果更新到原数组中
            System.arraycopy(curSortArr, 0, nums, 0, nums.length);
            divideNum = divideNum*10;
        }

        // 计算结果
        int retValue = 0;
        for (int i = 1; i < nums.length; i++) {
            retValue = Math.max(nums[i] - nums[i - 1], retValue);
        }
        return retValue;
    }

    public static void main(String[] args) {
        int[] testArr = {3,6,9,1};
        int i = maximumGap(testArr);
        System.out.println(i);
    }
}
