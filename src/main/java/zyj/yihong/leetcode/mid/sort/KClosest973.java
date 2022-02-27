package zyj.yihong.leetcode.mid.sort;

import com.google.gson.Gson;

import java.util.PriorityQueue;

/**
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 * <p>
 * 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
 * <p>
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 */
public class KClosest973 {
    /**
     * 排序+优先队列
     *
     * @param points 点（x,y）
     * @param k      个数
     * @return
     */
    public static int[][] kClosest(int[][] points, int k) {

        if (points.length < k) {
            return null;
        }
        // 定义优先队列
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            // 可能出现溢出的情况
            return (o2[0] * o2[0] + o2[1] * o2[1])-(o1[0] * o1[0] + o1[1] * o1[1]) ;
        });

        for (int[] point : points) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(point);
            } else {
                int[] peek = priorityQueue.peek();
                if ((peek[0] * peek[0] + peek[1] * peek[1]) - (point[0] * point[0] + point[1] * point[1]) > 0) {
                    priorityQueue.poll();
                    priorityQueue.add(point);
                }
            }
        }

        int[][] ret = new int[priorityQueue.size()][2];
        for (int i = 0; priorityQueue.size()>0; i++) {
            ret[i] = priorityQueue.poll();
        }

        return ret;
    }


    public static void main(String[] args) {
        int[][] test = {{-5,4}, {-6,-5}, {4,6}};
        int[][] ints = kClosest(test, 2);
        Gson gson = new Gson();
        String s = gson.toJson(ints);
        System.out.println(s);
    }
}
