package zyj.yihong.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用双队列实现栈
 * @author yihong
 */
public class MyStack225 {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    private Queue<Integer> single = new ArrayDeque<>();

    public MyStack225() {

    }

    public void singlePush(int x){
        int size = single.size();
        single.add(x);
        for (int i = 0; i < size; i++) {
            Integer poll = single.poll();
            single.add(poll);
        }
    }

    public void push(int x) {
        queue2.add(x);
        while (queue1.size()>0){
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int singlePop() {
        if (single.size()>0){
            return single.poll();
        }
        return 0;
    }

    public int pop() {
        if (queue1.size()>0) {
            return queue1.poll();
        }
        return 0;
    }


    public int singleTop(){
        if (single.size()>0) {
            return single.peek();
        }
        return 0;
    }
    public int top() {
        if (queue1.size()>0) {
            return queue1.peek();
        }
        return 0;
    }

    public boolean singleEmpty() {
        return single.size()==0;
    }


    public boolean empty() {
        return queue1.size()==0;
    }


}
