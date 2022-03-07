package zyj.yihong.leetcode.simple.stack;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue_J99 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue_J99() {
        stack1 =  new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.size()==0 && stack2.size()==0){
            return -1;
        }
        if (stack2.size()==0){
            while (stack1.size()!=0){
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.pop();
    }
}
