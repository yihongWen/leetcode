package zyj.yihong.leetcode.simple.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class LastStoneWeight1046 {
    /**
     * 优先队列
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int stone : stones) {
            priorityQueue.add(stone);
        }

        while (priorityQueue.size()>=2){
            Integer first = priorityQueue.poll();
            Integer second = priorityQueue.poll();
            int result = first - second;
            if (result!=0){
                priorityQueue.add(result);
            }
        }
        return priorityQueue.size()==1?priorityQueue.poll():0;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        int i = lastStoneWeight(arr);
        System.out.println(i);
    }
}
