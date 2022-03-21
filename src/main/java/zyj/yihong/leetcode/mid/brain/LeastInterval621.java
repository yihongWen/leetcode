package zyj.yihong.leetcode.mid.brain;

import java.util.HashMap;
import java.util.Map;

/**
 * 621. 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 */
public class LeastInterval621 {
    public static int leastInterval(char[] tasks, int n) {
        int time = 0;
        Map<Character,Integer> taskCountMap = new HashMap<>();

        // 统计每个任务的个数
        for (char task : tasks) {
            taskCountMap.put(task,taskCountMap.getOrDefault(task,0)+1);
        }

        // 定义数组表示每个任务的个数，以及任务下一次执行的时间点
        int[] taskCount = new int[taskCountMap.size()];
        int[] taskTime = new int[taskCountMap.size()];
        int i = 0;
        for (Integer value : taskCountMap.values()) {
            taskCount[i] = value;
            taskTime[i] = 1;
            i++;
        }

        // 遍历所有的任务，找到最佳时间
        for (int i1 = 0; i1 < tasks.length; i1++) {
            // 当前最佳
            time++;
            int best = -1;
            int curTime = Integer.MAX_VALUE;

            for (int j = 0; j < taskTime.length; j++) {
                if (curTime>taskTime[j]){
                    curTime = taskTime[j];
                }
            }

            time = Math.max(time,curTime);

            for (int i2 = 0; i2 < taskCount.length; i2++) {
                if (taskCount[i2]>0 && taskTime[i2]<=time){
                    if (best==-1 || taskCount[best]<taskCount[i2]){
                        best = i2;
                    }
                }
            }
            if (best!=-1) {
                taskCount[best]--;
                taskTime[best] = time + n + 1;
            }else {
                i1--;
            }
        }
        return time;
    }

    public static int leastInterval2(char[] tasks, int n) {
        Map<Character,Integer> taskCountMap = new HashMap<>();

        // 统计每个任务的个数
        int max = Integer.MIN_VALUE;
        for (char task : tasks) {
            int count = taskCountMap.getOrDefault(task, 0) + 1;
            taskCountMap.put(task,count);
            max = Math.max(max,count);
        }

        // 定义数组表示每个任务的个数，以及任务下一次执行的时间点

        int maxCount = 0;
        for (Integer value : taskCountMap.values()) {
            if (value==max){
                maxCount++;
            }
        }


        int i1 = (max - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, i1);


    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        int time = leastInterval2(tasks, n);
        System.out.println(time);
    }
}
