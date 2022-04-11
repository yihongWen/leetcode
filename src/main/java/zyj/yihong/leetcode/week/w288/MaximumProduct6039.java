package zyj.yihong.leetcode.week.w288;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 6039. K 次增加后的最大乘积
 */
public class MaximumProduct6039 {
    public static int maximumProduct(int[] nums, int k) {
        Queue<Integer> queue  =  new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        while (k>0){
            Integer poll = queue.poll();
            poll++;
            k--;
            queue.add(poll);
        }

        int ans = 1;
        for (Integer integer : queue) {
            ans = (ans*(integer%1000000007))%(1000000007);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,4};
        int k = 5;
        int i = maximumProduct(arr, k);
        System.out.println(i);
    }
}
