package zyj.yihong.leetcode.mid.sort;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequent347 {
    public static int[] topKFrequent(int[] nums, int k) {

        // 使用map先统计个数
        Map<Integer,Integer> calMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            calMap.put(nums[i],calMap.getOrDefault(nums[i],0)+1);
        }

        // 使用堆（最小堆，优先队列的方式,设置优先原则）
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1)-o2.get(1);
            }
        });

        // 将map中的数据放置到优先队列中
        calMap.forEach((key,value)->{
            if (priorityQueue.size()<k){
                List<Integer> addList = new ArrayList<>();
                addList.add(key);
                addList.add(value);
                priorityQueue.add(addList);
            }else if (priorityQueue.size()==k){
                // 判断是否需要插入
                if (value>priorityQueue.peek().get(1)){
                    priorityQueue.poll();
                    List<Integer> addList = new ArrayList<>();
                    addList.add(key);
                    addList.add(value);
                    priorityQueue.add(addList);
                }
            }
        });

        // 取出优先队列中的值
        int[] retArray = new int[k];
        int curIndex = 0;
        for (List<Integer> item : priorityQueue) {
            retArray[curIndex] = item.get(0);
            curIndex++;
        }
        return retArray;
    }

    public static void main(String[] args) {
        int[] testArr = {1,1,1,2,2,3};
        int[] ints = topKFrequent(testArr, 1);
        System.out.println(Arrays.toString(ints));
    }
}
