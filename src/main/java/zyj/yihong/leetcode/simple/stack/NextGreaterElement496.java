package zyj.yihong.leetcode.simple.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 */
public class NextGreaterElement496 {

    /**
     * 使用单调栈来解决
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] retArr = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> singleNumValueMap = new HashMap<>(nums2.length);

        // 初始化构造每个值的结果
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curValue = nums2[i];
            while (!stack.isEmpty()&&curValue>stack.peek()){
                stack.pop();
            }

            if (stack.isEmpty()){
                singleNumValueMap.put(curValue,-1);
            }else {
                singleNumValueMap.put(curValue,stack.peek());
            }
            stack.push(curValue);
        }

        // 遍历num1，在map找到对应的每一个结果
        for (int i = 0; i < nums1.length; i++) {
            int i1 = nums1[i];
            Integer value = singleNumValueMap.get(i1);
            retArr[i]  = value;
        }

        return retArr;

    }
}
