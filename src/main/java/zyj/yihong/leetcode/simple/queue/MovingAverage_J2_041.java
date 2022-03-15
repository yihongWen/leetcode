package zyj.yihong.leetcode.simple.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qIsx9U
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingAverage_J2_041 {

    private Queue<Integer> queue;
    private int maxCount;
    private int sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage_J2_041(int size) {
        queue = new ArrayDeque<>();
        maxCount = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size()==maxCount){
            Integer poll = queue.poll();
            sum = sum-poll;
        }

        queue.add(val);
        sum = sum+val;
        return  (double)sum/queue.size();
    }

    public static void main(String[] args) {
        MovingAverage_J2_041 movingAverage_j2_041 = new MovingAverage_J2_041(3);
        List<Integer> integers = Arrays.asList(1, 10, 3, 5);
        for (int i = 0; i < integers.size(); i++) {
            double next = movingAverage_j2_041.next(integers.get(i));
            System.out.println(next);
        }

    }
}
