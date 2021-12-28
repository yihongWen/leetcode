package zyj.yihong.leetcode;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * @author yihong
 */
public class MinStack115 {

    private Stack<Integer> valueStack;
    private Stack<Integer> minValueStack;

    /**
     * 初始化数据: 方便比较等，设置min的最初值为最大
     */
    public MinStack115() {
        valueStack = new Stack<>();
        minValueStack = new Stack<>();
        minValueStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        valueStack.push(val);
        // 判断是否是其本身
        minValueStack.push(val<minValueStack.peek()?val:minValueStack.peek());
    }

    public void pop() {
        valueStack.pop();
        minValueStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minValueStack.peek();
    }

    public static void main(String[] args) {
        MinStack115 minStack115 = new MinStack115();
        minStack115.push(10);
        minStack115.push(67);
        minStack115.push(35);
        minStack115.push(21);
        minStack115.push(9);
    }
}
