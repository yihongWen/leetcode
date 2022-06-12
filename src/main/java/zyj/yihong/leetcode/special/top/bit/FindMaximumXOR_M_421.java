package zyj.yihong.leetcode.special.top.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 *  0 <= nums[i] <= 231 - 1
 */
public class FindMaximumXOR_M_421 {
    public int findMaximumXOR(int[] nums) {
        // 思路：尽可能的在高位能拿到为1的结果
        int ans = 0;

        // 处理每一位
        for (int bitIndex = 30; bitIndex >=0 ; bitIndex--) {
            // 定义set保存最高位到当前位出现过的值
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num>>bitIndex);
            }

            int expAns = (ans<<1)+1;

            // 判断当前位是否可以出现为1的条件:利用异或的条件a^b=c  a=b^c
            boolean expOne = false;
            for (int num : nums) {
                if (set.contains((num>>bitIndex)^expAns)){
                    expOne = true;
                    break;
                }
            }

            ans = expOne?expAns:ans<<1;
        }

        return ans;

    }
}
