package zyj.yihong.leetcode.random_select.nov;

import java.util.Stack;

// 面试题 03.02. 栈的最小值
public class MinStack_S_M0302 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack_S_M0302() {

    }

    public void push(int x) {
        if (minStack.isEmpty() || minStack.peek()>x){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
