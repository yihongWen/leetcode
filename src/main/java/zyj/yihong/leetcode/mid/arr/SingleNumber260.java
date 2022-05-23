package zyj.yihong.leetcode.mid.arr;

/**
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber260 {

    public int[] singleNumber(int[] nums) {
        // 使用异或计算得出的结果位A^B的结果，此时还是判断不出
        // A跟B的取值，因为如果第i为0,可能的结果是两个为0或者两个为1
        int xorAll = 0;
        for (int i = 0; i < nums.length; i++) {
            xorAll = xorAll^nums[i];
        }

        // 此时需要结果根据出现位数为1，将数据分成两类，分别异或即可得出结果
        // 根据补码：xorAll&(-xorAll),判断可能出现溢出的情况
        int category = xorAll==Integer.MIN_VALUE?xorAll:(xorAll&(-xorAll));

        int A = 0;
        int B = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&category)!=0){
                A = A^nums[i];
            }else {
                B = B^nums[i];
            }
        }
        return new int[]{A,B};
    }
}
