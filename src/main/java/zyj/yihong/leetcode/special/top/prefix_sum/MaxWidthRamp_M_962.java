package zyj.yihong.leetcode.special.top.prefix_sum;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 962. 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 *
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-width-ramp
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxWidthRamp_M_962 {
    public int maxWidthRamp(int[] nums) {
        Integer[] indexArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexArr[i] = i;
        }

        // 根据nums中的大小对index进行排序
        Arrays.sort(indexArr, Comparator.comparingInt(o -> nums[o]));

        // 至于为什么要更新minIndex:
        // 排序后获取的值都是大于前一个的，如果当前所在的index小于minIndex,此时num[index]>=num[minIndex]
        // 下一个值是当前出现最大的值，为了取得最大坡度，所以需要更新minIndex

        // 出现负数的情况，证明是下坡
        int minIndex = Integer.MAX_VALUE;
        int ans = 0;
        for (Integer index : indexArr) {
            ans = Math.max(ans,index-minIndex);
            minIndex = Math.min(index,minIndex);
        }

        return ans;
    }

    public static int maxWidthRampOptStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[stack.peek()]>nums[i]){
                stack.push(i);
            }
        }

        int ans = 0;
        int right = nums.length-1;
        while (right>=0){
            if (nums[stack.peek()]<=nums[right]){
                ans = Math.max(ans,right- stack.peek());
                stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                continue;
            }
            right--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {9,8,1,0,1,9,4,0,4,1};
        int i = maxWidthRampOptStack(arr);
        System.out.println(i);
    }
}
