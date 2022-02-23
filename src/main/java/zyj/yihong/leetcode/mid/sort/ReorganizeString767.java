package zyj.yihong.leetcode.mid.sort;

import java.util.PriorityQueue;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class ReorganizeString767 {

    /**
     * 使用优先队列（大根堆的方式）
     * @param s
     * @return
     */
    public static String reorganizeString(String s) {
        int[] alphabetCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int alphabetIndex = s.charAt(i) - 'a';
            alphabetCount[alphabetIndex]++;

            // 如果某个字符超过一半，则不满足，直接返回空字符串
            if (alphabetCount[alphabetIndex]>((s.length()+1)/2)){
                return "";
            }
        }

        // 定义优先队列（优先规则）、以及初始化数据
        PriorityQueue<Character> heapQueue = new PriorityQueue<>((o1, o2) -> alphabetCount[o2-'a']-alphabetCount[o1-'a']);
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i]>0){
                heapQueue.add((char)('a'+i));
            }
        }

        StringBuilder retString = new StringBuilder();
        while (heapQueue.size()>1){
            Character poll = heapQueue.poll();
            Character poll1 = heapQueue.poll();

            alphabetCount[poll-'a']--;
            alphabetCount[poll1-'a']--;
            retString.append(poll).append(poll1);

            if (alphabetCount[poll-'a']>0){
                heapQueue.add(poll);
            }

            if (alphabetCount[poll1-'a']>0){
                heapQueue.add(poll1);
            }
        }

        if (heapQueue.size()>0){
            retString.append(heapQueue.poll());
        }

        return retString.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        String ret = reorganizeString(s);
        System.out.println(ret);

    }
}
