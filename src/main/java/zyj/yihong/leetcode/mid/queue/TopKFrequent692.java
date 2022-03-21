package zyj.yihong.leetcode.mid.queue;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequent692 {
    /**
     * 优先队列
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(((o1, o2) -> {
            int result = map.get(o1) - map.get(o2);
            if (result==0){
                return o2.compareTo(o1);
            }
            return result;
        }));

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            queue.add(stringIntegerEntry.getKey());
            if (queue.size()>k){
                queue.poll();
            }
        }

        List<String> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            resultList.add(queue.poll());
        }
        Collections.reverse(resultList);
        return resultList;
    }

    public static void main(String[] args) {
        String[] arr = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> strings = topKFrequent(arr, k);
        System.out.println(strings);
    }
}
