package zyj.yihong.leetcode.simple.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *  
 *
 * 注意：
 *
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 *
 */
public class MyStack225 {
    private Queue<Integer> imitateQueue;
    public MyStack225() {
        imitateQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        imitateQueue.offer(x);
        if (imitateQueue.size()==1){
            return;
        }
        for (int i = 0; i < imitateQueue.size()-1 ; i++) {
            Integer remove = imitateQueue.poll();
            imitateQueue.offer(remove);
        }
    }

    public int pop() {
        return imitateQueue.poll();
    }

    public int top() {
        return imitateQueue.peek();
    }

    public boolean empty() {
        return imitateQueue.size()==0;
    }
}
