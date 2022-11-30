package zyj.yihong.leetcode.random_select.nov;


import java.util.PriorityQueue;
import java.util.Queue;

// 703. 数据流中的第 K 大元素
public class KthLargest_S_703 {

    // 只进不出，所以只保存前k个最小的元素即可，使用优先队列
    Queue<Integer> queue = new PriorityQueue<>((o1,o2)-> o1-o2);
    int k;
    public KthLargest_S_703(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (queue.size()>=k) {
                queue.offer(nums[i]);
                queue.poll();
                continue;
            }
            queue.offer(nums[i]);
        }
        this.k = k;
    }

    public int add(int val) {
        if (queue.size()>=k){
            queue.offer(val);
            queue.poll();
            return queue.peek();
        }
        queue.offer(val);
        return queue.peek();
    }

    public static void main(String[] args) {
//        ["KthLargest","add","add","add","add","add"]
//[[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
        int[] arr = {4,5,8,2};
        KthLargest_S_703 kthLargest_s_703 = new KthLargest_S_703(3,arr);
        int add1 = kthLargest_s_703.add(3);
        int add2 = kthLargest_s_703.add(5);
        int add3 = kthLargest_s_703.add(10);
        int add4 = kthLargest_s_703.add(9);
        int add5 = kthLargest_s_703.add(4);
        System.out.println(add1);
        System.out.println(add2);
        System.out.println(add3);
        System.out.println(add4);
        System.out.println(add5);
    }

}
