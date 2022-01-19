package zyj.yihong.leetcode.mid;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class SingleNumber137 {

    /**
     * 二进制位： 每一位都是三的整数或者是4  %3即可
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        // 每次外层循环相当于计算结果的第i位二进制
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count = count +((num>>i) & 1);
            }
            ret = ((count%3)<<i) | ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] testArr = {0,1,0,1,0,1,99};
        int i = singleNumber(testArr);
        System.out.println(i);
    }
}
