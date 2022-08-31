package zyj.yihong.leetcode.random_select.aug;


import java.util.LinkedList;
import java.util.Stack;

// 946. 验证栈序列
public class ValidateStackSequences_M_946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 1; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed  = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println(b);
    }
}
