package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

// 857. 雇佣 K 名工人的最低成本
public class MincostToHireWorkers_H_857 {
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // 计算出每个工人的单位工资，并从小到大排序
        Integer[] workNum = new Integer[quality.length];
        for (int i = 0; i < workNum.length; i++) {
            workNum[i] = i;
        }
        Arrays.sort(workNum, Comparator.comparingDouble(a -> (double)wage[a] / quality[a]));

        // 定义优先队列
        PriorityQueue<Integer> qualityPriQueue = new PriorityQueue<>((a,b)-> b-a);

        int kQuality = 0;
        double ans = 1e9;
        for (int i = 0; i < k - 1; i++) {
            qualityPriQueue.offer(quality[workNum[i]]);
            kQuality+=quality[workNum[i]];
        }

        for (int i = k-1; i < quality.length; i++) {
            Integer curWorkNum = workNum[i];
            kQuality+=quality[curWorkNum];
            qualityPriQueue.offer(quality[curWorkNum]);
            double maxRate =(double) wage[curWorkNum]/quality[curWorkNum];
            double curAns = maxRate*kQuality;
            ans = Math.min(ans,curAns);

            // 去除q最大的
            Integer maxP = qualityPriQueue.poll();
            kQuality = kQuality - maxP;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] q = {4,4,4,5};
        int[] w = {13,12,13,12};
        int k = 2;
        double v = mincostToHireWorkers(q, w, k);
        System.out.println(v);
    }
}
