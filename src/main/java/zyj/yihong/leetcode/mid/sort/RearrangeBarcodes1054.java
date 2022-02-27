package zyj.yihong.leetcode.mid.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 *
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 */
public class RearrangeBarcodes1054 {
    /**
     * 堆，参考767
     * @param barcodes
     * @return
     */
    public static int[] rearrangeBarcodes(int[] barcodes) {

        int[] ret = new int[barcodes.length];
        int addRetIndex = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int barcode : barcodes) {
            countMap.put(barcode,countMap.getOrDefault(barcode,0)+1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1,o2)-> countMap.get(o2)-countMap.get(o1));

        priorityQueue.addAll(countMap.keySet());


        while (priorityQueue.size()>1){
            Integer poll = priorityQueue.poll();
            Integer poll1 = priorityQueue.poll();
            ret[addRetIndex] = poll;
            addRetIndex++;
            ret[addRetIndex] = poll1;
            addRetIndex++;
            countMap.put(poll,countMap.get(poll)-1);
            countMap.put(poll1,countMap.get(poll1)-1);

            if (countMap.get(poll)>0){
                priorityQueue.add(poll);
            }

            if (countMap.get(poll1)>0){
                priorityQueue.add(poll1);
            }
        }

        if (priorityQueue.size()==1){
            ret[addRetIndex] = priorityQueue.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,3,3};
        int[] ints = rearrangeBarcodes(arr);
        System.out.println(Arrays.toString(ints));
    }
}
