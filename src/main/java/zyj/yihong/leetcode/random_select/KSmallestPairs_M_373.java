package zyj.yihong.leetcode.random_select;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs_M_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 使用优先队列的方式
        List<List<Integer>> ans = new ArrayList<>();

        // 队列中存储索引队，优先规则，索引对在数组中值越小权重越高
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k,(o1,o2)->{
            return nums1[o1[0]]+nums2[o1[1]]-nums1[o2[0]]-nums2[o2[1]];
        });

        // 为了处理交叉情况，预先处理
        int lessLength = Math.min(nums1.length,k);
        for (int i = 0; i < lessLength; i++) {
            priorityQueue.offer(new int[]{i,0});
        }

        // 计算结果
        while (k>0&&priorityQueue.size()>0){
            int[] indexInfo = priorityQueue.poll();
            List<Integer> curAns = new ArrayList<>();
            curAns.add(nums1[indexInfo[0]]);
            curAns.add(nums2[indexInfo[1]]);
            ans.add(curAns);

            if (indexInfo[1]+1< nums2.length) {
                priorityQueue.offer(new int[]{indexInfo[0], indexInfo[1] + 1});
            }
            k--;

        }
        return ans;

    }
}
