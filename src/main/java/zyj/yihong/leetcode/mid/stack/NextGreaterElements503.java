package zyj.yihong.leetcode.mid.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElements503 {

    /**
     * 单调栈循环数组（相当于遍历两次）
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] retValue = new int[nums.length];
        Arrays.fill(retValue,-1);

        // stack 存index值
        Stack<Integer> stack = new Stack<>();

        // 遍历0->length-1,对于length-1而言，需要遍历 0 ->length-2
        for (int i = 0; i < nums.length*2-1; i++) {
            while (!stack.isEmpty()&& nums[i% nums.length]>nums[stack.peek()]){
                Integer pop = stack.pop();
                retValue[pop] = nums[i% nums.length];
            }

            stack.push(i% nums.length);
        }

        return retValue;
    }
}
