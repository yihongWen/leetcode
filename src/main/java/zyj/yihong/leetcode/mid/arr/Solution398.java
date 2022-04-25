package zyj.yihong.leetcode.mid.arr;

import java.util.Random;

/**
 * 398. 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution398 {
    private int[] arr;
    private Random random;
    public Solution398(int[] nums) {
        this.arr = nums;
        this.random = new Random(System.currentTimeMillis());
    }

    public int pick(int target) {
        // 遍历数组
        int targetCount = 0;
        int retIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (target==arr[i]){
                targetCount++;
                // 抽样：判断是否选择当前这一个
                // 如果只有一个那么必定选择。
                if (random.nextInt(targetCount)==0){
                    retIndex = i;
                }
            }
        }
        return retIndex;
    }
}
