package zyj.yihong.leetcode.simple.stack;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 */
public class MinStack155 {
    private Stack<Integer> innerStack;
    private int min;
    public MinStack155() {
        innerStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        int pushMin = Math.min(min, val);
        min = pushMin;
        innerStack.push(pushMin);
        innerStack.push(val);
    }

    public void pop() {
        innerStack.pop();
        innerStack.pop();
        if (innerStack.size()==0){
            min = Integer.MAX_VALUE;
            return;
        }
        Integer pop = innerStack.pop();
        Integer peek = innerStack.peek();
        min = peek;
        innerStack.push(pop);
    }

    public int top() {
        return innerStack.peek();

    }

    public int getMin() {
        Integer pop = innerStack.pop();
        int ret = innerStack.peek();
        innerStack.push(pop);
        return ret;
    }

    public static void main(String[] args) {
        String[] test =  {"MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"};
        String s = "[[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]\n";
        Gson gson = new Gson();
        List<Integer> ret = new ArrayList<>();
        ret.add(null);
        MinStack155 minStack155 = new MinStack155();
        List<List<Double>> list = gson.fromJson(s, List.class);
        for (int i = 0; i < test.length; i++) {
            String s1 = test[i];
            if (s1.equals("push")){
                minStack155.push(list.get(i).get(0).intValue());
                ret.add(null);
            }else if (s1.equals("top")){
                int top = minStack155.top();
                ret.add(top);
            }else if (s1.equals("pop")){
                minStack155.pop();
                ret.add(null);
            }else if (s1.equals("getMin")) {
                int min = minStack155.getMin();
                ret.add(min);
            }
        }
        System.out.println(ret);
        //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        //[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483646]
        //[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
    }


}
